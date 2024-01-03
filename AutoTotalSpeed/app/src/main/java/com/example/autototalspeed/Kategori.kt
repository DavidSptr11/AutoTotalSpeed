package com.example.autototalspeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.cardview.widget.CardView

class Kategori : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kategori)
        val btn_backktg:Button = findViewById(R.id.btn_backktg);
        val card_sport:CardView = findViewById(R.id.card_sport);
        val card_naked:CardView = findViewById(R.id.card_naked);
        val card_touring:CardView = findViewById(R.id.card_touring);
        val card_dirt:CardView = findViewById(R.id.card_dirt);

        btn_backktg.setOnClickListener {
            val pindah:Intent = Intent (this, Dashboard::class.java)
            startActivity(pindah);
        }

        card_sport.setOnClickListener {
            val pindah:Intent = Intent (this, Sportbike::class.java);
            startActivity(pindah);
        }

        card_naked.setOnClickListener {
            val pindah:Intent = Intent (this, Nakedbike::class.java)
            startActivity(pindah);
        }

        card_touring.setOnClickListener {
            val pindah:Intent = Intent (this, Touringbike::class.java)
            startActivity(pindah);
        }

        card_dirt.setOnClickListener {
            val pindah:Intent = Intent (this, Dirtbike::class.java)
            startActivity(pindah);
        }
    }
}