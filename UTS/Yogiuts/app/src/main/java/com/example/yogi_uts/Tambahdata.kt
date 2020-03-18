package com.example.yogi_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_tambahdata.*
import org.json.JSONArray

class Tambahdata : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambahdata)


        btnkembali.setOnClickListener {
            val intent = Intent(this,Dashboard::class.java)
            startActivity(intent)
            finish()
        }
        btnTambah.setOnClickListener {
            var data_nama:String = editNama.text.toString()
            var data_ttl: String = edittl.text.toString()
            var data_hp: String = edithp.text.toString()
            var data_alamat: String = editalamat.text.toString()


            postkeserver(data_nama,data_ttl,data_hp,data_alamat)

        }




    }
    fun postkeserver(data1:String, data2:String, data3:String,data4:String){
        AndroidNetworking.post("http://192.168.1.78/project-uts/proses-json.php")
            .addBodyParameter("nama_penduduk", data1)
            .addBodyParameter("ttl_penduduk", data2)
            .addBodyParameter("hp_penduduk", data3)
            .addBodyParameter("alamat_penduduk", data4)
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
