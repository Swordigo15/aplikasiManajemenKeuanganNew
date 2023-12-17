package com.example.keuangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)

        val signup = findViewById<TextView>(R.id.singup)
        initAction()

        signup.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
    fun initAction(){
        val signinButton = findViewById<Button>(R.id.btnsingin)
        signinButton.setOnClickListener{
            register()
        }
    }
    fun register(){
        val usernameEdit = findViewById<EditText>(R.id.username)
        val passwordEdit = findViewById<EditText>(R.id.password)
        val phoneEdit = findViewById<EditText>(R.id.phone)
        val request = RegisterRequest()
        request.email = usernameEdit.text.toString().trim()
        request.password = passwordEdit.text.toString().trim()
        request.no_hp = phoneEdit.text.toString().trim()

        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
        retro.register(request).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {
                    // Login berhasil, arahkan ke halaman home
                    Toast.makeText(
                        this@RegistrasiActivity,
                        "Registrasi Berhasil",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this@RegistrasiActivity, HomeActivity::class.java)
                    startActivity(intent)
                    finish() // Menutup MainActivity agar tidak bisa kembali ke halaman login
                } else {
                    // Response tidak berhasil, tampilkan pesan kesalahan (opsional)
                    Toast.makeText(this@RegistrasiActivity, "Registrasi Gagal", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {

            }
        }
        )
    }
}