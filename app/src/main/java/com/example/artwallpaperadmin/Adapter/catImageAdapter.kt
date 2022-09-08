package com.example.artwallpaper.Adapter

import android.content.Context
import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.artwallpaperadmin.Model.BomModel
import com.example.artwallpaperadmin.R

import com.makeramen.roundedimageview.RoundedImageView


class catImageAdapter(val requireContext: Context, val listBestOfMonth: ArrayList<BomModel>) : RecyclerView.Adapter<catImageAdapter.bomViewHolder>(){
    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val  ImageView = itemView.findViewById<RoundedImageView>(R.id.cardBOM)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_bom,parent,false)

        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {
        holder.ImageView
        Glide.with(requireContext).load(listBestOfMonth[position].link).into(holder.ImageView);
    }

    override fun getItemCount()=listBestOfMonth.size

}