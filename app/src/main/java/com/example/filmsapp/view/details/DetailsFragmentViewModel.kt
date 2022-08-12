package com.example.filmsapp.view.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmsapp.REALIZATION
import com.example.filmsapp.model.dto.MovieResult
import com.example.filmsapp.model.room.repository.MoviesRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsFragmentViewModel : ViewModel() {

    fun insert(movieResult: MovieResult, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REALIZATION.insertMovie(movieResult) {
                onSuccess()
            }
        }

    fun delete(movieResult: MovieResult, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REALIZATION.deleteMovie(movieResult) {
                onSuccess()
            }
        }
}