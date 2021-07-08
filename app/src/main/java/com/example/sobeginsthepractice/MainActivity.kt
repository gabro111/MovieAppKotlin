package com.example.sobeginsthepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import com.example.sobeginsthepractice.api.PopularMovies
import com.example.sobeginsthepractice.api.RetrofitClient
import com.example.sobeginsthepractice.databinding.ActivityMainBinding
import com.example.sobeginsthepractice.model.Movie
import com.example.sobeginsthepractice.viewmodel.MovieViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding=
            DataBindingUtil.setContentView(this,R.layout.activity_main)

    }




}