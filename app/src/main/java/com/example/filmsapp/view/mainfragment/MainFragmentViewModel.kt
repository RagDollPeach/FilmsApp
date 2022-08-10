package com.example.filmsapp.view.mainfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmsapp.model.dto.MovieModel
import com.example.filmsapp.model.retrofit.RetrofitRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel: ViewModel() {

    private val repository = RetrofitRepository()
    val myMovies: MutableLiveData<Response<MovieModel>> = MutableLiveData()

    fun getMovies() {
        viewModelScope.launch {
            myMovies.value = repository.getMovies()
        }
    }
}