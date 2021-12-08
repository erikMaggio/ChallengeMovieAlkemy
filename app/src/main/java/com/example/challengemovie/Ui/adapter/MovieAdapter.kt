package com.example.challengemovie.Ui.Fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengemovie.R
import com.example.challengemovie.databinding.ItemMovieBinding
import com.example.challengemovie.model.Response.Movie
import com.squareup.picasso.Picasso

class MovieAdapter(val movieList: Array<Movie>) : RecyclerView.Adapter<MovieHolder>() {

    private lateinit var listener: OnClickListener

    interface OnClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener2: OnClickListener) {
        listener = listener2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)

        return MovieHolder(view, listener)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.render(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MovieHolder(view: View, listener: MovieAdapter.OnClickListener) :
    RecyclerView.ViewHolder(view) {

    private var binding = ItemMovieBinding.bind(view)

    fun render(movie: Movie) {
        binding.tvTitle.text = movie.title

        Picasso.get().load("https://image.tmdb.org/t/p/w500/${movie.poster}").into(binding.ivMovie)
    }

    init {
        view.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }
    }
}