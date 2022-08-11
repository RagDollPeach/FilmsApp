package com.example.filmsapp.view.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.filmsapp.BASE_IMAGE_URL
import com.example.filmsapp.MyApplication
import com.example.filmsapp.R
import com.example.filmsapp.databinding.FragmentDetailsBinding
import com.example.filmsapp.model.dto.MovieResult
import com.example.filmsapp.view.mainfragment.MainFragmentViewModel

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    lateinit var currentMovie: MovieResult

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(layoutInflater)
        currentMovie = arguments?.getSerializable("movie") as MovieResult
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[DetailsFragmentViewModel::class.java]
        Glide.with(MyApplication.getMyApp())
            .load("$BASE_IMAGE_URL${currentMovie.poster_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.imageDetails)
        binding.detailsTitle.text = currentMovie.title
        binding.detailsDate.text = currentMovie.release_date
        binding.detailsDescription.text = currentMovie.overview
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}