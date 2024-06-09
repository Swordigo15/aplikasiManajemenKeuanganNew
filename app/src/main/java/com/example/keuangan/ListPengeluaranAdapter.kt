package com.example.keuangan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPengeluaranAdapter(private val listPengeluaran: ArrayList<DataPengeluaran>) : RecyclerView.Adapter<ListPengeluaranAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTanggal2: TextView = itemView.findViewById(R.id.tv_item_tanggal2)
        val tvDeskripsi2: TextView = itemView.findViewById(R.id.tv_item_description2)
        val tvNominal2: TextView = itemView.findViewById(R.id.tv_item_nominal2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.pengeluaran_row, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listPengeluaran.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (tanggal, deskripsi, nominal ) = listPengeluaran[position]
        holder.tvTanggal2.text = tanggal
        holder.tvDeskripsi2.text = deskripsi
        holder.tvNominal2.text = nominal
    }

}