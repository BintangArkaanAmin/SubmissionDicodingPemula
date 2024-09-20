package com.example.submissiondicodingpemula.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissiondicodingpemula.DetailActivity
import com.example.submissiondicodingpemula.R
import com.example.submissiondicodingpemula.data.HandphoneData

class ListHpAdapter(private val listHp: ArrayList<HandphoneData>) : RecyclerView.Adapter<ListHpAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgGambar :ImageView = itemView.findViewById(R.id.IV_photo)
        val tvMerk: TextView = itemView.findViewById(R.id.TV_namahp)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.TV_deschp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
       val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_hp, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listHp.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (NamaHP, DescHP, GambarHP) = listHp[position]
        Glide.with(holder.itemView.context)
            .load(GambarHP)
            .into(holder.imgGambar)
        holder.tvMerk.text = NamaHP
        holder.tvDeskripsi.text = DescHP
        holder.itemView.setOnClickListener{
            val detailintentdata = Intent(holder.itemView.context, DetailActivity::class.java)
            detailintentdata.putExtra(DetailActivity.INFO_HP, listHp[holder.adapterPosition])
            holder.itemView.context.startActivity(detailintentdata)
            Toast.makeText(holder.itemView.context, "Anda Memilih Merk Hp "+ listHp[holder.adapterPosition].NamaHP, Toast.LENGTH_SHORT).show()
        }
    }
}