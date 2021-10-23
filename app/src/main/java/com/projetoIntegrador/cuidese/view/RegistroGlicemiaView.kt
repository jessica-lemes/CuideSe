package com.projetoIntegrador.cuidese.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.projetoIntegrador.cuidese.R
import com.projetoIntegrador.cuidese.data.network.NetworkClient
import com.projetoIntegrador.cuidese.model.RegistroDiario
import com.projetoIntegrador.cuidese.model.TokenUsuario
import com.projetoIntegrador.cuidese.viewModel.TokenGlobal
import retrofit2.Call
import retrofit2.Response
import java.util.*

class RegistroGlicemiaView : AppCompatActivity() {

    lateinit var valorGlicemia: EditText
    lateinit var data: EditText
    lateinit var hora: EditText
    lateinit var anotacao: EditText
    lateinit var jejum: CheckBox
    lateinit var btnSalvarDados: Button
    private val service = NetworkClient().service()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_glicemia)
        carregarElementos()
        carregarEventos()
    }

    private fun carregarElementos() {
        valorGlicemia = findViewById(R.id.etValor)
        data = findViewById(R.id.etData)
        hora = findViewById(R.id.etHora)
        anotacao = findViewById(R.id.etAnotacao)
        jejum = findViewById(R.id.cbJejum)
        btnSalvarDados = findViewById(R.id.btnSalvarDados)
    }

    private fun carregarEventos() {
    }



    fun cadastrarRegistro(view: View) {
        val token = TokenGlobal.tokenGlobal

        val valor = valorGlicemia.text
        val dataRegistro = data.text
        val hora = hora.text
        val anotacao = anotacao.text
        val seJejum : Boolean

        seJejum = jejum.isChecked

        //val registroDiario = RegistroDiario(0, Integer.parseInt(valor.toString()), null, "", anotacao.toString(),seJejum)
        val registroDiario = RegistroDiario(0, Integer.parseInt(valor.toString()), seJejum)
        cadastrarUsuarioService(token, registroDiario)
    }

    fun cadastrarUsuarioService(token : TokenUsuario, registro :RegistroDiario){

        val call: Call<RegistroDiario> = service.cadastrarRegistro(token.retornaToken(),registro)
        call.enqueue(object : retrofit2.Callback<RegistroDiario> {
            override fun onResponse (
                call: Call<RegistroDiario>,
                response: Response<RegistroDiario>
            ) {
                redirecionarParaHistorico()
            }

            override fun onFailure(call: Call<RegistroDiario>, t: Throwable) {
                t
            }
        })
    }

    fun redirecionarParaHistorico(){
        Intent(this, ControleView::class.java).apply {
            startActivity(this)
        }
    }

}