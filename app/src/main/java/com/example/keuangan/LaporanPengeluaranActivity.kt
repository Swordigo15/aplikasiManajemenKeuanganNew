package com.example.keuangan

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LaporanPengeluaranActivity : AppCompatActivity() {
    private lateinit var rv_pengeluaran: RecyclerView
    private val list = ArrayList<DataPengeluaran>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan_pengeluaran)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.laporan_pengeluaran)) { v, insets ->
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
            val intent = Intent(this, LaporanPemasukanActivity::class.java)
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

        rv_pengeluaran = findViewById(R.id.rv_pengeluaran)
        rv_pengeluaran.setHasFixedSize(true)
        list.addAll(getListDataPengeluaran())
        showRecyclerList()
    }

    fun getListDataPengeluaran(): ArrayList<DataPengeluaran> {
        val dataTanggal = resources.getStringArray(R.array.data_tanggal2)
        val dataDeskripsi = resources.getStringArray(R.array.data_deskripsi2)
        val dataNominal = resources.getStringArray(R.array.data_nominal2)
        val listHero = ArrayList<DataPengeluaran>()
        for (i in dataTanggal.indices) {
            val hero = DataPengeluaran(dataTanggal[i], dataDeskripsi[i], dataNominal[i])
            listHero.add(hero)
        }
        return listHero
    }
    private fun showRecyclerList() {
        rv_pengeluaran.layoutManager = LinearLayoutManager(this)
        val listPengeluaranAdapter = ListPengeluaranAdapter(list)
        rv_pengeluaran.adapter = listPengeluaranAdapter
    }
}