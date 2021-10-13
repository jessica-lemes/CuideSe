package com.projetoIntegrador.cuidese.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.projetoIntegrador.cuidese.R

class CadastroView : AppCompatActivity() {

    lateinit var campoNome: EditText
    lateinit var campoEmail: EditText
    lateinit var campoSenha: EditText
    lateinit var campoConfirmaSenha: EditText
    lateinit var btnTelaCad: Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

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
        cadastro()
    }

    fun cadastro(){
        btnTelaCad.setOnClickListener{
            Intent(this, PrincipalView::class.java).apply {
                startActivity(this)
            }
        }
    }

}