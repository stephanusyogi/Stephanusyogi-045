package com.example.smartmasjid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getdariserver()

        val context = this

        btnBack_home2.setOnClickListener {
            var intent = Intent(context,Home::class.java)
            startActivity(intent)
            finish()
        }

        btnUpdate_jadwal.setOnClickListener {

            var data_shubuh :String = edit_shubuh.text.toString()
            var data_dhuhur :String = edit_dhuhur.text.toString()
            var data_ashar :String = edit_ashar.text.toString()
            var data_maghrib :String = edit_maghrib.text.toString()
            var data_isha :String = edit_isha.text.toString()
            var data_dhuha :String = edit_dhuha.text.toString()

            postkeserver(data_shubuh,data_dhuhur,data_ashar,data_maghrib,data_isha,data_dhuha)

            var intent = Intent(context,Home::class.java)
            startActivity(intent)
            finish()
        }



    }

    fun getdariserver(){

        AndroidNetworking.get("http://digitalsmartmasjid.000webhostapp.com/contoh_jadwal_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response!!.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("shubuh"))

                        txt1.setText(jsonObject.optString("shubuh"))
                        txt2.setText(jsonObject.optString("dhuhur"))
                        txt3.setText(jsonObject.optString("ashar"))
                        txt4.setText(jsonObject.optString("maghrib"))
                        txt5.setText(jsonObject.optString("isha"))
                        txt6.setText(jsonObject.optString("dhuha"))

                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun postkeserver(data1:String,data2:String,data3:String,data4:String,data5:String,data6:String)
    {
        AndroidNetworking.post("http://digitalsmartmasjid.000webhostapp.com/proses_jadwal.php")
            .addBodyParameter("shubuh", data1)
            .addBodyParameter("dhuhur", data2)
            .addBodyParameter("ashar", data3)
            .addBodyParameter("maghrib", data4)
            .addBodyParameter("isha", data5)
            .addBodyParameter("dhuha", data6)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {
                }

                override fun onError(anError: ANError?) {
                }
            })
    }
}
