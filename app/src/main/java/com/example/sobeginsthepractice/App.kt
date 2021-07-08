package com.example.sobeginsthepractice

import android.app.Application
import com.example.sobeginsthepractice.api.RetrofitClient

class App:Application() {

    companion object{
        lateinit var instance:App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        RetrofitClient.initClient()
        instance = this
    }
}