package com.projetoIntegrador.cuidese.viewModel

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projetoIntegrador.cuidese.R
import com.projetoIntegrador.cuidese.model.RegistroDiario
import kotlin.collections.ArrayList

class AdapterMovimentacoes(val arrayDeMovimentacao: ArrayList<RegistroDiario>, val context: Context):
    RecyclerView.Adapter<ViewHolderMovimentacao>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovimentacao {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.lista_registros, parent,false)
        return ViewHolderMovimentacao(view)
    }

    override fun onBindViewHolder(holder: ViewHolderMovimentacao, position: Int) {
        arrayDeMovimentacao[position].apply {

            this.populaDataHora()

            //Mudando true e false para Sim e Não
            var booleanJejum = this.jejum
            var statusJejum = ""
            if(booleanJejum == true){
                statusJejum = "Sim"
            }else{
                statusJejum = "Não"
            }

            holder.textViewValor.text = this.valor.toString()
            holder.textViewSeJejum.text = statusJejum
            holder.textViewData.text = this.dataTexto
            holder.textViewHora.text = this.horaTexto
        }
    }

    override fun getItemCount(): Int {
        return arrayDeMovimentacao.size
    }
}