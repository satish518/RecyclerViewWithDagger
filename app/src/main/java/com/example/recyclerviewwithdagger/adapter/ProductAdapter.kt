package com.example.recyclerviewwithmvvmdaggerproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithdagger.databinding.ListItemsBinding
import com.example.recyclerviewwithmvvmdaggerproject.model.Product

class ProductAdapter(private val productList: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    private lateinit var binding: ListItemsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        binding = ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = productList.get(position)
        holder.bind(product)
    }

    class ProductHolder(private val binding: ListItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.product = product
        }

    }
}

