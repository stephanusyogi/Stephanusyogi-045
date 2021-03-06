package com.example.intentkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this

        BtnIntent1.setOnClickListener {

            val intent = Intent(context,Activity1::class.java)
            

            val name:String = inputText1.text.toString()

            intent.putExtra("name",name)

            startActivity(intent)
            finish()
        }

        BtnIntent2.setOnClickListener {

            val intent = Intent(context,Activity2::class.java)
            startActivity(intent)
            finish()
        }

    }
}
