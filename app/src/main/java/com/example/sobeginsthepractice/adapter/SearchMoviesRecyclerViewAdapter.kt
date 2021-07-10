package com.example.sobeginsthepractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sobeginsthepractice.R
import com.example.sobeginsthepractice.model.api.SearchResponse

class SearchMoviesRecyclerViewAdapter(private val item:SearchResponse):RecyclerView.Adapter<SearchMoviesRecyclerViewAdapter.SearchMovieRecyclerViewHolder>() {

    class SearchMovieRecyclerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchMovieRecyclerViewHolder {
        return SearchMovieRecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.search_movie_recycler_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: SearchMovieRecyclerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = item.totalResults

}