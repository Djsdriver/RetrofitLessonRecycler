package com.example.retrofitlessonrecycler

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitlessonrecycler.retrofit.ProductApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recycler: RecyclerView
    lateinit var sv: SearchView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val interceptor = HttpLoggingInterceptor()

        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()


        recycler = findViewById(R.id.recycler)
        sv = findViewById(R.id.sv)

        recycler.layoutManager = LinearLayoutManager(this)
        val productApi = retrofit.create(ProductApi::class.java)



        sv.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                // val list=productApi.getAllProducts()
                // val query=productApi.getProductsByName(p0.toString())
                // recycler.adapter=ProductAdapter(query.products)
                p0?.let {
                    productApi.getProductsByName(it)
                        .enqueue(object : Callback<Products> {
                            override fun onResponse(
                                call: Call<Products>,
                                response: Response<Products>
                            ) {
                                recycler.adapter =
                                    response.body()?.let { ProductAdapter(it.products) }

                            }

                            override fun onFailure(call: Call<Products>, t: Throwable) {

                            }

                        })
                }

                return true

            }

        })


    }
}