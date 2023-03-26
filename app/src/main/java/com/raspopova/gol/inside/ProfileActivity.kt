package com.raspopova.gol.inside

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.raspopova.gol.R
import com.raspopova.gol.outside.LoginActivity
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n", "SoonBlockedPrivateApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        title = "Профиль"
        username_tv.text = "Имя"
        surname_tv.text = "Фамилия"
        //Save Auth
        checkCurrentUser()

        //SignOut
        sign_out_btn.setOnClickListener {
            signOut()
        }

        tg_me.setOnClickListener{
            openBrowser("https://t.me/itilga")
        }

        vk_me.setOnClickListener{
            openBrowser("https://vk.com/itilga")
        }

        inst_me.setOnClickListener{
            openBrowser("https://vk.com/away.php?to=https%3A%2F%2Finstagram.com%2F_itilga%3Figshid%3DYmMyMTA2M2Y%3D&cc_key=")
        }

        git_me.setOnClickListener{
            openBrowser("https://github.com/m1ui")
        }

    }

    override fun onResume() {
        super.onResume()
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val name = prefs.getString("name", "Имя")
        val surname = prefs.getString("surname", "Фамилия")
        username_tv.text = name
        surname_tv.text = surname
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            val i = Intent(this, SettingsActivity::class.java)
            startActivity(i)
            onPause()
            // User chose the "Settings" item, show the app settings UI...
            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
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
        cleanShared()
        Firebase.auth.signOut()
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
        MainActivity.CloserClass.activity?.finish()
        finish()
        // [END auth_sign_out]
    }

    private fun sendPasswordReset(email: String) {

        Firebase.auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Email sent.")
                }
            }
        // [END send_password_reset]
    }

    private fun deleteUser() {
        // [START delete_user]
        val user = Firebase.auth.currentUser!!

        user.delete()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    cleanShared()
                    Log.d(TAG, "User account deleted.")
                }
            }
        // [END delete_user]
    }

    private fun cleanShared() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.clear()
        editor.apply()
    }

    private fun openBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }
}