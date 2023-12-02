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

class FormTabunganActivity : AppCompatActivity(),  DatePickerDialog.OnDateSetListener {
    private lateinit var startDateEditText: EditText
    private lateinit var endDateEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_tabungan)

        val impianedit = findViewById<EditText>(R.id.impian)
        val anggranedit = findViewById<EditText>(R.id.anggaranImpian)
        val btnsimpan = findViewById<Button>(R.id.simpan)
        startDateEditText = findViewById(R.id.tglmulai)
        endDateEditText = findViewById(R.id.tglselesai)
        val berandabtn = findViewById<ImageButton>(R.id.btnhome)
        val tabunganbtn = findViewById<ImageButton>(R.id.btntbgn)
        val profilbtn = findViewById<ImageButton>(R.id.btnprofil)
        val backbtn = findViewById<ImageButton>(R.id.back)
        val spinnerSistem = findViewById<Spinner>(R.id.sistem)
        val kategorinya = arrayOf("Harian", "Mingguan", "Bulanan")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,kategorinya)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSistem.adapter = adapter

        spinnerSistem.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
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
        startDateEditText.setOnClickListener {
            showDatePickerDialog(startDateEditText)
        }

        endDateEditText.setOnClickListener {
            showDatePickerDialog(endDateEditText)
        }
        btnsimpan.setOnClickListener(View.OnClickListener{
            val impian = impianedit.text.toString()
            val anggaran = anggranedit.text.toString()
            val tglMulai = startDateEditText.text.toString()
            val tglSelesai = endDateEditText.text.toString()
            val simpan = Intent(this, TabunganActivity::class.java)
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
            val intent = Intent(this, TabunganActivity::class.java)
            startActivity(intent)
        })
    }

    private fun showDatePickerDialog(editText: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, this, year, month, day)
        datePickerDialog.show()

        // Set the EditText when the date is selected
        datePickerDialog.setOnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(Calendar.YEAR, selectedYear)
            selectedDate.set(Calendar.MONTH, selectedMonth)
            selectedDate.set(Calendar.DAY_OF_MONTH, selectedDay)

            val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val formattedDate = dateFormat.format(selectedDate.time)

            editText.setText(formattedDate)
        }
    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val selectedDate = Calendar.getInstance()
        selectedDate.set(Calendar.YEAR, year)
        selectedDate.set(Calendar.MONTH, month)
        selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val formattedDate = dateFormat.format(selectedDate.time)

        val tglMulaiedit: EditText = findViewById(R.id.tglmulai)
        tglMulaiedit.setText(formattedDate)
        val tglSelesaiedit: EditText = findViewById(R.id.tglselesai)
        tglSelesaiedit.setText(formattedDate)
    }
}