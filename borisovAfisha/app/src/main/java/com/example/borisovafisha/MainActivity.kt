package com.example.borisovafisha

import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.borisovafisha.DatabaseManager

class MainActivity : ComponentActivity() {

    private val movies = listOf(
        Movie(
            title = "The Shawshank Redemption",
            description = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
            poster = "https://upload.wikimedia.org/wikipedia/en/8/81/ShawshankRedemptionMoviePoster.jpg",
            director = "Frank Darabont",
            writers = "Stephen King (short story), Frank Darabont (screenplay)",
            release_date = "October 14, 1994",
            running_time = "142 minutes",
            country = "United States",
            budget = "$25 million",
            rating = "9.3"
        ),
        Movie(
            title = "Inception",
            description = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
            poster = "https://upload.wikimedia.org/wikipedia/en/2/2e/Inception_%282010%29_theatrical_poster.jpg",
            director = "Christopher Nolan",
            writers = "Christopher Nolan",
            release_date = "July 8, 2010",
            running_time = "148 minutes",
            country = "United States",
            budget = "$160 million",
            rating = "8.8"
        ),
        Movie(
            title = "The Lord of the Rings: The Fellowship of the Ring",
            description = "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",
            poster = "https://upload.wikimedia.org/wikipedia/en/8/8a/The_Lord_of_the_Rings%2C_TFOTR_%282001%29.jpg",
            director = "Peter Jackson",
            writers = "J.R.R. Tolkien (novel), Fran Walsh (screenplay)",
            release_date = "December 19, 2001",
            running_time = "178 minutes",
            country = "New Zealand, United States",
            budget = "$93 million",
            rating = "8.8"
        ),
        Movie(
            title = "Pulp Fiction",
            description = "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
            poster = "https://media.senscritique.com/media/000012288077/source_big/Pulp_Fiction.jpg",
            director = "Quentin Tarantino",
            writers = "Quentin Tarantino, Roger Avary",
            release_date = "October 14, 1994",
            running_time = "154 minutes",
            country = "United States",
            budget = "$8 million",
            rating = "8.9"
        ),

        Movie(
            title = "The Dark Knight",
            description = "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
            poster = "https://m.media-amazon.com/images/M/MV5BODZkYTdhMzQtYzMxYi00OGVjLTgzOTEtYTU5OTBjZDljZDM5XkEyXkFqcGdeQXVyNjczMzc5NzQ@._V1_UY1200_CR95,0,630,1200_AL_.jpg",
            director = "Christopher Nolan",
            writers = "Jonathan Nolan, Christopher Nolan",
            release_date = "July 18, 2008",
            running_time = "152 minutes",
            country = "United States, United Kingdom",
            budget = "$185 million",
            rating = "9.0"
        ),
        Movie(
            title = "The Matrix",
            description = "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.",
            poster = "https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg",
            director = "Lana Wachowski, Lilly Wachowski",
            writers = "Lana Wachowski, Lilly Wachowski",
            release_date = "March 31, 1999",
            running_time = "136 minutes",
            country = "United States",
            budget = "$63 million",
            rating = "8.7"
        ),
        Movie(
            title = "Fight Club",
            description = "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.",
            poster = "https://upload.wikimedia.org/wikipedia/en/f/fc/Fight_Club_poster.jpg",
            director = "David Fincher",
            writers = "Chuck Palahniuk (novel), Jim Uhls (screenplay)",
            release_date = "October 15, 1999",
            running_time = "139 minutes",
            country = "United States, Germany",
            budget = "$63 million",
            rating = "8.8"
        ),
        Movie(
            title = "Fight Club",
            description = "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.",
            poster = "https://upload.wikimedia.org/wikipedia/en/f/fc/Fight_Club_poster.jpg",
            director = "David Fincher",
            writers = "Chuck Palahniuk (novel), Jim Uhls (screenplay)",
            release_date = "October 15, 1999",
            running_time = "139 minutes",
            country = "United States, Germany",
            budget = "$63 million",
            rating = "8.8"
        ),
        Movie(
            title = "Fight Club",
            description = "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.",
            poster = "https://upload.wikimedia.org/wikipedia/en/f/fc/Fight_Club_poster.jpg",
            director = "David Fincher",
            writers = "Chuck Palahniuk (novel), Jim Uhls (screenplay)",
            release_date = "October 15, 1999",
            running_time = "139 minutes",
            country = "United States, Germany",
            budget = "$63 million",
            rating = "8.8"
        ),
        Movie(
            title = "Fight Club",
            description = "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.",
            poster = "https://upload.wikimedia.org/wikipedia/en/f/fc/Fight_Club_poster.jpg",
            director = "David Fincher",
            writers = "Chuck Palahniuk (novel), Jim Uhls (screenplay)",
            release_date = "October 15, 1999",
            running_time = "139 minutes",
            country = "United States, Germany",
            budget = "$63 million",
            rating = "8.8"
        ),
    )

    companion object {
        lateinit var databaseManager: DatabaseManager
        lateinit var movies: List<Movie>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseManager = DatabaseManager(applicationContext)
        print( databaseManager.databaseName )
        databaseManager.getAllMovies()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MovieAdapter(movies, this.applicationContext)

    }

}