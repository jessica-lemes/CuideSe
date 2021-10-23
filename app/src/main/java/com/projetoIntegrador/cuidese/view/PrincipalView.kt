package com.projetoIntegrador.cuidese.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.projetoIntegrador.cuidese.R

class PrincipalView : AppCompatActivity() {

    lateinit var btnRegistroDiario : ImageView
    lateinit var btnHistorico : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        carregarElementos()
        carregarEventos()
    }

    private fun carregarElementos(){
        btnRegistroDiario = findViewById(R.id.ivRegistro)
        btnHistorico = findViewById(R.id.ivHistorico)

    }

    private fun carregarEventos(){
        registro()
        historico()
    }

    fun registro(){
        btnRegistroDiario.setOnClickListener{
            Intent(this, RegistroGlicemiaView::class.java).apply { startActivity(this) }
        }
    }

    fun historico(){
        btnHistorico.setOnClickListener{
            Intent(this, ControleView::class.java).apply { startActivity(this) }
        }
    }


}