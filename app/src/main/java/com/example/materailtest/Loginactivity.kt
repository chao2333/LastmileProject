package com.example.materailtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Loginactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val mycaassjava=MyClassJAVA()
        val conn4=mycaassjava.connection

        SignUpButton1.setOnClickListener(){
            val intent1=Intent(this,SignUpActivity::class.java)
            startActivity(intent1)
        }
        LoginButton.setOnClickListener(){
            Toast.makeText(this,"正在登录..时间较长..请等待",Toast.LENGTH_LONG).show()
            val username1=UserNameEdit.text.toString()
            val password1=PassWordEdit.text.toString()
            val re=qurey1(username1,password1)
            if(re==""){
                Toast.makeText(this,"此用户没有注册，请先注册",Toast.LENGTH_SHORT).show()
                UserNameEdit.setText("")
                PassWordEdit.setText("")
            }else{
                Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show()
                val intent5=Intent(this,Mainactivity1::class.java)
                intent5.putExtra("extra_data",re)
                Log.d("username33lg",re)
                startActivity(intent5)
                finish()
            }
        }

    }
}