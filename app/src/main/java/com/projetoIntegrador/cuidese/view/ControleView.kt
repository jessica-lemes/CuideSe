package com.projetoIntegrador.cuidese.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.projetoIntegrador.cuidese.R
import com.projetoIntegrador.cuidese.data.network.NetworkClient
import com.projetoIntegrador.cuidese.model.RegistroDiario
import com.projetoIntegrador.cuidese.model.RetornaRegistros
import com.projetoIntegrador.cuidese.viewModel.AdapterMovimentacoes
import com.projetoIntegrador.cuidese.viewModel.TokenGlobal
import retrofit2.Call
import retrofit2.Response

class ControleView : AppCompatActivity() {

    lateinit var fabPrincipal: FloatingActionButton
    lateinit var rvPrincipal: RecyclerView
    private val service = NetworkClient().service()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controle)

        //Altera o titulo da ToolBar
        actionBar?.title = "Histórico"

        //Instancia a toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        //Insere o navigationIcon na toolbar e define se ira aparecer ou nao (true or false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_more_vert_24)
        //Seta a ação do icon
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            Intent(this, PrincipalView::class.java).apply {
                startActivity(this)
            }
        })

        carregarElementos()
        carregarEventos()
    }

    //Implementando Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    //Funcionalidades do Menu
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.busca -> {
            Toast.makeText(this, "Buscar item", Toast.LENGTH_LONG).show()
            true
        }
        R.id.home -> {
            Intent(this, PrincipalView::class.java).apply {
                startActivity(this)
            }
            true
        }
        R.id.sair -> {
            Intent(this, LoginView::class.java).apply {
                startActivity(this)
            }
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
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

        lista.sortByDescending { l -> l.id }

        rvPrincipal.adapter = AdapterMovimentacoes(lista, this)
        rvPrincipal.layoutManager = LinearLayoutManager(this)
    }

}