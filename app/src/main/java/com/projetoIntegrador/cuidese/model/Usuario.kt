package com.projetoIntegrador.cuidese.model

import com.google.gson.annotations.SerializedName

data class Usuario (
    @SerializedName("id")val id: Int?,
    @SerializedName("email")val email : String,
    @SerializedName("nome")val nome : String,
    @SerializedName("senha")val senha : String
){

}

