package com.projetoIntegrador.cuidese.viewModel

import android.app.Application
import com.projetoIntegrador.cuidese.model.TokenUsuario

class TokenGlobal : Application() {
    companion object {
        lateinit var tokenGlobal: TokenUsuario

        fun adicionaTokenAoTokenGlobal(token: TokenUsuario) {
            tokenGlobal = token
        }
    }
}