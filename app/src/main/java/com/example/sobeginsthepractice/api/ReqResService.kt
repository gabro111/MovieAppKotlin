package com.example.sobeginsthepractice.api

import com.example.sobeginsthepractice.model.Movie
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ReqResService {

    @POST("/3/movie/popular")
    suspend fun getMovies(@Query("api_key") key: String): Response<PopularMovies>
}