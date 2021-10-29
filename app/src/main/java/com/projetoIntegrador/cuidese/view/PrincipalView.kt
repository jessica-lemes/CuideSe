package com.projetoIntegrador.cuidese.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.projetoIntegrador.cuidese.R
import com.projetoIntegrador.cuidese.model.GeraDicasRandomicas

class PrincipalView : AppCompatActivity() {

    lateinit var btnRegistroDiario : ImageView
    lateinit var btnHistorico : ImageView
    lateinit var dicas : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        //Instancia a toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        //Insere o navigationIcon na toolbar e define se ira aparecer ou nao (true or false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        actionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_more_vert_24)

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

    //Implementando Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    //Funcionalidades do Menu
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
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