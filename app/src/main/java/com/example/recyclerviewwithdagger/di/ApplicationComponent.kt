package com.example.recyclerviewwithmvvmdaggerproject.di

import android.content.Context
import com.example.recyclerviewwithdagger.MainActivity
import com.example.recyclerviewwithmvvmdaggerproject.viewmodel.ProductViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context) : ApplicationComponent

    }

}