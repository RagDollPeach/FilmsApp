package com.example.filmsapp.model.retrofit.api

import com.example.filmsapp.model.dto.MovieModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("3/movie/popular?api_key=f94e32b1066a2635b66b30aa41faf325&language=en-US&page=1")
    suspend fun getPopularMovie(): Response<MovieModel>
}