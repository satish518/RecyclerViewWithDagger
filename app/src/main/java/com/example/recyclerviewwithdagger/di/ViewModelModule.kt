package com.example.recyclerviewwithmvvmdaggerproject.di

import android.content.Context
import com.example.recyclerviewwithmvvmdaggerproject.repository.ProductRepository
import com.example.recyclerviewwithmvvmdaggerproject.retrofit.ProductAPI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule() {

    @Provides
    @Singleton
    fun provideProductRepository(productAPI: ProductAPI, context: Context) : ProductRepository {
        return ProductRepository(productAPI, context)
    }
}