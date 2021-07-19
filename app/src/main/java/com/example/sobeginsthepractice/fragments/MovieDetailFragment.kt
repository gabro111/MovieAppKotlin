package com.example.sobeginsthepractice.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.sobeginsthepractice.R

class MovieDetailFragment :Fragment(R.layout.fragment_movie_detail) {

val args:MovieDetailFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }
}