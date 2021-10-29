package com.projetoIntegrador.cuidese.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.projetoIntegrador.cuidese.R
import com.projetoIntegrador.cuidese.data.network.NetworkClient
import com.projetoIntegrador.cuidese.model.Lancamento
import com.projetoIntegrador.cuidese.model.RegistroDiario
import com.projetoIntegrador.cuidese.model.TokenUsuario
import com.projetoIntegrador.cuidese.viewModel.TokenGlobal
import retrofit2.Call
import retrofit2.Response
import java.util.*

class RegistroGlicemiaView : AppCompatActivity() {

    lateinit var valorGlicemia: EditText
    lateinit var jejum: CheckBox
    lateinit var btnSalvarDados: Button
    private val service = NetworkClient().service()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_glicemia)
        //Altera o titulo da ToolBar
        supportActionBar?.title = "Registro"

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

    private fun carregarElementos() {
        valorGlicemia = findViewById(R.id.etValor)
        jejum = findViewById(R.id.cbJejum)
        btnSalvarDados = findViewById(R.id.btnSalvarDados)
    }

    private fun carregarEventos() {
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

    fun cadastrarRegistro(view: View) {
        val token = TokenGlobal.tokenGlobal
        val valor = valorGlicemia.text
        var seJejum : Boolean
        seJejum = jejum.isChecked

        val registroDiario = RegistroDiario(0, Integer.parseInt(valor.toString()), null, seJejum,"","")
        var lancamentos = Lancamento(listOf(registroDiario))

        cadastrarRegistroService(token, lancamentos)
    }

    fun cadastrarRegistroService(token: TokenUsuario, lancamento: Lancamento){

        val call: Call<RegistroDiario> = service.cadastrarRegistro(token.retornaToken(),lancamento)
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