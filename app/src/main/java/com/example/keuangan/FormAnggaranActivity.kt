package com.example.keuangan

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FormAnggaranActivity : AppCompatActivity(),DatePickerDialog.OnDateSetListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_anggaran)

        val anggaranluar = findViewById<EditText>(R.id.angran)
        val editTanggal: EditText = findViewById(R.id.tglluar)
        val btnsimpan = findViewById<Button>(R.id.simpan)
        val berandabtn = findViewById<ImageButton>(R.id.btnhome)
        val tabunganbtn = findViewById<ImageButton>(R.id.btntbgn)
        val profilbtn = findViewById<ImageButton>(R.id.btnprofil)
        val backbtn = findViewById<ImageButton>(R.id.back)

        val spinnerKategori = findViewById<Spinner>(R.id.kategori)
        val kategorinya = arrayOf("Air", "Listri", "Makan")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,kategorinya)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerKategori.adapter = adapter

        spinnerKategori.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val selectedCategory = kategorinya[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        editTanggal.setOnClickListener {
            showDatePickerDialog()
        }

        btnsimpan.setOnClickListener(View.OnClickListener{
            val kategori = spinnerKategori.selectedItem.toString()
            val anggran = anggaranluar.text.toString()
            val tanggal = editTanggal.text.toString()
            val simpan = Intent(this, LaporanPengeluaranActivity::class.java)
            startActivity(simpan)
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

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,this, year, month, day)
        datePickerDialog.show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val selectedDate = Calendar.getInstance()
        selectedDate.set(Calendar.YEAR, year)
        selectedDate.set(Calendar.MONTH, month)
        selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val formattedDate = dateFormat.format(selectedDate.time)

        val editTanggal: EditText = findViewById(R.id.tglluar)
        editTanggal.setText(formattedDate)
    }

}