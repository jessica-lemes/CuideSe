package com.projetoIntegrador.cuidese.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.projetoIntegrador.cuidese.AdapterMovimentacoes
import com.projetoIntegrador.cuidese.R
import com.projetoIntegrador.cuidese.model.RegistroDiario
import com.projetoIntegrador.cuidese.service.RegistrosService

class ControleView : AppCompatActivity() {

    lateinit var fabPrincipal: FloatingActionButton
    lateinit var rvPrincipal: RecyclerView
    var registroServico: RegistrosService = RegistrosService()

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
        atualizaRecycler()
    }

    fun adicionaGlicemia(view: View) {
        val intent = Intent(this, AddGlicemiaView::class.java)
        startActivity(intent)
    }

    fun atualizaRecycler(){
        //Popular lista com dados
        val lista: ArrayList<RegistroDiario> = registroServico.retornaTodosRegistros()
        rvPrincipal.adapter = AdapterMovimentacoes(lista, this)
        rvPrincipal.layoutManager = LinearLayoutManager(this)
    }

}