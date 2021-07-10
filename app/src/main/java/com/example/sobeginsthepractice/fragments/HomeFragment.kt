package com.example.sobeginsthepractice.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sobeginsthepractice.R
import com.example.sobeginsthepractice.viewmodel.MovieViewModel

class HomeFragment: Fragment(R.layout.fragment_home) {

    private val model: MovieViewModel by viewModels()

    private lateinit var searchView: SearchView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchView = view.findViewById(R.id.searchView)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                model.searchNameChanged(newText!!)

                return true
            }

        })

        model.getSearchQuerry().observe(viewLifecycleOwner,{

            if(it != null) {
                Log.d("thedata", it.toString())
            }
        })


    }
}


