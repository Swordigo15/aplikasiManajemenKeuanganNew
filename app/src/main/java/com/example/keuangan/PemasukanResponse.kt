package com.example.keuangan

import java.time.LocalDate
import java.time.LocalTime

data class PemasukanResponse(
    val total_saldo: Long,
    val id: Int,
    val user_id: Int,
    val pemasukan: Long,
    val catatan: String,
    val tanggal: LocalDate,
    val jam: LocalTime,
)
