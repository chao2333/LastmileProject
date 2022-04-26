package com.example.materailtest

import android.util.Log
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.Thread.sleep
import java.sql.SQLException
import java.sql.Statement
import kotlin.concurrent.thread

fun main(){
    var username1="UserNameEdit"
    var EmailEdit1="EmailEdit.text;"
    var password1:String="PassWordEdit"


        var stmt: Statement? = null
        val mycaassjava=MyClassJAVA()

        val conn=mycaassjava.connection
        try {

            var flag1=(conn==null)
            print(flag1)
            stmt = conn.createStatement()
            val sql1=
                "INSERT INTO test1(username1,mail1,password1) VALUES('$password1','$EmailEdit1','$password1')"
            stmt.execute(sql1)
            stmt.close()

        } catch (se: SQLException) {
            // 处理 JDBC 错误
            se.printStackTrace()
        } catch (e: Exception) {
            // 处理 Class.forName 错误
            e.printStackTrace()
        } finally {
            try {
                stmt?.close()
            } catch (se2: SQLException) {
            } // 什么都不做
            try {
                conn?.close()
            } catch (se: SQLException) {
                se.printStackTrace()
            }
        }
    sleep(3000)
    conn.close()
}


public fun insert1(username1:String,password1:String,EmailEdit1:String){
thread {

    var stmt: Statement? = null
    val mycaassjava=MyClassJAVA()

    val conn=mycaassjava.connection
    try {
        stmt = conn.createStatement()
        val sql1=
            "INSERT INTO test1(username1,mail1,password1) VALUES('$username1','$EmailEdit1','$password1')"
        stmt.execute(sql1)
        stmt.close()

    } catch (se: SQLException) {
        // 处理 JDBC 错误
        se.printStackTrace()
    } catch (e: Exception) {
        // 处理 Class.forName 错误
        e.printStackTrace()
    }
    conn.close()
}
}
fun  qurey1(username1:String,password1:String):String{
    var quer=""
    var quer1=false
val t1=thread {
        var stmt: Statement? = null
        val mycaassjava=MyClassJAVA()
        val conn=mycaassjava.connection
        try {
            stmt = conn.createStatement()
            val sql1= "SELECT * FROM test1"
            val rs = stmt.executeQuery(sql1)
            while (rs.next()) {
                val un = rs.getString("username1")
                val ps = rs.getString("password1")
                val ml=rs.getString("mail1")
                if(un==username1&&ps==password1){
                    quer=username1+" "+ml
                    quer1=true
                }
            }
            rs.close()
            stmt.close()
            conn.close()
        } catch (se: SQLException) {
            se.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        conn.close()
}
    t1.join()
    Log.d("inwhile2", quer)
    return quer
}

