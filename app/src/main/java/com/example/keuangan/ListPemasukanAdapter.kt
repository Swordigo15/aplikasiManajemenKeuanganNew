package com.example.keuangan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPemasukanAdapter(private val listPemasukan: ArrayList<DataPemasukan>) : RecyclerView.Adapter<ListPemasukanAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTanggal: TextView = itemView.findViewById(R.id.tv_item_tanggal)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.tv_item_description)
        val tvNominal: TextView = itemView.findViewById(R.id.tv_item_nominal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.pemasukan_row, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listPemasukan.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (tanggal, deskripsi, nominal ) = listPemasukan[position]
        holder.tvTanggal.text = tanggal
        holder.tvDeskripsi.text = deskripsi
        holder.tvNominal.text = nominal
    }

}