package com.example.filmsapp.model.dto

data class MovieModel(
    val page: Int,
    val results: List<MovieResult>,
    val total_pages: Int,
    val total_results: Int
)