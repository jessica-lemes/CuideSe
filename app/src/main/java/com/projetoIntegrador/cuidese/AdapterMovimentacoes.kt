package com.projetoIntegrador.cuidese

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projetoIntegrador.cuidese.model.Movimentacao
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class AdapterMovimentacoes(val arrayDeMovimentacao: ArrayList<Movimentacao>, val context: Context):
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
        }
    }

    override fun getItemCount(): Int {
        return arrayDeMovimentacao.size
    }
}