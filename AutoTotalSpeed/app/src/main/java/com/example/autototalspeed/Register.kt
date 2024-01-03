package com.example.autototalspeed

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class Register : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val sv_email:EditText = findViewById(R.id.sv_email)
        val sv_nama:EditText = findViewById(R.id.sv_nama)
        val sv_nomor:EditText = findViewById(R.id.sv_nomor)
        val sv_password:EditText = findViewById(R.id.sv_password)
        val btn_back:Button = findViewById(R.id.btn_back)
        val btn_register:Button = findViewById(R.id.btn_register)

        btn_back.setOnClickListener {
            val pindah:Intent = Intent(this, Login::class.java)
            startActivity(pindah)
        }

        btn_register.setOnClickListener {
            //dapatkan isi dari btn_sv
            val isi_email:String = sv_email.text.toString()
            val isi_nama:String = sv_nama.text.toString()
            val isi_nomor:String = sv_nomor.text.toString()
            val isi_password:String = sv_password.text.toString()

            //query simpan ke database
            val dbspeed:SQLiteDatabase = openOrCreateDatabase("speed.file", MODE_PRIVATE, null)
            val execute = dbspeed.rawQuery("INSERT INTO user(nama_user, email_user, password_user, nomor_user) VALUES ('$isi_nama', '$isi_email', '$isi_password', '$isi_nomor')", null)
            execute.moveToNext()

            //pindah ke halaman login
            val pindah:Intent = Intent(this, Login::class.java)
            startActivity(pindah)

            Toast.makeText(this,"Akun anda berhasil terdaftar", Toast.LENGTH_LONG).show()
        }

    }
}