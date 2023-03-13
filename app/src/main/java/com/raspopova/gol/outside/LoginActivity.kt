package com.raspopova.gol.outside

import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.appcheck.FirebaseAppCheck
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.raspopova.gol.inside.MainActivity
import com.raspopova.gol.R
import com.raspopova.gol.data.Consts.Companion.VK_URL
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Protected Firebase
        FirebaseApp.initializeApp(/*context=*/this)
        val firebaseAppCheck = FirebaseAppCheck.getInstance()
        firebaseAppCheck.installAppCheckProviderFactory(
            PlayIntegrityAppCheckProviderFactory.getInstance()
        )

        // Initialize Firebase Auth
        auth = Firebase.auth

        login_btn.setOnClickListener {
            val email: String = login_edittext.text.toString()
            val password: String = password_edittext.text.toString()
            if (isEmailValid(email)) {
                if (isPasswordValid(password)) {
                    singIn(
                        email = login_edittext.text.toString(),
                        password = password_edittext.text.toString()
                    )
                } else {
                    msgShow("Слишком короткий пароль")
                    updateUI(null)
                }
            }
            else {
                msgShow("По Вашему, $email - это почта?")
                updateUI(null)
            }
        }

        register_btn.setOnClickListener{
            val email: String = login_edittext.text.toString()
            val password: String = password_edittext.text.toString()

            if (isEmailValid(email)) {
                if (isPasswordValid(password)) {
                    createAccount(
                        email = login_edittext.text.toString(),
                        password = password_edittext.text.toString()
                    )
                } else {
                    msgShow("Слишком короткий пароль")
                    updateUI(null)
                }
            } else {
                msgShow("По Вашему, $email - это почта?")
                updateUI(null)
            }
        }

        about_us_clickable_text.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW).setData(Uri.parse(VK_URL))
            startActivity(i)
        }
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        Log.v("auth", currentUser.toString())
        if(currentUser != null){
            successAuth()
        }
    }

    private fun createAccount(email:String, password:String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    msgShow("Вы успешно зарегистрированы")
                    updateUI(user)
                    successAuth()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    msgShow("Регистрация  не удалась")
                    updateUI(null)
                }
            }
    }

    private fun singIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    msgShow("Успешный вход)")
                    val user = auth.currentUser
                    updateUI(user)
                    successAuth()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    //msg
                    msgShow("Возможно что-то не верно")
                    updateUI(null)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?) {
        user.hashCode()
        login_edittext.setText("")
        password_edittext.setText("")
    }

    private fun msgShow(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean{
        return password.length > 4
    }

    private fun successAuth() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()
    }
}