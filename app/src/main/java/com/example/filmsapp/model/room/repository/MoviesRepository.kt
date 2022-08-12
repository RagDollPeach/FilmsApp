package com.example.filmsapp.model.room.repository

import androidx.lifecycle.LiveData
import com.example.filmsapp.model.dto.MovieResult

interface MoviesRepository {

    val allMovies: LiveData<List<MovieResult>>
    suspend fun insertMovie(movieResult: MovieResult, onSuccess:() -> Unit)
    suspend fun deleteMovie(movieResult: MovieResult, onSuccess:() -> Unit)
}