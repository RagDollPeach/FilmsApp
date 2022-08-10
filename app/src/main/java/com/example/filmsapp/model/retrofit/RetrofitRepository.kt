package com.example.filmsapp.model.retrofit

import com.example.filmsapp.model.dto.MovieModel
import com.example.filmsapp.model.retrofit.api.RetrofitInstance
import retrofit2.Response

class RetrofitRepository {

    suspend fun getMovies(): Response<MovieModel> {
        return RetrofitInstance.api.getPopularMovie()
    }
 }