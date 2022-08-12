package com.example.filmsapp.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.filmsapp.model.dto.MovieResult
import com.example.filmsapp.model.room.dao.MoviesDao

@Database(entities = [MovieResult::class], version = 1)
abstract class MoviesRoomDatabase: RoomDatabase() {

    abstract fun getMovieDao(): MoviesDao

    companion object {
        private var database: MoviesRoomDatabase? = null

        fun getInstance(context: Context): MoviesRoomDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(context, MoviesRoomDatabase::class.java, "database")
                    .build()
                database as MoviesRoomDatabase
            } else {
                database as MoviesRoomDatabase
            }
        }
    }
}