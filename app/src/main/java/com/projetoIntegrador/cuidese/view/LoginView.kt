package com.projetoIntegrador.cuidese.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.projetoIntegrador.cuidese.R
import com.projetoIntegrador.cuidese.data.network.NetworkClient
import com.projetoIntegrador.cuidese.model.TokenUsuario
import com.projetoIntegrador.cuidese.model.Usuario
import com.projetoIntegrador.cuidese.viewModel.TokenGlobal
import retrofit2.Call
import retrofit2.Response

class LoginView : AppCompatActivity() {

    lateinit var campoEmail: EditText
    lateinit var campoSenha: EditText
    lateinit var campoCadastro: TextView
    lateinit var btnLogin: Button
    private val service = NetworkClient().service()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        carregarElementos()
        carregarEventos()
    }

    private fun carregarElementos(){
        campoEmail = findViewById(R.id.etEmailLogin)
        campoSenha = findViewById(R.id.etSenhaLogin)
        campoCadastro = findViewById(R.id.tvCadastreSe)
        btnLogin = findViewById(R.id.btnLogin)
    }

    private fun carregarEventos(){
        cadastro()
    }

    fun login(view : View){
        var email = campoEmail.text
        var senha = campoSenha.text

        if (!email.isEmpty()) {
            if (!senha.isEmpty()) {
                var usuario = Usuario(0,email.toString(),"", senha.toString())
                logarUsuario(usuario)
            } else {
                mensagem("Preencha a senha!")
            }
        } else {
            mensagem("Preencha o email!")
        }

    }

    fun logarUsuario(usuario : Usuario){
        val call: Call<TokenUsuario> = service.loginUsuario(usuario)
        call.enqueue(object : retrofit2.Callback<TokenUsuario> {
            override fun onResponse (
                call: Call<TokenUsuario>,
                response: Response<TokenUsuario>
            ) {
                var token = response.body()
                if (token != null) {
                    TokenGlobal.adicionaTokenAoTokenGlobal(token)
                    redirecionarParaTelaPrincipal()
                }
            }
            override fun onFailure(call: Call<TokenUsuario>, t: Throwable) {
                t
            }
        })
    }

    fun redirecionarParaTelaPrincipal(){
        Intent(this, PrincipalView::class.java).apply {
            startActivity(this)
        }
    }

    fun cadastro(){
        campoCadastro.setOnClickListener{
            Intent(this, CadastroView::class.java).apply {
                startActivity(this)
            }
        }
    }

    fun mensagem(msg: String) {
        val duracao = Toast.LENGTH_SHORT
        val toast = Toast.makeText(this, msg, duracao)
        toast.show()
    }



}