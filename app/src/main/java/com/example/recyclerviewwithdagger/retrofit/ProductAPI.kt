package com.example.recyclerviewwithmvvmdaggerproject.retrofit

import com.example.recyclerviewwithmvvmdaggerproject.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}