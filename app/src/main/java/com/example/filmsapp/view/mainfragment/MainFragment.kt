package com.example.filmsapp.view.mainfragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.RecyclerView
import com.example.filmsapp.MainActivity
import com.example.filmsapp.R
import com.example.filmsapp.databinding.FragmentMainBinding
import com.example.filmsapp.mainFlag
import com.example.filmsapp.model.dto.MovieResult
import com.example.filmsapp.myActivity

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    lateinit var recycler: RecyclerView
    private val adapter by lazy { MainAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainFlag = true
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]
        viewModel.getMovies()
        viewModel.initDatabase()
        recycler = binding.mainRecycleView
        recycler.adapter = adapter
        viewModel.myMovies.observe(viewLifecycleOwner) { list ->
            adapter.setList(list.body()!!.results)
        }
//        val scrollListener = recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//
//            }
//        })
    }

    fun onMovieClick(model: MovieResult) {
        val bundle = Bundle()
        bundle.putSerializable("movie", model)
        (requireActivity() as MainActivity).navController.navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
        mainFlag = false
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        mainFlag = false
    }
}