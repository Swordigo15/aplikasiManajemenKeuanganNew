package com.example.keuangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signup = findViewById<TextView>(R.id.singup)

        initAction()

        signup.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RegistrasiActivity::class.java)
            startActivity(intent)
        })
    }

    fun initAction(){
        val signinButton = findViewById<Button>(R.id.btnsingin)
        signinButton.setOnClickListener{
            login()
        }
    }
    fun login(){
        val usernameEdit = findViewById<EditText>(R.id.username)
        val passwordEdit = findViewById<EditText>(R.id.password)
        val request = UserRequest()
        request.email = usernameEdit.text.toString().trim()
        request.password = passwordEdit.text.toString().trim()

        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
        retro.login(request).enqueue(object : retrofit2.Callback<UserResponse>{
            override fun onResponse(
                call: retrofit2.Call<UserResponse>,
                response: retrofit2.Response<UserResponse>
            ) {
                if (response.isSuccessful) {
                    // Login berhasil, arahkan ke halaman home
                    val intent = Intent(this@MainActivity, HomeActivity::class.java)
                    startActivity(intent)
                    finish() // Menutup MainActivity agar tidak bisa kembali ke halaman login
                } else {
                    // Response tidak berhasil, tampilkan pesan kesalahan (opsional)
                    Toast.makeText(this@MainActivity, "Login Gagal", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: retrofit2.Call<UserResponse>, t: Throwable) {

            }

        })
    }
}