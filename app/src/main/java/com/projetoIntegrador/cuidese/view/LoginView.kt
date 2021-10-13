package com.projetoIntegrador.cuidese.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.projetoIntegrador.cuidese.R

class LoginView : AppCompatActivity() {

    lateinit var campoEmail: EditText
    lateinit var campoSenha: EditText
    lateinit var campoCadastro: TextView
    lateinit var btnLogin: Button

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
        login()
        cadastro()
    }

    fun login(){
        btnLogin.setOnClickListener{
            Intent(this, PrincipalView::class.java).apply {
                startActivity(this)
            }
        }
    }

    fun cadastro(){
        campoCadastro.setOnClickListener{
            Intent(this, CadastroView::class.java).apply {
                startActivity(this)
            }
        }
    }



}