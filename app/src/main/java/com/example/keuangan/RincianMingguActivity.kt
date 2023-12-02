package com.example.keuangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView

class RincianMingguActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rincian_minggu)

        val backbtn = findViewById<ImageButton>(R.id.back)
        val haribtn = findViewById<ImageButton>(R.id.hari)
        val minggubtn = findViewById<ImageButton>(R.id.minggu)
        val bulanbtn = findViewById<ImageButton>(R.id.bulan)

        val crdknig = findViewById<CardView>(R.id.crdknig)
        val crdabu = findViewById<CardView>(R.id.crdabu)

        crdknig.setOnClickListener {
            // Change background color to yellow
            crdknig.setBackgroundResource(R.drawable.card_selector)
            // You can also change the color of TextViews if needed
            val text1 = crdknig.findViewById<TextView>(R.id.text1)
            val text2 = crdknig.findViewById<TextView>(R.id.teks)
            text1.setTextColor(resources.getColor(R.color.black))
            text2.setTextColor(resources.getColor(R.color.black))
        }
        // Set click listener for crdabu
        crdabu.setOnClickListener {
            // Change background color to yellow
            crdabu.setBackgroundResource(R.drawable.card_selector)
            // You can also change the color of TextViews if needed
            val text1 = crdabu.findViewById<TextView>(R.id.text1)
            val text2 = crdabu.findViewById<TextView>(R.id.teks)
            text1.setTextColor(resources.getColor(R.color.black))
            text2.setTextColor(resources.getColor(R.color.black))
        }

        backbtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, TabunganActivity::class.java)
            startActivity(intent)
        })
        haribtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RincianTabunganActivity::class.java)
            startActivity(intent)
        })
        minggubtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RincianMingguActivity::class.java)
            startActivity(intent)
        })
        bulanbtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RincianBulanActivity::class.java)
            startActivity(intent)
        })
    }
}