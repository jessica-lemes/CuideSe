package com.projetoIntegrador.cuidese.data.network

import com.projetoIntegrador.cuidese.model.RetornaRegistros
import com.projetoIntegrador.cuidese.model.Usuario
import retrofit2.Call
import retrofit2.http.*
import java.security.AuthProvider


interface ApiService {

    @GET("acompanhamento")
    fun retornaTodosRegistros(@Header("Authorization")token: String): Call<List<RetornaRegistros>>

    @POST("create/user")
    fun cadastrarUsuario(@Body usuario : Usuario) : Call<Usuario>

}