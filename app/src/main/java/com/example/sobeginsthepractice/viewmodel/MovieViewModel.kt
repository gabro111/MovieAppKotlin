package com.example.sobeginsthepractice.viewmodel

import androidx.lifecycle.*
import com.example.sobeginsthepractice.model.api.PopularMovies
import com.example.sobeginsthepractice.model.api.SearchResponse
import com.example.sobeginsthepractice.repository.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

import kotlinx.coroutines.launch


class MovieViewModel : ViewModel() {

    private val repository: ApiRepository = ApiRepository()
    private val popularMovies:MutableLiveData<PopularMovies?> by lazy {
        MutableLiveData<PopularMovies?>().also {
            populatePopularMovies()
        }
    }

   fun collectFlow(){
       viewModelScope.launch {
           repository.favoriteMovies.collect { popularMovies ->

           }
       }
   }



    private var searchedMovies:MutableLiveData<SearchResponse?>  = MutableLiveData()

     fun getSearchQuery() : LiveData<SearchResponse?>{
         return Transformations.switchMap(searchLivedt){name-> populateSearchedMovies(name)
             searchedMovies
         }
     }
    var searchLivedt:MutableLiveData<String> = MutableLiveData("g")
    fun searchNameChanged(name: String) {
        searchLivedt.value = name
    }


    private fun populatePopularMovies(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getPopularMovies()
            popularMovies.postValue(response)
        }

    }
     private fun populateSearchedMovies(query:String){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getSearchedMovie(query)
            searchedMovies.postValue(response)
        }
    }
    fun getPoplarMovies(): LiveData<PopularMovies?> {
        return popularMovies
    }

}