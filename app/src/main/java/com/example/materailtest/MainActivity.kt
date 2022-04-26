package com.example.materailtest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    //lateinit var bind:ActivityMainBinding
    val fruits = mutableListOf( Fruit("Banana",
        R.drawable.banana), Fruit("Orange", R.drawable.orange), Fruit("Watermelon",
        R.drawable.watermelon), Fruit("Pear", R.drawable.pear), Fruit("Grape",
        R.drawable.grape), Fruit("Pineapple", R.drawable.pineapple), Fruit("Strawberry",
        R.drawable.strawberry), Fruit("Cherry", R.drawable.cherry), Fruit("Mango",
        R.drawable.mango))
    val fruitelist=ArrayList<Fruit>()
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //    bind= ActivityMainBinding.inflate(layoutInflater)
     //   setContentView(bind.root)
        setContentView(R.layout.activity_main1)
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
         //   it.setHomeAsUpIndicator(R.mipmap.ic_painting_u5)
        }

        initfruite()
        val layoutManager = GridLayoutManager(this, 2)
        recycleview1.layoutManager = layoutManager
        val adapter = fruitAdapter(this,fruitelist)
        recycleview1.adapter = adapter

        swiprefresh.setColorSchemeColors(R.color.refrech)
        swiprefresh.setOnRefreshListener{
            refreshFruit(adapter)
        }

        navView.setNavigationItemSelectedListener {
            drawerlayout.closeDrawers()
           true
        }
        floatbutton.setOnClickListener(){
            Snackbar.make(navView,"delete the item?",Snackbar.LENGTH_LONG).setAction("yes"){
                Log.d("snackbar","click the button")
            }.show()
        }
    }

    private fun refreshFruit(adapter: fruitAdapter) {
            thread {
                Thread.sleep(2000)
                runOnUiThread {
                    initfruite()
                    adapter.notifyDataSetChanged()
                    swiprefresh.isRefreshing=false
                }
            }
    }

    private fun initfruite(){
        fruitelist.clear()
        repeat(10){
            val index=(0 until fruits.size).random()
            fruitelist.add(fruits[index])

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.like->Toast.makeText(this,"your click like",Toast.LENGTH_LONG).show()
            R.id.coin->Toast.makeText(this,"your click coin",Toast.LENGTH_LONG).show()
            R.id.star->Toast.makeText(this,"your click star",Toast.LENGTH_LONG).show()
            android.R.id.home->drawerlayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
}