package com.projetoIntegrador.cuidese.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate
import java.util.*

data class RegistroDiario(

    @SerializedName("id")
    val id: Int,
    @SerializedName("dado")
    val valor: Int,
    @SerializedName("data")
    val data: String?,
    @SerializedName("jejum")
    val jejum: Boolean,

    var dataTexto : String,
    var horaTexto : String

) {
    fun populaDataHora(){
        var divisaoDataHora = data.toString().split("T")
        var dataSeparada = divisaoDataHora[0]
        var horaSeparada = divisaoDataHora[1]

        var dataSplit = dataSeparada.split("-")
        dataTexto = "Data: " + dataSplit[2]+"/"+dataSplit[1]+"/"+dataSplit[0]

        var horaSplit = horaSeparada.split(":")
//        var horaInt = Integer.parseInt(horaSplit[0])-3
        horaTexto = "Hora: " + horaSplit[0] +":"+horaSplit[1]
    }

}