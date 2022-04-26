package com.example.materailtest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.Thread.sleep
import java.sql.SQLException
import java.sql.Statement
import kotlin.concurrent.thread

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var stmt: Statement? = null
        val mycaassjava=MyClassJAVA()

        val conn=mycaassjava.connection

        BackLoginButton.setOnClickListener(){
            finish();
        }
        SignUpButton.setOnClickListener(){
                var username1=UserNameEdit.text.toString()
                var password1=PassWordEdit.text.toString()
                var EmailEdit1=EmailEdit.text.toString()
                insert1(username1,password1,EmailEdit1)
                Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show()
                finish()
        }
    }
}