package com.example.materailtest

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fruit1.*
import kotlinx.android.synthetic.main.activity_fruit1.toolbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main1.*
import kotlinx.android.synthetic.main.nav_header1.*
import kotlinx.android.synthetic.main.nav_header1.mailText
import kotlinx.android.synthetic.main.nav_header1.userText

class Mainactivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        setSupportActionBar(toolbar)
        val username6 = intent.getStringExtra("extra_data")
        Log.d("username33main", username6.toString())
        val uandp = username6.toString().split(" ")
        mailText.text = uandp[1]
        userText.text = uandp[0]
        order12.setOnClickListener() {
            var banane = q1.text.toString().toInt()
            var watermelon = q2.text.toString().toInt()
            var grape = q3.text.toString().toInt()
            var sum=banane*3+watermelon*2+grape*5
            var adress = EmailEdit4.text.toString()
            AlertDialog.Builder(this).apply {
                setTitle("确认订单")
                setMessage("你当前选择了"+banane+"份香蕉，"+watermelon+"份西瓜"+grape+"份葡萄，共计"+sum+"元，" +
                        "配送地址为"+adress+"，是否确认订单？")
                setCancelable(false)
                setPositiveButton("确认") { _, _ ->
                    Toast.makeText(applicationContext,"下单成功，请等待工作人员为您配送",Toast.LENGTH_LONG).show()
                    q1.setText("")
                    q2.setText("")
                    q3.setText("")
                    EmailEdit4.setText("")
                }
                setNegativeButton("返回修改"){ _, _ ->

                }
                show()
            }
        }
    }
}