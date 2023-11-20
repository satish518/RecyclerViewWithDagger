package com.example.recyclerviewwithmvvmdaggerproject

import android.app.Application
import com.example.recyclerviewwithmvvmdaggerproject.di.ApplicationComponent
import com.example.recyclerviewwithmvvmdaggerproject.di.DaggerApplicationComponent

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(applicationContext)
    }


}