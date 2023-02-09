package com.raspopova.gol.outside

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.raspopova.gol.R
import com.raspopova.gol.data.Consts
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Check Dark Mode
        val sharedPreferences = getSharedPreferences(Consts.DARK_MODE_CHECK, MODE_PRIVATE)
        if (sharedPreferences.getBoolean(Consts.DARK_MODE_CHECK, false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }


        splash_logo.alpha = 0f
        splash_logo.animate().setDuration(Consts.SPLASH_TIMEOUT.toLong()).alpha(1f).withEndAction{
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }

    }
}