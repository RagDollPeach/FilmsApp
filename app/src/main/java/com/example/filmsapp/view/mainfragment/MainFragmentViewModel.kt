package com.example.filmsapp.view.mainfragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.filmsapp.REALIZATION
import com.example.filmsapp.model.dto.MovieModel
import com.example.filmsapp.model.retrofit.RetrofitRepository
import com.example.filmsapp.model.room.MoviesRoomDatabase
import com.example.filmsapp.model.room.repository.MoviesRepositoryImpl
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RetrofitRepository()
    val myMovies: MutableLiveData<Response<MovieModel>> = MutableLiveData()
    val context = application

    fun getMovies() {
        viewModelScope.launch {
            myMovies.value = repository.getMovies()
        }
    }

    fun initDatabase() {
        val daoMovie = MoviesRoomDatabase.getInstance(context).getMovieDao()
        REALIZATION = MoviesRepositoryImpl(daoMovie)
    }
}