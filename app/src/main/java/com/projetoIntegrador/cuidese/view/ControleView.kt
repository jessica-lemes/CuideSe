package com.projetoIntegrador.cuidese.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.projetoIntegrador.cuidese.viewModel.AdapterMovimentacoes
import com.projetoIntegrador.cuidese.R
import com.projetoIntegrador.cuidese.data.network.NetworkClient
import com.projetoIntegrador.cuidese.model.RegistroDiario
import com.projetoIntegrador.cuidese.model.RetornaRegistros
import com.projetoIntegrador.cuidese.viewModel.TokenGlobal
import retrofit2.Call
import retrofit2.Response
import kotlin.collections.ArrayList

class ControleView : AppCompatActivity() {

    lateinit var fabPrincipal: FloatingActionButton
    lateinit var rvPrincipal: RecyclerView
    private val service = NetworkClient().service()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controle)
        carregarElementos()
        carregarEventos()
    }

    private fun carregarElementos() {
        fabPrincipal = findViewById(R.id.fabPrincipal)
        rvPrincipal  = findViewById(R.id.rvPrincipal)
    }

    private fun carregarEventos() {
        retornaDadosService()
    }

    fun adicionaGlicemia(view: View) {
        val intent = Intent(this, RegistroGlicemiaView::class.java)
        startActivity(intent)
    }

    fun retornaDadosService(){
        val token = TokenGlobal.tokenGlobal
        val call: Call<List<RetornaRegistros>> = service.retornaTodosRegistros(token.retornaToken())
        call.enqueue(object : retrofit2.Callback<List<RetornaRegistros>> {
            override fun onResponse (
                call: Call<List<RetornaRegistros>>,
                response: Response<List<RetornaRegistros>>
            ) {
                var retornoAPI = response.body()
                val lista: ArrayList<RegistroDiario> = ArrayList()

                if (retornoAPI != null) {
                    for(item in retornoAPI.toList()){
                        for(lancamento in item.Lancamentos){

                            lista.add(lancamento)
                        }
                    }
                }
                atualizaRecycler(lista)
            }

            override fun onFailure(call: Call<List<RetornaRegistros>>, t: Throwable) {
                t
            }

        })
    }


    fun atualizaRecycler(lista: ArrayList<RegistroDiario>){
        rvPrincipal.adapter = AdapterMovimentacoes(lista, this)
        rvPrincipal.layoutManager = LinearLayoutManager(this)
    }

}