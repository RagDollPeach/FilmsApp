package com.example.filmsapp.view.mainfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmsapp.BASE_IMAGE_URL
import com.example.filmsapp.MyApplication
import com.example.filmsapp.R
import com.example.filmsapp.model.dto.MovieResult

class MainAdapter : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    private var listMovies = emptyList<MovieResult>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.item_title).text = listMovies[position].title
        holder.itemView.findViewById<TextView>(R.id.item_date).text = listMovies[position].release_date

        MyApplication.getMyApp().let {
            Glide.with(it)
                .load("$BASE_IMAGE_URL${listMovies[position].poster_path}")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.itemView.findViewById(R.id.item_image))
        }
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun setList(list: List<MovieResult>) {
        listMovies = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            MainFragment.onMovieClick(listMovies[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MyViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}