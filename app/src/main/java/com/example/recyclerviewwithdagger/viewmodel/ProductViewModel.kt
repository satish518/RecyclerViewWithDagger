package com.example.recyclerviewwithmvvmdaggerproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewwithmvvmdaggerproject.model.Product
import com.example.recyclerviewwithmvvmdaggerproject.repository.ProductRepository
import com.example.recyclerviewwithmvvmdaggerproject.utils.Response
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {

    val product: LiveData<Response<List<Product>>>
        get() = productRepository.product

    init {
        viewModelScope.launch {
            productRepository.getProducts()
        }
    }

}