package com.example.filmsapp.view.favoritefragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.filmsapp.myActivity
import com.example.filmsapp.R
import com.example.filmsapp.databinding.FragmentFavoriteBinding
import com.example.filmsapp.model.dto.MovieResult

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    lateinit var recycler: RecyclerView
    private val adapter by lazy { FavoriteAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        favoriteFlag = true
        _binding = FragmentFavoriteBinding.inflate(layoutInflater)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[FavoriteFragmentViewModel::class.java]
        recycler = binding.favoriteRecycleView
        recycler.adapter = adapter
        viewModel.getAllMovies().observe(viewLifecycleOwner) { list ->
            adapter.setList(list.asReversed())
        }
    }

    companion object {
        fun onMovieClick(model: MovieResult) {
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            myActivity.navController.navigate(R.id.action_favoriteFragment_to_detailsFragment, bundle)
            favoriteFlag = false
        }

        var favoriteFlag = false
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val item = menu.findItem(R.id.menu_favorite)
        item.isVisible = false
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        favoriteFlag = false
    }

}