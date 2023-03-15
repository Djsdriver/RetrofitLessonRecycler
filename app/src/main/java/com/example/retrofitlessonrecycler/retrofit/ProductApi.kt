package com.example.retrofitlessonrecycler.retrofit

import com.example.retrofitlessonrecycler.Product
import com.example.retrofitlessonrecycler.Products
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getAllProducts(): Products
}