package com.projetoIntegrador.cuidese

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projetoIntegrador.cuidese.model.RegistroDiario
import kotlin.collections.ArrayList

class AdapterMovimentacoes(val arrayDeMovimentacao: ArrayList<RegistroDiario>, val context: Context):
    RecyclerView.Adapter<ViewHolderMovimentacao>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovimentacao {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.lista_movimentacao, parent,false)
        return ViewHolderMovimentacao(view)
    }

    override fun onBindViewHolder(holder: ViewHolderMovimentacao, position: Int) {
        arrayDeMovimentacao[position].apply {

            holder.textViewValor.text = this.valor.toString()
            holder.textViewData.text = this.data.toString()
            holder.textViewHora.text = this.hora
            holder.textViewAnotacao.text = this.anotacao
            holder.textViewSeJejum.text = this.jejum.toString()
        }
    }

    override fun getItemCount(): Int {
        return arrayDeMovimentacao.size
    }
}