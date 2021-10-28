package com.projetoIntegrador.cuidese.data.network

import com.projetoIntegrador.cuidese.model.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("acompanhamento")
    fun retornaTodosRegistros(@Header("Authorization")token: String): Call<List<RetornaRegistros>>

    @POST("create/user")
    fun cadastrarUsuario(@Body usuario : Usuario) : Call<Usuario>

    @POST("acompanhamento")
    fun cadastrarRegistro(@Header("Authorization")token: String, @Body lancamentos: Lancamento) : Call<RegistroDiario>

    @POST("auth")
    fun loginUsuario(@Body login : Usuario) : Call<TokenUsuario>
}