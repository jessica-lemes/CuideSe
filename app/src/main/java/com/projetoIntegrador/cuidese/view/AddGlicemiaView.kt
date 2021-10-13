package com.projetoIntegrador.cuidese.view

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.projetoIntegrador.cuidese.R
import java.util.*

class AddGlicemiaView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_glicemia_view)
        carregarElementos()
        carregarEventos()
    }

    lateinit var valorGlicemia: EditText
    lateinit var data: EditText
    lateinit var hora: EditText
    lateinit var anotacao: EditText
    lateinit var btnSalvarDados: Button
    lateinit var calendario: Calendar


    private fun carregarElementos() {
        valorGlicemia = findViewById(R.id.etValor)
        data = findViewById(R.id.etData)
        hora = findViewById(R.id.etHora)
        anotacao = findViewById(R.id.etAnotacao)
        btnSalvarDados = findViewById(R.id.btnSalvarDados)

    }

    private fun carregarEventos() {
        carregaCalendario()
        salvaDados()
    }

    fun carregaCalendario() {
        val calendario = Calendar.getInstance()
        var ano = calendario.get(Calendar.YEAR)
        var mes = calendario.get(Calendar.MONTH)
        var dia = calendario.get(Calendar.DAY_OF_MONTH)

        data.setOnClickListener {
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { DatePicker, ano, mes, dia ->
                //data.text = "" + dia + "/" + (mes + 1) + "/" + ano
                //data.set(ano,mes,dia)
            }, ano, mes, dia)

            datePicker.show()
        }
    }

    fun salvaDados(){

        //Programar a parte que pega as informações e guarda no banco e depois manda pro RecyclerView

        btnSalvarDados.setOnClickListener{
            intent = Intent(this, ControleView::class.java)
            startActivity(intent)
        }
    }

}