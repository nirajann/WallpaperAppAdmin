package com.example.artwallpaperadmin.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.artwallpaperadmin.Model.colortoneModel
import com.example.artwallpaperadmin.R


class colortoneAdapter(val requireContext: Context, val listthecolortone: ArrayList<colortoneModel>) : RecyclerView.Adapter<colortoneAdapter.bomViewHolder>(){

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val  cardBack = itemView.findViewById<CardView>(R.id.item_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_colortone,parent,false)

        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {
        val color = listthecolortone[position].color

        holder.cardBack.setCardBackgroundColor(Color.parseColor(color!!))


    }

    override fun getItemCount()=listthecolortone.size

}