package com.example.sobeginsthepractice.api

import com.example.sobeginsthepractice.model.api.PopularMovies
import com.example.sobeginsthepractice.model.api.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ReqResService {

    @POST("/3/movie/popular")
    suspend fun getMovies(@Query("api_key") key: String): Response<PopularMovies>

    @GET("/3/search/movie")
    suspend fun searchMovie(@Query("api_key")key: String,
                            @Query("query")query:String,
                            @Query("include_adult")case:Boolean = true, ):Response<SearchResponse>
    @GET("/3/discover/movie")
    suspend fun sortBySearchKey(@Query("api_key")key:String,
                                @Query("sort_by")query: String)


}