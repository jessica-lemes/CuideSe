package com.projetoIntegrador.cuidese.model

import android.widget.TextView
import java.util.*

class GeraDicasRandomicas {

    fun geraDicas(): String {
        val dicas = arrayOf(
            "Mantenha uma alimentação balanceada",
            "Pratique atividade física regularmente",
            "Evite o consumo de doces e bebidas alcoólicas",
            "Não fique mais do que 3 horas sem se alimentar",
            "Não esqueça de se hidratar!",
            "Tenha uma boa noite de sono",
            "Coma mais frutas e vegetais",
            "Consuma carboidratos saudáveis"
            )

        val numero = Random().nextInt(dicas.size)
        return dicas[numero]
    }
}