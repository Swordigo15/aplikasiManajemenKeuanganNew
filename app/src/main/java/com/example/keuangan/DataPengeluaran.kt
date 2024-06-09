package com.example.keuangan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataPengeluaran(
    val tanggal2: String,
    val deskripsi2: String,
    val nominal2: String
) : Parcelable