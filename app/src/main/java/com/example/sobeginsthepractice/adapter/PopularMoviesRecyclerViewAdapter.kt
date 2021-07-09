package com.example.sobeginsthepractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sobeginsthepractice.R
import com.example.sobeginsthepractice.model.api.PopularMovies

class PopularMoviesRecyclerViewAdapter(private val result: PopularMovies):RecyclerView.Adapter<PopularMoviesRecyclerViewAdapter.PopularMoviesRecyclerViewHolder>() {

     class PopularMoviesRecyclerViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val imageView: ImageView = itemView.findViewById(R.id.imageView)
         val ratingView : TextView = itemView.findViewById(R.id.ratingView)
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
        Glide.with(holder.itemView)
            .load("http://image.tmdb.org/t/p/w500${result.results[position].poster_path}")
            .override(250, 350)
            .into(holder.imageView)
        holder.ratingView.text  = result.results[position].vote_average.toString()
    }

    override fun getItemCount(): Int = result.results.size
}