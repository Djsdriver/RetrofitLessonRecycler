package com.example.retrofitlessonrecycler


import android.view.RoundedCorner
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    val txtTitle=itemView.findViewById<TextView>(R.id.title)
    val txtDec=itemView.findViewById<TextView>(R.id.description)

    val image=itemView.findViewById<ImageView>(R.id.imageView)

    fun bind(product: Product){
        txtTitle.text=product.title
        txtDec.text=product.description
        Glide.with(itemView).load(product.images[0]).error(R.drawable.baseline_error_24).into(image)
    }

}