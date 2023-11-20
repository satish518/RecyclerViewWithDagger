package com.example.recyclerviewwithdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewwithdagger.databinding.ActivityMainBinding
import com.example.recyclerviewwithmvvmdaggerproject.MyApplication
import com.example.recyclerviewwithmvvmdaggerproject.adapter.ProductAdapter
import com.example.recyclerviewwithmvvmdaggerproject.model.Product
import com.example.recyclerviewwithmvvmdaggerproject.utils.Response
import com.example.recyclerviewwithmvvmdaggerproject.viewmodel.ProductViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var bindingMainBinding: ActivityMainBinding

    lateinit var productAdapter: ProductAdapter

    @Inject
    lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as MyApplication).applicationComponent.inject(this)

        productViewModel.product.observe(this, {

            when(it) {
                is Response.Loading -> {
                }
                is Response.Success -> {
                    it.data?.let {
                        setupRecyclerview(it)
                    }
                }
                is Response.Error -> {
                    Toast.makeText(this@MainActivity, it.errormessage, Toast.LENGTH_SHORT).show()
                }

                else -> {}
            }
        })
    }

    private fun setupRecyclerview(productList: List<Product>) {

        productAdapter = ProductAdapter(productList)
        bindingMainBinding.productListView.adapter = productAdapter

        bindingMainBinding.productListView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }
}