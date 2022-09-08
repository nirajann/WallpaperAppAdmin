package com.example.artwallpaperadmin.Adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.artwallpaperadmin.Model.BomModel
import com.example.artwallpaperadmin.R
import com.google.firebase.firestore.FirebaseFirestore


class BomAdapter(val requireContext: Context,val listBestOfMonth: ArrayList<BomModel>) : RecyclerView.Adapter<BomAdapter.bomViewHolder>(){

    val db= FirebaseFirestore.getInstance()

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val  ImageView = itemView.findViewById<ImageView>(R.id.bom_image)
        val BtnDelete =  itemView.findViewById<ImageView>(R.id.btn_Delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_bom,parent,false)

        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {


        Glide.with(requireContext).load(listBestOfMonth[position].link).into(holder.ImageView)
        holder.BtnDelete.setOnClickListener{
            val dialog = AlertDialog.Builder(requireContext)


        dialog.setMessage("Are you sure ?")
        dialog.setPositiveButton("yes",DialogInterface.OnClickListener{dialog,which ->
            db.collection("bestofthemonth").document(listBestOfMonth[position].id).delete().addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(requireContext,"Wallpaper Deleted successfully", Toast.LENGTH_SHORT).show()

                }
                else{
                    Toast.makeText(requireContext,""+it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()


                }
            }
            dialog.dismiss()

        })
        dialog.setNegativeButton("No",DialogInterface.OnClickListener{ dialog,which ->
            dialog.dismiss()
        })
            dialog.show()


        }
    }

    override fun getItemCount()=listBestOfMonth.size

}