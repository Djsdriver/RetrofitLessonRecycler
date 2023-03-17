package com.example.retrofitlessonrecycler.retrofit

import com.example.retrofitlessonrecycler.Product
import com.example.retrofitlessonrecycler.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ProductApi {

    @GET("products")
    suspend fun getAllProducts(): Products

    @GET("products/search")
    fun getProductsByName(@Query("q") name: String): Call<Products>
}