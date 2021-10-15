package com.projetoIntegrador.cuidese.service

import android.widget.Toast
import com.projetoIntegrador.cuidese.data.network.NetworkClient
import com.projetoIntegrador.cuidese.model.RegistroDiario
import com.projetoIntegrador.cuidese.model.RetornaRegistros
import com.projetoIntegrador.cuidese.model.TokenUsuario
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Header

class RegistrosService {

    private val service = NetworkClient().service()

//    fun retornaTodosRegistros(): ArrayList<RegistroDiario> {
//        val  lista: ArrayList<RegistroDiario> = ArrayList()
//        val registro1 = RegistroDiario(100, "13/10/21", "15:00", "", false)
//        val registro2 = RegistroDiario(110, "12/10/21", "15:00", "Comi bolo de festa", false)
//        val registro3 = RegistroDiario(90, "11/10/21", "15:00", "", false)
//
//        lista.add(registro1)
//        lista.add(registro2)
//        lista.add(registro3)
//
//        return lista
//    }

    fun retornaTodosRegistros() : ArrayList<RegistroDiario>{

        val token = TokenUsuario("eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgQ3VpZGUtc2UiLCJzdWIiOiI3IiwiaWF0IjoxNjM0MzE2MDc2LCJleHAiOjE2MzQzMjQ3MTZ9.Qh3NXqPtmWX5y9ijFi8ewAjPczJBX3XQCPiLmiWE4Wg", "Bearer")
        val lista: ArrayList<RegistroDiario> = ArrayList()

        val call: Call<List<RetornaRegistros>> = service.retornaTodosRegistros(token.retornaToken())
        call.enqueue(object : retrofit2.Callback<List<RetornaRegistros>> {
            override fun onResponse (
                call: Call<List<RetornaRegistros>>,
                response: Response<List<RetornaRegistros>>
            ) {
                var retornoAPI = response.body()

                if (retornoAPI != null) {
                    for(item in retornoAPI.toList()){
                        for(lancamento in item.Lancamentos)
                            lista.add(lancamento)
                    }
                }
            }

            override fun onFailure(call: Call<List<RetornaRegistros>>, t: Throwable) {
                t
            }
        })

        return lista
    }

    fun cadastraRegistro(registroDiario: RegistroDiario){
        registroDiario.valor
    }


}


