package com.example.artwallpaperadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.artwallpaperadmin.Adapter.colortoneAdapter
import com.example.artwallpaperadmin.Model.colortoneModel
import com.example.artwallpaperadmin.databinding.ActivityTctactivityBinding
import com.google.firebase.firestore.FirebaseFirestore

class TCTActivity : AppCompatActivity() {

    lateinit var binding : ActivityTctactivityBinding
    lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTctactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseFirestore.getInstance()

        db.collection("thecolortone").addSnapshotListener { value, error ->
            val ListTheColorTone = arrayListOf<colortoneModel>()
            val data = value?.toObjects(colortoneModel::class.java)
            ListTheColorTone.addAll(data!!)

            binding.rcvTCT.layoutManager = GridLayoutManager(this@TCTActivity, 3)
            binding.rcvTCT.adapter = colortoneAdapter(this@TCTActivity,ListTheColorTone)

            binding.btnDone.setOnClickListener {
//                if(binding.editLink.text.toString().isEmpty() && binding.editcolor.text.toString().isEmpty())
//                {
//                    Toast.makeText(this@TCTActivity,"Enter Valid Data", Toast.LENGTH_SHORT).show()
//                }else
//                {
//                    addLinkToDatabase(binding.editLink.text.toString(), binding.editcolor.text.toString())
//                }
//            }
//
//        }
            }

//    private fun addLinkToDatabase(link: String, color: String) {
//        val uid = db.collection("thecolortone").document().id
//        val finalData = colortoneModel(id = uid,link = link,color = color)
//
//        db.collection("thecolortone").document(uid).set(finalData).addOnCompleteListener{
//            if(it.isSuccessful){
//                Toast.makeText(this@TCTActivity,"Color added successfully",Toast.LENGTH_SHORT).show()
//                binding.editLink.setText("")
//                binding.editLink.clearFocus()
//
//            }
//            else{
//                Toast.makeText(this@TCTActivity,""+it.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
//                binding.editLink.setText("")
//                binding.editLink.clearFocus()
//
//            }
//
//        }
//
//
//    }
        }
    }
}
