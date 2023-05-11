package com.example.borisovafisha

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import android.content.Context

class MovieAdapter(private val movies: List<Movie>, private val context: Context) :
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
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movie = movies[position]

        // Set the movie title.
        holder.titleView.text = movie.title

        // Set the movie rating.
        holder.ratingView.text = movie.rating.toString()

        // Set the movie director.
        holder.directorView.text = movie.director

        // Set the click listener for the movie item.
        holder.itemView.setOnClickListener {
            // Call the onItemClick() function.
            onItemClick(position)
        }
    }

    // This function is called when a user clicks on a RecyclerView item.
    fun onItemClick(position: Int) {
        // Get the movie object at the clicked position.
        val movie = movies[position]
        Toast.makeText(context, "You clicked on ${movie.title}", Toast.LENGTH_SHORT).show()

    }

}
