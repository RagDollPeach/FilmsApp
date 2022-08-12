package com.example.filmsapp.model.room.repository

import androidx.lifecycle.LiveData
import com.example.filmsapp.model.dto.MovieResult
import com.example.filmsapp.model.room.dao.MoviesDao

class MoviesRepositoryImpl(private val moviesDao: MoviesDao) : MoviesRepository {

    override val allMovies: LiveData<List<MovieResult>>
        get() = moviesDao.getMovies()

    override suspend fun insertMovie(movieResult: MovieResult, onSuccess: () -> Unit) {
        moviesDao.insert(movieResult)
        onSuccess()
    }

    override suspend fun deleteMovie(movieResult: MovieResult, onSuccess: () -> Unit) {
        moviesDao.delete(movieResult)
        onSuccess()
    }
}