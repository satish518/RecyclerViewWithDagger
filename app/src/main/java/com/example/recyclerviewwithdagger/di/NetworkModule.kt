package com.example.recyclerviewwithmvvmdaggerproject.di

import com.example.recyclerviewwithmvvmdaggerproject.retrofit.ProductAPI
import com.example.recyclerviewwithmvvmdaggerproject.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideProductApi(retrofit: Retrofit) : ProductAPI {
        return retrofit.create(ProductAPI::class.java)
    }
}