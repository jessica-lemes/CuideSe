package com.projetoIntegrador.cuidese.model

import com.google.gson.annotations.SerializedName

class TokenUsuario(
    @SerializedName("token")val token: String,
    @SerializedName("tipoDeAutenticacao")val tipoAutenticacao: String
) {
    fun retornaToken() : String{
        return "$tipoAutenticacao $token"
    }
}