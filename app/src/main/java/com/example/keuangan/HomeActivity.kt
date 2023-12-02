package com.example.keuangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val pemasukanbtn = findViewById<ImageButton>(R.id.pemasukan)
        val pengeluaranbtn = findViewById<ImageButton>(R.id.pengeluaran)
        val laporanbtn = findViewById<ImageButton>(R.id.laporan)
        val anggaranbtn = findViewById<ImageButton>(R.id.anggaran)
        val berandabtn = findViewById<ImageButton>(R.id.btnhome)
        val tabunganbtn = findViewById<ImageButton>(R.id.btntbgn)
        val profilbtn = findViewById<ImageButton>(R.id.btnprofil)

        pemasukanbtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PemasukanActivity::class.java)
            startActivity(intent)
        })
        pengeluaranbtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PengeluaranActivity::class.java)
            startActivity(intent)
        })
        laporanbtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, LaporanActivity::class.java)
            startActivity(intent)
        })
        anggaranbtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AnggaranActivity::class.java)
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
    }
}