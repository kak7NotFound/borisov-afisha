package com.example.borisovafisha

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.net.URL


class AboutMovieActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_movie)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var movie = MovieAdapter.lastPickedMovie

        val posterImageView: ImageView = findViewById(R.id.image_poster)
        val titleTextView: TextView = findViewById(R.id.text_title)
        val descriptionTextView: TextView = findViewById(R.id.text_description)
        val directorTextView: TextView = findViewById(R.id.text_director)
        val writersTextView: TextView = findViewById(R.id.text_writers)
        val releaseDateTextView: TextView = findViewById(R.id.text_release_date)
        val runningTimeTextView: TextView = findViewById(R.id.text_running_time)
        val countryTextView: TextView = findViewById(R.id.text_country)
        val budgetTextView: TextView = findViewById(R.id.text_budget)
        val ratingTextView: TextView = findViewById(R.id.text_rating)

        Thread {
            try {
                val inputStream = URL(movie.poster).openStream()
                val bitmap = BitmapFactory.decodeStream(inputStream)
                Handler(Looper.getMainLooper()).post(Runnable { posterImageView.setImageBitmap(bitmap) })
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }.start()

//        Picasso.get().load(movie.poster).into(posterImageView);
        titleTextView.text = movie.title
        descriptionTextView.text = movie.description
        directorTextView.text = "Director: ${movie.director}"
        writersTextView.text = "Writers: ${movie.writers}"
        releaseDateTextView.text = "Release Date: ${movie.release_date}"
        runningTimeTextView.text = "Running Time: ${movie.running_time}"
        countryTextView.text = "Country: ${movie.country}"
        budgetTextView.text = "Budget: ${movie.budget}"
        ratingTextView.text = "Rating: ${movie.rating} ⭐"
    }

}