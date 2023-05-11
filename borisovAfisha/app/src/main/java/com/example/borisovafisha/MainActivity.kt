package com.example.borisovafisha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.borisovafisha.ui.theme.BorisovAfishaTheme

class MainActivity : ComponentActivity() {

    private val movies = listOf(
        Movie(
            title = "The Shawshank Redemption",
            description = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
            poster = "https://example.com/shawshank_redemption.jpg",
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
            poster = "https://example.com/inception.jpg",
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
            poster = "https://example.com/lotr_fellowship.jpg",
            director = "Peter Jackson",
            writers = "J.R.R. Tolkien (novel), Fran Walsh (screenplay)",
            release_date = "December 19, 2001",
            running_time = "178 minutes",
            country = "New Zealand, United States",
            budget = "$93 million",
            rating = "8.8"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MovieAdapter(movies, this.applicationContext)

    }

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BorisovAfishaTheme {
        Greeting("Android")
    }
}