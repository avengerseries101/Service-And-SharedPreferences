package com.example.sharedpreferencedemoinkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE)

        buttonLogin.setOnClickListener {
            val loginId = editTextLoginId.text.toString()
            val password = editTextPassword.text.toString()
            val keepLoggedIn = checkBoxKeepLoggedIn.isChecked

            Toast.makeText(this, "Successfully LoggedIn!!", Toast.LENGTH_LONG)

            val editor = sharedPreferences.edit()
            editor.putString("id", loginId)
            editor.putString("pass", password)
            editor.putBoolean("check", keepLoggedIn)
            editor.apply()
        }

        buttonShowDetails.setOnClickListener {
            val loginId = sharedPreferences.getString("id", "")
            val password = sharedPreferences.getString("pass", "")
            val keepLoggedIn = sharedPreferences.getBoolean("check", false)

            textViewShowDetail.text =
                "Email : $loginId \nPassword : $password\nSave Credentials To login Again : $keepLoggedIn "
        }
    }
}
