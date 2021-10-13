package com.projetoIntegrador.cuidese.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.projetoIntegrador.cuidese.R

class Splash : AppCompatActivity() {

    // Timer da splash screen
    private val timerSplash = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(
            Runnable
            /* * Exibindo splash com um timer. */
            { // Esse método será executado sempre que o timer acabar
                // E inicia a activity principal
                val intent = Intent( this, LoginView::class.java)
                startActivity(intent)

                // Fecha esta activity
                finish()
            }, timerSplash.toLong()
        )
    }
}