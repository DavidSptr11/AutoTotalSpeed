package com.example.autototalspeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class Parts : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.parts)
        val btn_parts:Button = findViewById(R.id.btn_parts);

        btn_parts.setOnClickListener {
            val pindah:Intent = Intent(this, Dashboard::class.java)
            startActivity(pindah);
        }
    }
}