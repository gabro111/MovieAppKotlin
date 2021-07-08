package com.example.sobeginsthepractice.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private lateinit var retrofit: Retrofit
    private lateinit var okHttpClient: OkHttpClient
    fun initClient(){
        okHttpClient = OkHttpClient.Builder()
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun <S>getService(serviceClass:Class<S>):S{
        return retrofit.create(serviceClass)
    }
    val reqResApi:ReqResService
        get() = getService(ReqResService::class.java)
}