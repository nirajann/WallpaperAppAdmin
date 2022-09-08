package com.example.artwallpaperadmin

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.artwallpaperadmin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var Binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(Binding.root)

        Binding.cardBOM.setOnClickListener{
            startActivity(Intent(this@MainActivity,BOMActivity::class.java))

        }
        Binding.cardTCT.setOnClickListener{
            startActivity(Intent(this@MainActivity,TCTActivity::class.java))

        }
        Binding.cardCAT.setOnClickListener{
            startActivity(Intent(this@MainActivity,CategoryActivity::class.java))

        }
    }
}