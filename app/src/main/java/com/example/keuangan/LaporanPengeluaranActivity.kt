package com.example.keuangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class LaporanPengeluaranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan_pengeluaran)

        val berandabtn = findViewById<ImageButton>(R.id.btnhome)
        val tabunganbtn = findViewById<ImageButton>(R.id.btntbgn)
        val profilbtn = findViewById<ImageButton>(R.id.btnprofil)
        val backbtn = findViewById<ImageButton>(R.id.back)
        val btnlaporlr = findViewById<ImageButton>(R.id.lprlr)
        val btnlapormsk = findViewById<ImageButton>(R.id.lprmsk)

        btnlaporlr.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,LaporanPengeluaranActivity::class.java)
            startActivity(intent)
        })
        btnlapormsk.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,LaporanPemasukanActivity::class.java)
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
}