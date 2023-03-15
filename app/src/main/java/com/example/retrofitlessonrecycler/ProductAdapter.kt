package com.example.retrofitlessonrecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val list: List<Product>): RecyclerView.Adapter<ProductHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
       holder.bind(list[position])
    }
}