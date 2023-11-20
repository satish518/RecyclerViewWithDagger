package com.example.recyclerviewwithmvvmdaggerproject.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recyclerviewwithmvvmdaggerproject.model.Product
import com.example.recyclerviewwithmvvmdaggerproject.retrofit.ProductAPI
import com.example.recyclerviewwithmvvmdaggerproject.utils.NetworkUtils
import com.example.recyclerviewwithmvvmdaggerproject.utils.Response
import java.lang.Exception
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productAPI: ProductAPI, private val applicationContext: Context) {

    private val _product = MutableLiveData<Response<List<Product>>>()

    val product: LiveData<Response<List<Product>>>
        get() = _product

    suspend fun getProducts() {

        if (NetworkUtils.isNetworkAvailable(applicationContext)) {
            try {

                val result = productAPI.getProducts()
                if (result.isSuccessful && result.body()!=null) {
                    _product.postValue(Response.Success(result.body()))
                } else {
                    _product.postValue(Response.Error("${result.code()} - ${result.message()}"))
                }

            } catch (e: Exception) {
                _product.postValue(Response.Error("${e.message}"))
            }
        } else {
            _product.postValue(Response.Error("No Record Found."))
        }


    }
}