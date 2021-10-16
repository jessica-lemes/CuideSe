package com.projetoIntegrador.cuidese.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate
import java.util.*

data class RegistroDiario(
    @SerializedName("dado")val valor: Int,
    @SerializedName("data")val data: String,
    @SerializedName("hora")val hora: String,
    @SerializedName("anotacao")val anotacao: String,
    @SerializedName("jejum")val jejum: Boolean
) {

}