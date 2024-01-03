package com.example.autototalspeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class Contact : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact)
        val btn_back:Button = findViewById(R.id.btn_backcontact);

        btn_back.setOnClickListener {
            val pindah:Intent = Intent (this, Dashboard::class.java)
            startActivity(pindah);
        }
    }
}