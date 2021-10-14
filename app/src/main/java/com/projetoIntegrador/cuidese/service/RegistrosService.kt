package com.projetoIntegrador.cuidese.service

import com.projetoIntegrador.cuidese.model.RegistroDiario
import com.projetoIntegrador.cuidese.view.AddGlicemiaView

class RegistrosService {

    fun retornaTodosRegistros(): ArrayList<RegistroDiario> {

        val registro1 = RegistroDiario(100, "13/10/21", "15:00", "", false)
        val registro2 = RegistroDiario(110, "12/10/21", "15:00", "Comi bolo de festa", false)
        val registro3 = RegistroDiario(90, "11/10/21", "15:00", "", false)

        val lista: ArrayList<RegistroDiario> = ArrayList()
        lista.add(registro1)
        lista.add(registro2)
        lista.add(registro3)

        return lista
    }

    fun cadastraRegistro(registroDiario: RegistroDiario){
        registroDiario.valor

    }


}


