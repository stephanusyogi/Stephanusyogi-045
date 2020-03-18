package com.example.yogi_uts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("ceklogin", Context.MODE_PRIVATE)
        val stat=sharedPreferences.getString("STATUS","")

        if (stat=="1"){

            startActivity(Intent(this,Dashboard::class.java))
            finish()

        }

        else {

            btnLogin.setOnClickListener{

                var username=username.text.toString()
                var password=password.text.toString()


                ceklogin(username,password)

            }
        }
    }


    fun ceklogin(data1:String, data2:String){
        AndroidNetworking.post("http://192.168.1.78/project-uts/cek-login.php")
            .addBodyParameter("username", data1)
            .addBodyParameter("password", data2)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("status"))
                        var statuslogin= jsonObject.optString("status")

                        if (statuslogin=="1"){

                            val sharedPreferences=getSharedPreferences("ceklogin", Context.MODE_PRIVATE)
                            val editor=sharedPreferences.edit()

                            editor.putString("STATUS",statuslogin)
                            editor.apply()

                            startActivity(Intent(this@MainActivity,Dashboard::class.java))
                            finish()
                        }
                    }

                }

                override fun onError(error: ANError) { // handle error
                }

            })
    }
}
