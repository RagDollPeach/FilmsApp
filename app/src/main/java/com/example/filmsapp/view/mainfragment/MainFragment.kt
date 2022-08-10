package com.example.filmsapp.view.mainfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.filmsapp.R
import com.example.filmsapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    lateinit var recycler: RecyclerView
    private val adapter by lazy { MainAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
        recycler = binding.mainRecycleView
        recycler.adapter = adapter
        viewModel.myMovies.observe(viewLifecycleOwner) { list ->
            adapter.setList(list.body()!!.results)
        }
    }

    private fun changeFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack("")
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}