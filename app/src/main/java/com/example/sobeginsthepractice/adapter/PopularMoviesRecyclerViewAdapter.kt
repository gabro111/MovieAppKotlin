package com.example.sobeginsthepractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sobeginsthepractice.R
import com.example.sobeginsthepractice.api.PopularMovies

class PopularMoviesRecyclerViewAdapter(private val result:PopularMovies):RecyclerView.Adapter<PopularMoviesRecyclerViewAdapter.PopularMoviesRecyclerViewHolder>() {

     class PopularMoviesRecyclerViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){


     }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularMoviesRecyclerViewHolder {
        return PopularMoviesRecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.popular_movie_recycler_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: PopularMoviesRecyclerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = result.results.size
}