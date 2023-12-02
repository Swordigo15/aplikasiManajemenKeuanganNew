package com.example.keuangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class TabunganActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabungan)

        val berandabtn = findViewById<ImageButton>(R.id.btnhome)
        val tabunganbtn = findViewById<ImageButton>(R.id.btntbgn)
        val profilbtn = findViewById<ImageButton>(R.id.btnprofil)
        val backbtn = findViewById<ImageButton>(R.id.back)
        val btnformtbg = findViewById<ImageButton>(R.id.btntabngan)

        btnformtbg.setOnClickListener(View.OnClickListener {
          val intent  = Intent(this,FormTabunganActivity::class.java)
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
    fun openNewPage(view: View){
        val intent = Intent(this, RincianTabunganActivity::class.java)
        startActivity(intent)
    }
}