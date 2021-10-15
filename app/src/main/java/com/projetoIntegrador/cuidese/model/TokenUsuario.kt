package com.projetoIntegrador.cuidese.model

class TokenUsuario(
    val token: String,
    val tipoAutenticacao: String
) {
    fun retornaToken() : String{
        return "$tipoAutenticacao $token"
    }
}