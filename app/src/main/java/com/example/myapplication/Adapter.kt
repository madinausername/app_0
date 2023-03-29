package com.example.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class Adapter(val list_product: MutableList<DataProduct>):RecyclerView.Adapter<Adapter.HolderClass>(){

    class HolderClass(view: View):RecyclerView.ViewHolder(view)
    {
        @SuppressLint("ResourceType")
        val image:ImageView=itemView.findViewById(R.id.img_id)
        val name_product:TextView=itemView.findViewById(R.id.text_id)
        val price_product:TextView=itemView.findViewById(R.id.price_id)
        val id_card:ConstraintLayout=itemView.findViewById(R.id.id_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderClass {
        val itemview=LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return HolderClass(itemview)
    }

    override fun getItemCount(): Int {
        return list_product.size
    }

    override fun onBindViewHolder(holder: HolderClass, position: Int) {
        val currentItem=list_product[position]
        holder.image.setImageResource(currentItem.img)
        holder.name_product.text=currentItem.name
        holder.price_product.text=currentItem.price

        val anim=AnimationUtils.loadAnimation(holder.itemView.context,R.anim.animation)
        holder.id_card.startAnimation(anim)
    }

}