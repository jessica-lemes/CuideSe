package com.projetoIntegrador.cuidese.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RetornaRegistros(
    @SerializedName("id")
    @Expose
    val Id : Int,
    @SerializedName("usuario")
    @Expose
    val Usuario: Usuario,
    @SerializedName("lancamentos")
    @Expose
    val Lancamentos : ArrayList<RegistroDiario>
) {
}