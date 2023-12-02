package com.example.keuangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

class AnggaranActivity : AppCompatActivity() {

    private lateinit var pilihanbulan : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anggaran)

        val berandabtn = findViewById<ImageButton>(R.id.btnhome)
        val tabunganbtn = findViewById<ImageButton>(R.id.btntbgn)
        val profilbtn = findViewById<ImageButton>(R.id.btnprofil)
        val backbtn = findViewById<ImageButton>(R.id.back)
        val btnanggaran = findViewById<ImageButton>(R.id.btnangrn)

        pilihanbulan = findViewById(R.id.pilihanbln)
        val backbutton : ImageButton = findViewById(R.id.backbulan)
        backbutton.setOnClickListener(View.OnClickListener {
            updateBulanText(-1)
        })
        val nextbutton : ImageButton = findViewById(R.id.nextbulan)
        nextbutton.setOnClickListener(View.OnClickListener { {
            updateBulanText(1)
        } })

        btnanggaran.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, FormAnggaranActivity::class.java)
            startActivity(intent)
        })
        berandabtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        })
        tabunganbtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, TabunganActivity::class.java)
            startActivity(intent)
        })
        profilbtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ProfilActivity::class.java)
            startActivity(intent)
        })
        backbtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        })
    }

    private fun updateBulanText(monthOffset: Int) {
        val months = arrayOf("Januari","Februari","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember")
        val currentMonthIndex =  months.indexOf(pilihanbulan.text.toString())
        val newMonthIndex = (currentMonthIndex + monthOffset + months.size) % months.size
        pilihanbulan.text = months[newMonthIndex]
    }
}