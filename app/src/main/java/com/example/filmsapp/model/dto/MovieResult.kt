package com.example.filmsapp.model.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie_table")
data class MovieResult(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val title: String,

    val poster_path: String,

    val release_date: String,

    val overview: String,

) : Serializable