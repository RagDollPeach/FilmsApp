package com.example.filmsapp.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.filmsapp.*
import com.example.filmsapp.databinding.FragmentDetailsBinding
import com.example.filmsapp.model.dto.MovieResult

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var currentMovie: MovieResult
    private var isFavorite = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailsFlag = true
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
        val favoriteValue = MyApplication.getFavorite(currentMovie.id.toString())

        if (isFavorite != favoriteValue) {
            binding.detailsImageFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            binding.detailsImageFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }

        Glide.with(MyApplication.getMyApp())
            .load("$BASE_IMAGE_URL${currentMovie.poster_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.imageDetails)
        binding.detailsTitle.text = currentMovie.title
        binding.detailsDate.text = currentMovie.release_date
        binding.detailsDescription.text = currentMovie.overview

        binding.detailsImageFavorite.setOnClickListener {
            isFavorite = if(isFavorite == favoriteValue) {
                binding.detailsImageFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                MyApplication.setFavorite(currentMovie.id.toString(), true)
                viewModel.insert(currentMovie){}
                true
            } else {
                binding.detailsImageFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                MyApplication.setFavorite(currentMovie.id.toString(), false)
                viewModel.delete(currentMovie){}
                false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        detailsFlag = false
    }
}