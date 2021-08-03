package com.example.sobeginsthepractice.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sobeginsthepractice.R
import com.example.sobeginsthepractice.adapter.SearchMoviesRecyclerViewAdapter
import com.example.sobeginsthepractice.viewmodel.MovieViewModel

class HomeFragment: Fragment(R.layout.fragment_home) {

    private val model: MovieViewModel by viewModels()

    private lateinit var searchRecyclerView : RecyclerView

    private lateinit var searchView: SearchView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchView = view.findViewById(R.id.searchView)
        searchRecyclerView = view.findViewById(R.id.searchRecyclerView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                model.searchNameChanged(newText!!)

                return true
            }

        })



        model.getSearchQuery().observe(viewLifecycleOwner,{ searchResponse->

            if(searchResponse != null){
                searchRecyclerView.visibility = View.VISIBLE
                searchRecyclerView.adapter = SearchMoviesRecyclerViewAdapter(searchResponse)
                searchRecyclerView.layoutManager =GridLayoutManager(this.context,2,
                    GridLayoutManager.VERTICAL,false)
                //popularMovieRecyclerView.layoutManager = GridLayoutManager(this.context,2,GridLayoutManager.HORIZONTAL,false)
            }else {
                searchRecyclerView.visibility = View.INVISIBLE
            }
        })


    }
}


