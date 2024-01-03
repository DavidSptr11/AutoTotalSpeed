package com.example.autototalspeed

import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val edt_email:EditText = findViewById(R.id.edt_email);
        val edt_password:EditText = findViewById(R.id.edt_password);
        val btn_login:Button = findViewById(R.id.btn_login);
        val btn_register:Button = findViewById(R.id.btn_register);

        btn_login.setOnClickListener{
            //Dapatkan Isi Email dan Password
            val isi_email:String = edt_email.text.toString()
            val isi_password:String = edt_password.text.toString()

            //koneksi ke db
            val dbspeed: SQLiteDatabase = openOrCreateDatabase("speed.file", MODE_PRIVATE,null);

            //cek ke tabel user
            val query = dbspeed.rawQuery("SELECT * FROM user WHERE email_user='$isi_email' AND password_user='$isi_password'", null)
            val cek = query.moveToNext()

            //jika ada user dengan email dan password itu, maka true
            if (cek) {
                //simpan data pelogin ke sharedpreference
                val id = query.getString(0)
                val nama = query.getString(1)
                val email = query.getString(2)
                val password = query.getString(3)
                val nomor = query.getString(4)

                val session:SharedPreferences = getSharedPreferences("user", MODE_PRIVATE)
                val masuk = session.edit()
                masuk.putString("id_user", id)
                masuk.putString("nama_user", nama)
                masuk.putString("email_user", email)
                masuk.putString("password_user", password)
                masuk.putString("nomor_user", nomor)
                masuk.commit()

                //pindah ke halaman Dashboard
                val pindah:Intent = Intent(this, Dashboard::class.java)
                startActivity(pindah)
            } else {
                Toast.makeText(this, "Email atau Password anda salah!", Toast.LENGTH_LONG).show()
            }
        }

        btn_register.setOnClickListener {
            val pindah:Intent = Intent (this, Register::class.java)
            startActivity(pindah)
        }
    }
}