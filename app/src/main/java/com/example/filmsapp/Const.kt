package com.example.filmsapp

import com.example.filmsapp.model.room.repository.MoviesRepositoryImpl

const val BASE_URL = "https://api.themoviedb.org/"
const val BASE_IMAGE_URL = "https://www.themoviedb.org/t/p/w300_and_h450_bestv2"
lateinit var myActivity: MainActivity
lateinit var REALIZATION: MoviesRepositoryImpl
var mainFlag = false
var favoriteFlag = false
var detailsFlag = false