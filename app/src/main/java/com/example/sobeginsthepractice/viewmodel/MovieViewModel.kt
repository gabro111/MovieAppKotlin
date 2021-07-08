package com.example.sobeginsthepractice.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sobeginsthepractice.R
import com.example.sobeginsthepractice.api.PopularMovies
import com.example.sobeginsthepractice.api.RetrofitClient
import com.example.sobeginsthepractice.model.Movie
import com.example.sobeginsthepractice.repository.ApiRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    private val repository = ApiRepository()

    private val popularMovies:MutableLiveData<PopularMovies?> by lazy {
        MutableLiveData<PopularMovies?>().also {
            populatePopularMovies()
        }
    }



    private fun populatePopularMovies(){
        viewModelScope.launch {
            val response = repository.getPopularMovies()
            popularMovies.postValue(response)
        }

    }


    fun getPoplarMovies(): LiveData<PopularMovies?> {
        return popularMovies
    }

}