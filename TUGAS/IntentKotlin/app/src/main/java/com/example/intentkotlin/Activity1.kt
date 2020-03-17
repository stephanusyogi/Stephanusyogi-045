package com.example.intentkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import kotlinx.android.synthetic.main.activity_1.*
import kotlinx.android.synthetic.main.activity_2.*

class Activity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val context = this

        val intentObject: Intent =intent

        val name=intentObject.getStringExtra("name")
        textView.text = "Hallo $name"

        BtnIntentUtama1.setOnClickListener {
            var intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
