package com.example.filmsapp.model.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.filmsapp.model.dto.MovieResult

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movieResult: MovieResult)

    @Delete
    suspend fun delete(movieResult: MovieResult)

    @Query("SELECT * FROM movie_table")
    fun getMovies(): LiveData<List<MovieResult>>
}