package com.projetoIntegrador.cuidese.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.projetoIntegrador.cuidese.R
import com.projetoIntegrador.cuidese.model.GeraDicasRandomicas

class PrincipalView : AppCompatActivity() {

    lateinit var btnRegistroDiario : ImageView
    lateinit var btnHistorico : ImageView
    lateinit var dicas : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        //Altera o titulo da ToolBar
        supportActionBar?.title = ""
        carregarElementos()
        carregarEventos()
    }

    override fun onResume() {
        super.onResume()
        geraDicas()
    }

    private fun carregarElementos(){
        btnRegistroDiario = findViewById(R.id.ivRegistro)
        btnHistorico = findViewById(R.id.ivHistorico)
        dicas = findViewById(R.id.tvDica)

    }

    private fun carregarEventos(){
        registro()
        historico()
        geraDicas()
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
    fun geraDicas(){
        var dicaRandomica = GeraDicasRandomicas().geraDicas()
        dicas.text = dicaRandomica
    }
}