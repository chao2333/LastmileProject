package com.example.materailtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Fruit(val name:String,val id:Int)
class fruitAdapter(val context: Context,val fruitlist:List<Fruit>):
    RecyclerView.Adapter<fruitAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val friutImage:ImageView=view.findViewById(R.id.imageview)
        val friutetext:TextView=view.findViewById(R.id.fruitname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.fruit_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val friute=fruitlist[position]
        holder.friutetext.text=friute.name
        Glide.with(context).load(friute.id).into(holder.friutImage)
    }

    override fun getItemCount(): Int {
        val bat=2
        return fruitlist.size
    }
}