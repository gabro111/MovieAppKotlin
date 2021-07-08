package com.example.sobeginsthepractice.repository

import com.example.sobeginsthepractice.api.PopularMovies
import com.example.sobeginsthepractice.api.RetrofitClient

class ApiRepository {
    private val api_key:String = "d6575a10f23b90ae43b5a20fed962905"
    suspend fun getPopularMovies(): PopularMovies? {

        val request = RetrofitClient.reqResApi.getMovies(api_key)

        if(request.isSuccessful){
            return request.body()!!

        }


        return null
    }
}