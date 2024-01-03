package com.example.autototalspeed

import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.cardview.widget.CardView

class Akun : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.akun)

        //koneksi ke db
        val dbspeed: SQLiteDatabase = openOrCreateDatabase("speed.file", MODE_PRIVATE,null);

        //ambil data user
        val ambil = dbspeed.rawQuery("SELECT * FROM user", null)
        ambil.moveToNext()

        val txt_email_user:TextView = findViewById(R.id.txt_email_user)
        val txt_password_user:TextView = findViewById(R.id.txt_password_user)
        val txt_nama_user:TextView = findViewById(R.id.txt_nama_user)
        val txt_nomor_user:TextView = findViewById(R.id.txt_nomor_user)

        //dapatkan nama_user yang login dari session
        val masuk:SharedPreferences = getSharedPreferences("user", MODE_PRIVATE)
        val id_user:String = masuk.getString("id_user", null).toString()
        val email_user:String = masuk.getString("email_user", null).toString()
        txt_email_user.text = email_user
        val password_user:String = masuk.getString("password_user", null).toString()
        txt_password_user.text = password_user
        val nama_user:String = masuk.getString("nama_user", null).toString()
        txt_nama_user.text = nama_user
        val nomor_user:String = masuk.getString("nomor_user", null).toString()
        txt_nomor_user.text = nomor_user

        val btn_back:Button = findViewById(R.id.btn_back)
        val btn_update:Button = findViewById(R.id.btn_update)
        val btn_delete:Button = findViewById(R.id.btn_delete)

        btn_back.setOnClickListener {
            val pindah:Intent = Intent(this, Dashboard::class.java);
            startActivity(pindah)
        }

        btn_update.setOnClickListener {
            val email_baru:String = txt_email_user.text.toString()
            val password_baru:String = txt_password_user.text.toString()
            val nama_baru:String = txt_nama_user.text.toString()
            val nomor_baru:String = txt_nomor_user.text.toString()

            val update = dbspeed.rawQuery("UPDATE user SET nama_user='$nama_baru', email_user='$email_baru', password_user='$password_baru', nomor_user='$nomor_baru' WHERE nama_user='$nama_user'", null)
            update.moveToNext()

            val pindah:Intent = Intent(this, Login::class.java)
            startActivity(pindah)
            Toast.makeText(this, "Akun telah di Update, Silahkan Login Kembali", Toast.LENGTH_LONG).show()
        }

        btn_delete.setOnClickListener {
            val delete = dbspeed.rawQuery("DELETE FROM user WHERE id_user='$id_user'", null)
            delete.moveToNext()

            val pindah:Intent = Intent(this, Login::class.java)
            startActivity(pindah)
            Toast.makeText(this, "Akun Telah Dihapus", Toast.LENGTH_LONG).show()
        }

    }
}