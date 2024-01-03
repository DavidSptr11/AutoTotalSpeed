package com.example.autototalspeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class Dealer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dealer)
        val btn_backdealer:Button = findViewById(R.id.btn_backdealer);

        btn_backdealer.setOnClickListener {
            val pindah:Intent = Intent(this, Dashboard::class.java)
            startActivity(pindah);
        }
    }
}