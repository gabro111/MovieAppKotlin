package com.example.sobeginsthepractice.repository

import com.example.sobeginsthepractice.model.api.PopularMovies
import com.example.sobeginsthepractice.api.RetrofitClient
import com.example.sobeginsthepractice.model.api.SearchResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}
class ApiRepository {
    private val api_key:String = "d6575a10f23b90ae43b5a20fed962905"






   val favoriteMovies: Flow<PopularMovies?> = flow{

       while (true){
           val request = RetrofitClient.reqResApi.getMovies(api_key)
           if(request.isSuccessful){
               emit(request.body())
           }
       }
   }

    suspend fun getPopularMovies(): PopularMovies? {
        val request = RetrofitClient.reqResApi.getMovies(api_key)
        if(request.isSuccessful){
            return request.body()!!
        }

        return null
    }

    suspend fun getSearchedMovie(query:String):SearchResponse?{
        val request = RetrofitClient.reqResApi.searchMovie(api_key,query)
        if(request.isSuccessful)
        {
            return request.body()!!
        }

        return null
    }
}