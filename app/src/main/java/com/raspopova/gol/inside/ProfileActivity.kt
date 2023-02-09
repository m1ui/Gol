package com.raspopova.gol.inside

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.raspopova.gol.R
import com.raspopova.gol.data.Consts.Companion.DARK_MODE_CHECK
import com.raspopova.gol.outside.LoginActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        title = "Профиль"
                
        //Save Auth
        checkCurrentUser()
        
        // Dark Mode
        val sharedPreferences = getSharedPreferences(DARK_MODE_CHECK, MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        enable_dark_mode.isChecked = sharedPreferences.getBoolean(DARK_MODE_CHECK, false)
        enable_dark_mode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putBoolean(DARK_MODE_CHECK, true)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean(DARK_MODE_CHECK, false)
            }
            editor.apply()
        }

        //SignOut
        sign_out_btn.setOnClickListener {
            signOut()
        }

        easter_egg_tv.setOnClickListener{
        }

        val user = Firebase.auth.currentUser
        username_tv.text = user?.email

    }

    private fun checkCurrentUser() {
        // [START check_current_user]
        val user = Firebase.auth.currentUser
        if (user != null) {
            // User is signed in
        } else {
            // No user is signed in
        }
        // [END check_current_user]
    }

    private fun signOut() {
        // [START auth_sign_out]
        Firebase.auth.signOut()
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
        finish()
        // [END auth_sign_out]
    }
}