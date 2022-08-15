package com.example.filmsapp.model.retrofit.api

import com.example.filmsapp.model.dto.MovieModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("3/movie/popular?api_key=d313b64de69150d130416dec7b544d6d&language=en-US&page=1")
    suspend fun getPopularMovie(): Response<MovieModel>
}