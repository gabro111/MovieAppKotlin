package com.example.sobeginsthepractice.fragments

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sobeginsthepractice.R
import com.example.sobeginsthepractice.viewmodel.MovieViewModel

class PopularFragment: Fragment(R.layout.fragment_popular) {
    private val model: MovieViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}