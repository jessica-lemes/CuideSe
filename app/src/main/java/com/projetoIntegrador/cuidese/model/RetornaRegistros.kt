package com.projetoIntegrador.cuidese.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RetornaRegistros(
    @SerializedName("id")
    val Id : Int,
    @SerializedName("usuario")
    val Usuario: Usuario,
    @SerializedName("lancamentos")
    val Lancamentos : ArrayList<RegistroDiario>
) {
}