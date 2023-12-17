package com.example.keuangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LaporanPemasukanActivity : AppCompatActivity() {

    private lateinit var laporanCardView: CardView
    private lateinit var tanggalTextView: TextView
    private lateinit var catatanTextView: TextView
    private lateinit var jumlahTextView: TextView
    private lateinit var totalSaldoTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan_pemasukan)

        laporanCardView = findViewById(R.id.lprn)
        tanggalTextView = findViewById(R.id.tanggalTextView)
        catatanTextView = findViewById(R.id.catatanTextView)
        jumlahTextView = findViewById(R.id.jumlahTextView)
        totalSaldoTextView = findViewById(R.id.totalSaldo)



        val berandabtn = findViewById<ImageButton>(R.id.btnhome)
        val tabunganbtn = findViewById<ImageButton>(R.id.btntbgn)
        val profilbtn = findViewById<ImageButton>(R.id.btnprofil)
        val backbtn = findViewById<ImageButton>(R.id.back)
        val btnlaporlr = findViewById<ImageButton>(R.id.lprlr)


        btnlaporlr.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,LaporanPengeluaranActivity::class.java)
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
