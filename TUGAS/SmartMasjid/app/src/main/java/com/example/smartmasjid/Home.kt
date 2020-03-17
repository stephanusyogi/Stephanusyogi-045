package com.example.smartmasjid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val context = this

        buttonidentitas.setOnClickListener {
            val intent = Intent(context,IdentitasMasjid::class.java)
            startActivity(intent)
            finish()
        }

        buttonjadwal.setOnClickListener {
            val intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonmarquee.setOnClickListener {
            val intent = Intent(context,Marquee::class.java)
            startActivity(intent)
            finish()
        }

        buttonpengumuman.setOnClickListener {
            val intent = Intent(context,Pengumuman::class.java)
            startActivity(intent)
            finish()
        }

        buttonslideshow.setOnClickListener {
            val intent = Intent(context,Slideshow::class.java)
            startActivity(intent)
            finish()
        }

        buttontagline.setOnClickListener {
            val intent = Intent(context,Tagline::class.java)
            startActivity(intent)
            finish()
        }
    }
}
