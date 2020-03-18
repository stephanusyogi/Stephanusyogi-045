package com.example.yogi_uts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        button.setOnClickListener{
            val sharedPreferences=getSharedPreferences("ceklogin", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this@Dashboard,MainActivity::class.java))
            finish()
        }
        penduduk.setOnClickListener {
            val intent = Intent(this,masterpenduduk::class.java)
            startActivity(intent)
            finish()
        }

        tambah.setOnClickListener {
            val intent = Intent(this,Tambahdata::class.java)
            startActivity(intent)
            finish()
        }


    }
}
