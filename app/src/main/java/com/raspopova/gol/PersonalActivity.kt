package com.raspopova.gol

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.raspopova.gol.databinding.ActivityPersonalBinding

class PersonalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPersonalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            signOut()
        }
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