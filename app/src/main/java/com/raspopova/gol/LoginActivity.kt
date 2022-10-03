package com.raspopova.gol

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        updateUI(phoneVisible = true, codeVisible = false)

        login_btn.setOnClickListener {
            if (phone_number_edittext.text?.isNotEmpty() == true) {
                updateUI(phoneVisible = false, codeVisible = true)
            } else {
                updateUI(phoneVisible = true, codeVisible = false)
            }
        }
    }

    private fun updateUI(phoneVisible: Boolean, codeVisible: Boolean) {
        phone_number_edittext.setText("")
        code_edittext.setText("")

        if (phoneVisible) {
            showHide(phone_number_cardview, true)
            showHide(code_cardview, false)
        } else if (codeVisible) {
            showHide(code_cardview, true)
            showHide(phone_number_cardview, false)
        } else {
            Toast.makeText(this, "Что-то не так!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showHide(view:View, isVisible: Boolean) {
        view.visibility = if (isVisible){
            View.VISIBLE
        } else{
            View.GONE
        }
    }
}