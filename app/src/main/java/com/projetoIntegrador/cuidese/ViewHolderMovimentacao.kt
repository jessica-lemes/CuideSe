package com.projetoIntegrador.cuidese

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolderMovimentacao(view: View) : RecyclerView.ViewHolder(view) {
    var textViewValor: TextView
    var textViewData: TextView
    var textViewHora: TextView
    var textViewAnotacao: TextView
    var textViewSeJejum: TextView

    init {

        textViewValor = view.findViewById(R.id.textViewValor)
        textViewData = view.findViewById(R.id.textViewData)
        textViewHora = view.findViewById(R.id.textViewHora)
        textViewAnotacao = view.findViewById(R.id.textViewAnotacao)
        textViewSeJejum = view.findViewById(R.id.textViewSeJejum)

    }
}