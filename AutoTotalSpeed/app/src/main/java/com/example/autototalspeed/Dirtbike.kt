package com.example.autototalspeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class Dirtbike : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dirtbike)

        val btn_back:Button = findViewById(R.id.btn_back);

        btn_back.setOnClickListener {
            val pindah:Intent = Intent (this, Kategori::class.java)
            startActivity(pindah);
        }
    }
}