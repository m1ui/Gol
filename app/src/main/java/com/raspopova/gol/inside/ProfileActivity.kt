package com.raspopova.gol.inside

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.raspopova.gol.R
import com.raspopova.gol.data.Consts.Companion.DARK_MODE_CHECK
import com.raspopova.gol.data.Consts.Companion.NOTIFICATIONS
import com.raspopova.gol.outside.LoginActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        title = "Профиль"
        enable_notifications.isChecked
                
        //Save Auth
        checkCurrentUser()
        // Notifications
        val notificationPref = getSharedPreferences(NOTIFICATIONS, MODE_PRIVATE)
        val nfEditor = notificationPref.edit()

        enable_notifications.isChecked = notificationPref.getBoolean(NOTIFICATIONS, false)
        enable_notifications.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                nfEditor.putBoolean(NOTIFICATIONS, true)
            } else {
                nfEditor.putBoolean(NOTIFICATIONS, false)
            }
            nfEditor.apply()
        }


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

        // easter_egg
        easter_egg_tv.setOnClickListener{
        }

        tg_me.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/itilga"))
            startActivity(browserIntent)
        }

        vk_me.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/itilga"))
            startActivity(browserIntent)
        }

        inst_me.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/away.php?to=https%3A%2F%2Finstagram.com%2F_itilga%3Figshid%3DYmMyMTA2M2Y%3D&cc_key="))
            startActivity(browserIntent)
        }

        git_me.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/m1ui"))
            startActivity(browserIntent)
        }

        val user = Firebase.auth.currentUser
        username_tv.text = "Логин: " + user?.email

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