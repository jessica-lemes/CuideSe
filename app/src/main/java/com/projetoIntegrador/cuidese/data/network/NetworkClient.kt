package com.projetoIntegrador.cuidese.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://spring-boot-cuidese.herokuapp.com/"

class NetworkClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun service(): ApiService = retrofit.create(ApiService::class.java)

}