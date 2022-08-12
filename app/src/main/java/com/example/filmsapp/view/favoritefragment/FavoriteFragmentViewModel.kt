package com.example.filmsapp.view.favoritefragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.filmsapp.REALIZATION
import com.example.filmsapp.model.dto.MovieResult

class FavoriteFragmentViewModel: ViewModel() {

    fun getAllMovies(): LiveData<List<MovieResult>> {
        return REALIZATION.allMovies
    }
}