package com.example.keuangan

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.util.Calendar
import java.util.Locale

class PemasukanActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemasukan)

        val pemasukanEdit = findViewById<EditText>(R.id.msk)
        val catatanEdit = findViewById<EditText>(R.id.catatan)
        val editTanggal: EditText = findViewById(R.id.tanggal)
        val editJam: EditText = findViewById(R.id.jam)
        val btnsimpan = findViewById<Button>(R.id.simpan)
        val berandabtn = findViewById<ImageButton>(R.id.btnhome)
        val tabunganbtn = findViewById<ImageButton>(R.id.btntbgn)
        val profilbtn = findViewById<ImageButton>(R.id.btnprofil)
        val backbtn = findViewById<ImageButton>(R.id.back)

        editTanggal.setOnClickListener {
            showDatePickerDialog()
        }
        editJam.setOnClickListener {
            showTimePickerDialog()
        }

        btnsimpan.setOnClickListener(View.OnClickListener {
            val pemasukan = pemasukanEdit.text.toString().toLong()
            val catatan = catatanEdit.text.toString()
            val tanggal = LocalDate.parse(editTanggal.text.toString())
            val jam = LocalTime.parse(editJam.text.toString())

            // Simpan data ke SharedPreferences
            val sharedPreferences = getSharedPreferences("PemasukanData", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val gson = Gson()

            val dataSetType = object : TypeToken<MutableList<PemasukanResponse>>() {}.type
            val dataSet: MutableList<PemasukanResponse> = gson.fromJson(sharedPreferences.getString("pemasukanList", "[]"), dataSetType)

            val newPemasukan = PemasukanResponse(0, 0, 0, pemasukan, catatan, tanggal, jam)
            dataSet.add(newPemasukan)
            val json = gson.toJson(dataSet)
            editor.putString("pemasukanList", json)
            editor.apply()

            val simpan = Intent(this, LaporanPemasukanActivity::class.java)
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

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(this, this, hour, minute, true)
        timePickerDialog.show()
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(this, this, year, month, day)
        datePickerDialog.show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val selectedDate = Calendar.getInstance()
        selectedDate.set(Calendar.YEAR, year)
        selectedDate.set(Calendar.MONTH, month)
        selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val formattedDate = dateFormat.format(selectedDate.time)
        val editTanggal: EditText = findViewById(R.id.tanggal)
        editTanggal.setText(formattedDate)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val selectedTime = Calendar.getInstance()
        selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
        selectedTime.set(Calendar.MINUTE, minute)
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val formattedTime = timeFormat.format(selectedTime.time)
        val editJam: EditText = findViewById(R.id.jam)
        editJam.setText(formattedTime)
    }
}
