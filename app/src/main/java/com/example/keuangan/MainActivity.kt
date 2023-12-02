package com.example.keuangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameEdit = findViewById<EditText>(R.id.username)
        val passwordEdit = findViewById<EditText>(R.id.password)
        val signinButton = findViewById<Button>(R.id.btnsingin)
        val signup = findViewById<TextView>(R.id.singup)

        signinButton.setOnClickListener(View.OnClickListener {
            val username = usernameEdit.text.toString()
            val password = passwordEdit.text.toString()
            val sign = Intent(this, HomeActivity::class.java)
            startActivity(sign)
        })

        signup.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RegistrasiActivity::class.java)
            startActivity(intent)
        })
    }
}