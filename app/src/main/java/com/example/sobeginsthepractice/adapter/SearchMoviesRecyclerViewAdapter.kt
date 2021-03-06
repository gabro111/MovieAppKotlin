package com.example.sobeginsthepractice.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.sobeginsthepractice.R
import com.example.sobeginsthepractice.fragments.HomeFragmentDirections
import com.example.sobeginsthepractice.model.api.SearchResponse

class SearchMoviesRecyclerViewAdapter(private val item:SearchResponse):RecyclerView.Adapter<SearchMoviesRecyclerViewAdapter.SearchMovieRecyclerViewHolder>() {

    class SearchMovieRecyclerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){


        val searchMovieView:ImageView = itemView.findViewById(R.id.searchMovieView)

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
        holder.itemView.setOnClickListener{
            if(item.results[position].posterPath  != null) {
                val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(
                    item.results[position].overview,
                    item.results[position].title,
                    popularity = item.results[position].popularity.toString(),
                    voteAverage = item.results[position].voteAverage.toString(),
                    voteCount = item.results[position].voteCount,
                    posterPath = item.results[position].posterPath!!
                )
                holder.itemView.findNavController().navigate(action)
            }else{
                val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(
                    item.results[position].overview,
                    item.results[position].title,
                    popularity = item.results[position].popularity.toString(),
                    voteAverage = item.results[position].voteAverage.toString(),
                    voteCount = item.results[position].voteCount,
                    posterPath = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJkMkX41fLskWMAFjaRPKyrsuN401djg22fQ&usqp=CAU"
                )
                holder.itemView.findNavController().navigate(action)
            }
        }


        if(item.results[position].posterPath == null){
            Glide.with(holder.itemView)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJkMkX41fLskWMAFjaRPKyrsuN401djg22fQ&usqp=CAU")
                .placeholder(CircularProgressDrawable(holder.itemView.context))
                .override(250,350)
                .into(holder.searchMovieView)
        }else {
            Glide.with(holder.itemView)
                .load("http://image.tmdb.org/t/p/w500${item.results[position].posterPath}")
                .placeholder(CircularProgressDrawable(holder.itemView.context))
                .override(250, 350)
                .into(holder.searchMovieView)
        }



    }

    override fun getItemCount(): Int = item.results.size

}