package com.example.sobeginsthepractice.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.*
import com.example.sobeginsthepractice.R
import com.example.sobeginsthepractice.adapter.PopularMoviesRecyclerViewAdapter
import com.example.sobeginsthepractice.viewmodel.MovieViewModel


class PopularFragment: Fragment(R.layout.fragment_popular) {
    private val model: MovieViewModel by viewModels()

    private lateinit var popularMovieRecyclerView : RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        popularMovieRecyclerView = view.findViewById(R.id.popularMovieRecyclerView)
        val snapHelper: SnapHelper = PagerSnapHelper()


        model.getPoplarMovies().observe(viewLifecycleOwner, { popularMovies->
            popularMovieRecyclerView.adapter = PopularMoviesRecyclerViewAdapter(popularMovies!!);
           popularMovieRecyclerView.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)

            //popularMovieRecyclerView.layoutManager = GridLayoutManager(this.context,2,GridLayoutManager.HORIZONTAL,false)
            popularMovieRecyclerView.itemAnimator = DefaultItemAnimator()
            snapHelper.attachToRecyclerView(popularMovieRecyclerView);


        })
    }
}