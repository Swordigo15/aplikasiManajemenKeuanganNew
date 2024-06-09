package com.example.keuangan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LaporanPemasukanActivity : AppCompatActivity() {

    private lateinit var rvPemasukan: RecyclerView
    private val list = ArrayList<PemasukanResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan_pemasukan)

        rvPemasukan = findViewById(R.id.rv_pemasukan)
        rvPemasukan.setHasFixedSize(true)

        // Load data from SharedPreferences
        loadPemasukanData()

        rvPemasukan.layoutManager = LinearLayoutManager(this)
        val listPemasukanAdapter = ListPemasukanAdapter(list)
        rvPemasukan.adapter = listPemasukanAdapter

        val berandabtn = findViewById<ImageButton>(R.id.btnhome)
        val tabunganbtn = findViewById<ImageButton>(R.id.btntbgn)
        val profilbtn = findViewById<ImageButton>(R.id.btnprofil)
        val backbtn = findViewById<ImageButton>(R.id.back)
        val btnlaporlr = findViewById<ImageButton>(R.id.lprlr)

        btnlaporlr.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, LaporanPengeluaranActivity::class.java)
            startActivity(intent)
        })
        // Add other button listeners as needed
    }

    private fun loadPemasukanData() {
        val sharedPreferences = getSharedPreferences("PemasukanData", Context.MODE_PRIVATE)
        val gson = Gson()
        val dataSetType = object : TypeToken<MutableList<PemasukanResponse>>() {}.type
        val dataSet: MutableList<PemasukanResponse> = gson.fromJson(sharedPreferences.getString("pemasukanList", "[]"), dataSetType)

        list.addAll(dataSet)
    }
}
