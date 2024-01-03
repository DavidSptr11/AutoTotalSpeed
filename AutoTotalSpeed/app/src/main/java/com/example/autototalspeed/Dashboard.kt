package com.example.autototalspeed

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.cardview.widget.CardView

class Dashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        val masuk:SharedPreferences = getSharedPreferences("user", MODE_PRIVATE)
        val card_akun:CardView = findViewById(R.id.card_akun);
        val card_kategori:CardView = findViewById(R.id.card_kategori);
        val card_logout:CardView = findViewById(R.id.card_logout);
        val card_contact:CardView = findViewById(R.id.card_contact);
        val card_dealer:CardView = findViewById(R.id.card_dealer);
        val card_parts:CardView = findViewById(R.id.card_parts);

        card_akun.setOnClickListener {
            val pindah: Intent = Intent (this, Akun::class.java);
            startActivity(pindah)
        }
        card_kategori.setOnClickListener {
            val pindah: Intent = Intent (this, Kategori::class.java);
            startActivity(pindah)
        }

        card_logout.setOnClickListener {
            //Menghapus session user
            val keluar = masuk.edit()
            keluar.clear()
            keluar.commit()

            //pindah ke halaman login
            val logout:Intent = Intent(this, Login::class.java)
            startActivity(logout)
            finish()
        }

        card_contact.setOnClickListener {
            val pindah:Intent = Intent (this, Contact::class.java);
            startActivity(pindah)
        }

        card_dealer.setOnClickListener {
            val pindah:Intent = Intent (this, Dealer::class.java);
            startActivity(pindah)
        }

        card_parts.setOnClickListener {
            val pindah:Intent = Intent(this, Parts::class.java);
            startActivity(pindah)
        }
    }
}