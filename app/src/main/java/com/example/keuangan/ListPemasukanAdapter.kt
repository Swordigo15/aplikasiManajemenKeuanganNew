package com.example.keuangan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.format.DateTimeFormatter

class ListPemasukanAdapter(private val listPemasukan: List<PemasukanResponse>) :
    RecyclerView.Adapter<ListPemasukanAdapter.PemasukanViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PemasukanViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.pemasukan_row, parent, false)
        return PemasukanViewHolder(view)
    }

    override fun onBindViewHolder(holder: PemasukanViewHolder, position: Int) {
        val pemasukan = listPemasukan[position]

        holder.tvPemasukan.text = "Rp ${pemasukan.pemasukan}"
        holder.tvCatatan.text = pemasukan.catatan
        holder.tvTanggal.text = pemasukan.tanggal.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        holder.tvJam.text = pemasukan.jam.format(DateTimeFormatter.ofPattern("HH:mm"))
    }

    override fun getItemCount(): Int {
        return listPemasukan.size
    }

    inner class PemasukanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPemasukan: TextView = itemView.findViewById(R.id.tv_pemasukan)
        val tvCatatan: TextView = itemView.findViewById(R.id.tv_catatan)
        val tvTanggal: TextView = itemView.findViewById(R.id.tv_tanggal)
        val tvJam: TextView = itemView.findViewById(R.id.tv_jam)
    }
}
