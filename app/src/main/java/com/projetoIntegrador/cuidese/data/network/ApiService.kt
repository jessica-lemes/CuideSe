package com.projetoIntegrador.cuidese.data.network

import com.projetoIntegrador.cuidese.model.RetornaRegistros
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import java.security.AuthProvider


interface ApiService {

    @GET("acompanhamento")
    fun retornaTodosRegistros(@Header("Authorization")token: String): Call<List<RetornaRegistros>>


}