package com.example.sobeginsthepractice.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.sobeginsthepractice.R
import com.example.sobeginsthepractice.databinding.FragmentMovieDetailBinding

class MovieDetailFragment :Fragment(R.layout.fragment_movie_detail) {


    private lateinit var imageView2 : ImageView;
    private val args:MovieDetailFragmentArgs by navArgs<MovieDetailFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView2 = view.findViewById(R.id.imageView2)
        Glide.with(this)
            .load("http://image.tmdb.org/t/p/w500${args.posterPath}")
            .override(350, 450)
            .into(imageView2)
        val movieDetailBinding  = FragmentMovieDetailBinding.bind(view)
        movieDetailBinding.overview = args.overviews
        movieDetailBinding.popularity=args.popularity
        movieDetailBinding.title=args.title
        movieDetailBinding.voteAverage=args.voteAverage
        movieDetailBinding.voteCount=args.voteCount

    }
}