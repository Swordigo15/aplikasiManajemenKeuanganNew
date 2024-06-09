package com.example.keuangan

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LaporanPemasukanActivity : AppCompatActivity() {

    private lateinit var rv_pemasukan: RecyclerView
    private val list = ArrayList<DataPemasukan>()
    private lateinit var totalSaldoTextView: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan_pemasukan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.laporan_pemasukan)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val berandabtn = findViewById<ImageButton>(R.id.btnhome)
        val tabunganbtn = findViewById<ImageButton>(R.id.btntbgn)
        val profilbtn = findViewById<ImageButton>(R.id.btnprofil)
        val backbtn = findViewById<ImageButton>(R.id.back)
        val btnlaporlr = findViewById<ImageButton>(R.id.lprlr)

        btnlaporlr.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, LaporanPengeluaranActivity::class.java)
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

        rv_pemasukan = findViewById(R.id.rv_pemasukan)
        rv_pemasukan.setHasFixedSize(true)
        list.addAll(getListDataPemasukan())
        showRecyclerList()
    }

    fun getListDataPemasukan(): ArrayList<DataPemasukan> {
        val dataTanggal = resources.getStringArray(R.array.data_tanggal)
        val dataDeskripsi = resources.getStringArray(R.array.data_deskripsi)
        val dataNominal = resources.getStringArray(R.array.data_nominal)
        val listHero = ArrayList<DataPemasukan>()
        for (i in dataTanggal.indices) {
            val hero = DataPemasukan(dataTanggal[i], dataDeskripsi[i], dataNominal[i])
            listHero.add(hero)
        }
        return listHero
    }
    private fun showRecyclerList() {
        rv_pemasukan.layoutManager = LinearLayoutManager(this)
        val listPemasukanAdapter = ListPemasukanAdapter(list)
        rv_pemasukan.adapter = listPemasukanAdapter
    }
}
