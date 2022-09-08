package com.example.artwallpaperadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.artwallpaperadmin.Adapter.BomAdapter
import com.example.artwallpaperadmin.Model.BomModel
import com.example.artwallpaperadmin.databinding.ActivityBomactivityBinding
import com.google.firebase.firestore.FirebaseFirestore

class BOMActivity : AppCompatActivity() {
    lateinit var binding : ActivityBomactivityBinding
    lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBomactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseFirestore.getInstance()


        db.collection("bestofthemonth").addSnapshotListener { value, error ->
            val listBestOfMonth = arrayListOf<BomModel>()
            val data=value?.toObjects(BomModel::class.java)
            listBestOfMonth.addAll(data!!)

            binding.rcvBOM.layoutManager = GridLayoutManager(this@BOMActivity, 3)
            binding.rcvBOM.adapter = BomAdapter(this@BOMActivity,listBestOfMonth)
        }

        binding.btnDone.setOnClickListener{
            if(binding.editLink.text.toString().isEmpty())
            {
                Toast.makeText(this@BOMActivity,"Paste your link",Toast.LENGTH_SHORT).show()
            }else
            {
                addLinkToDatabase(binding.editLink.text.toString())
            }
        }
    }

    private fun addLinkToDatabase(WallpaperLink: String) {
        val uid = db.collection("bestofthemonth").document().id
        val finalData = BomModel(uid,WallpaperLink)

        db.collection("bestofthemonth").document(uid).set(finalData).addOnCompleteListener{
            if(it.isSuccessful){
                Toast.makeText(this@BOMActivity,"Wallpaper added successfully",Toast.LENGTH_SHORT).show()
                binding.editLink.setText("")
                binding.editLink.clearFocus()
            }
            else{
                Toast.makeText(this@BOMActivity,""+it.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
                binding.editLink.setText("")
                binding.editLink.clearFocus()
            }

        }


    }
}