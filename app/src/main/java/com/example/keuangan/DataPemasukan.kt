package com.example.keuangan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataPemasukan(
    val tanggal: String,
    val deskripsi: String,
    val nominal: String
) : Parcelable
