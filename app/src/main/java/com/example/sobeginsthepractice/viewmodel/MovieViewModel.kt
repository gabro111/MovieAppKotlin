package com.example.sobeginsthepractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sobeginsthepractice.model.api.PopularMovies
import com.example.sobeginsthepractice.model.api.SearchResponse
import com.example.sobeginsthepractice.repository.ApiRepository
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private var repository:ApiRepository = ApiRepository()

    private val popularMovies:MutableLiveData<PopularMovies?> by lazy {
        MutableLiveData<PopularMovies?>().also {
            populatePopularMovies()
        }
    }

 private val searchedMovies:MutableLiveData<SearchResponse?> by lazy{
     MutableLiveData<SearchResponse?>().also {
         populateSearchedMovies("Game")
     }
 }

    private fun populatePopularMovies(){
        viewModelScope.launch {
            val response = repository.getPopularMovies()
            popularMovies.postValue(response)
        }

    }

     fun populateSearchedMovies(querry:String){
        viewModelScope.launch {
            val response = repository.getSearchedMovie(querry)
            searchedMovies.postValue(response)
        }
    }
    fun getPoplarMovies(): LiveData<PopularMovies?> {
        return popularMovies
    }


    fun getSearchQuery(): MutableLiveData<SearchResponse?> {
        return searchedMovies
    }
}