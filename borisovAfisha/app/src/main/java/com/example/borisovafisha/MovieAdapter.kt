package com.example.borisovafisha

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView: TextView = itemView.findViewById(R.id.txt_movie_title)
        val ratingView: TextView = itemView.findViewById(R.id.txt_movie_rating)
        val directorView: TextView = itemView.findViewById(R.id.txt_movie_director)
    }


    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.titleView.text = movie.title
        holder.ratingView.text = movie.rating.toString()
        holder.directorView.text = movie.director
    }

}
