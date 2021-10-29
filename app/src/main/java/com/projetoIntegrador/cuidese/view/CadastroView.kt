package com.projetoIntegrador.cuidese.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.projetoIntegrador.cuidese.R
import com.projetoIntegrador.cuidese.data.network.NetworkClient
import com.projetoIntegrador.cuidese.model.RegistroDiario
import com.projetoIntegrador.cuidese.model.RetornaRegistros
import com.projetoIntegrador.cuidese.model.Usuario
import retrofit2.Call
import retrofit2.Response

class CadastroView : AppCompatActivity() {

    lateinit var campoNome: EditText
    lateinit var campoEmail: EditText
    lateinit var campoSenha: EditText
    lateinit var campoConfirmaSenha: EditText
    lateinit var btnTelaCad: Button
    private val service = NetworkClient().service()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        //Altera o titulo da ToolBar
        supportActionBar?.title = "Cadastro"

        carregarElementos()
        carregarEventos()
    }

    private fun carregarElementos(){
        campoNome = findViewById(R.id.etNomeCad)
        campoEmail = findViewById(R.id.etEmailCad)
        campoSenha = findViewById(R.id.etSenhaCad)
        campoConfirmaSenha = findViewById(R.id.etConfirmaSenhaCad)
        btnTelaCad = findViewById(R.id.btnTelaCad)
    }

    private fun carregarEventos(){

    }

    fun cadastro(view: View){

        if(!(campoSenha.text.toString().equals(campoConfirmaSenha.text.toString()))){
            Toast.makeText(this,"Senhas não conferem", Toast.LENGTH_LONG).show()
            return
        }
        var usuario = Usuario(null,campoEmail.text.toString(), campoNome.text.toString(), campoSenha.text.toString())
        cadastrarUsuarioService(usuario)

    }

    fun cadastrarUsuarioService(usuario: Usuario){

        val call: Call<Usuario> = service.cadastrarUsuario(usuario)
        call.enqueue(object : retrofit2.Callback<Usuario> {
            override fun onResponse (
                call: Call<Usuario>,
                response: Response<Usuario>
            ) {
                redirecionarParaTelaPrincipal()
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                t
            }
        })
    }
    fun redirecionarParaTelaPrincipal(){
        Intent(this, PrincipalView::class.java).apply {
            startActivity(this)
        }
    }

    fun redirecionarParaLogin(view: View){
        Intent(this, LoginView::class.java).apply {
            startActivity(this)
        }
    }


}