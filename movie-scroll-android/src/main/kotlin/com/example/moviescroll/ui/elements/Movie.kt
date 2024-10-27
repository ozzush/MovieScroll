package com.example.moviescroll.ui.elements

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Movie(
    val title: String,
    val releaseDate: String,
    val genres: List<String>,
    val director: String,
    val mainActors: List<String>,
    val posterUrl: String?,
    val description: String
) {
    @Composable
    fun Element() {
        CardWithImage(posterUrl, "$title poster") {
            Text(text = title, style = MaterialTheme.typography.headlineMedium)
            Text(text = "Release Date: $releaseDate")
            Text(text = "Genres: ${genres.joinToString(", ")}")
            Text(text = "Director: $director")
            Text(text = "Starring: ${mainActors.joinToString(", ")}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = description)
        }
    }

    companion object {
        val ALL_MOVIES = listOf(
            Movie(
                title = "Inception",
                releaseDate = "2010-07-16",
                genres = listOf("Science Fiction", "Action", "Thriller"),
                director = "Christopher Nolan",
                mainActors = listOf("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Elliot Page"),
                posterUrl = "https://upload.wikimedia.org/wikipedia/en/7/7f/Inception_ver3.jpg",
                description = "A skilled thief is offered a chance to have his past crimes forgiven if he can implant an idea into a target's subconscious."
            ),
            Movie(
                title = "The Shawshank Redemption",
                releaseDate = "1994-09-23",
                genres = listOf("Drama"),
                director = "Frank Darabont",
                mainActors = listOf("Tim Robbins", "Morgan Freeman"),
                posterUrl = "https://upload.wikimedia.org/wikipedia/en/8/81/ShawshankRedemptionMoviePoster.jpg",
                description = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."
            ),
            Movie(
                title = "Pulp Fiction",
                releaseDate = "1994-10-14",
                genres = listOf("Crime", "Drama"),
                director = "Quentin Tarantino",
                mainActors = listOf("John Travolta", "Uma Thurman", "Samuel L. Jackson"),
                posterUrl = "https://upload.wikimedia.org/wikipedia/en/8/82/Pulp_Fiction_cover.jpg",
                description = "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption."
            ),
            Movie(
                title = "The Godfather",
                releaseDate = "1972-03-24",
                genres = listOf("Crime", "Drama"),
                director = "Francis Ford Coppola",
                mainActors = listOf("Marlon Brando", "Al Pacino", "James Caan"),
                posterUrl = "https://upload.wikimedia.org/wikipedia/en/1/1c/Godfather_ver1.jpg",
                description = "The aging patriarch of an organized crime dynasty transfers control of his empire to his reluctant son."
            ),
            Movie(
                title = "The Dark Knight",
                releaseDate = "2008-07-18",
                genres = listOf("Action", "Crime", "Drama"),
                director = "Christopher Nolan",
                mainActors = listOf("Christian Bale", "Heath Ledger", "Aaron Eckhart"),
                posterUrl = "https://upload.wikimedia.org/wikipedia/en/8/8a/Dark_Knight.jpg",
                description = "When the menace known as the Joker emerges, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."
            ),
            Movie(
                title = "Fight Club",
                releaseDate = "1999-10-15",
                genres = listOf("Drama", "Thriller"),
                director = "David Fincher",
                mainActors = listOf("Brad Pitt", "Edward Norton", "Helena Bonham Carter"),
                posterUrl = "https://upload.wikimedia.org/wikipedia/en/f/fc/Fight_Club_poster.jpg",
                description = "An insomniac office worker and a soap maker form an underground fight club that evolves into something much more."
            ),
            Movie(
                title = "Forrest Gump",
                releaseDate = "1994-07-06",
                genres = listOf("Drama", "Romance"),
                director = "Robert Zemeckis",
                mainActors = listOf("Tom Hanks", "Robin Wright", "Gary Sinise"),
                posterUrl = "https://upload.wikimedia.org/wikipedia/en/6/67/Forrest_Gump_poster.jpg",
                description = "The story of Forrest Gump, a man with a low IQ, who witnesses and influences several historical events in the 20th century."
            ),
            Movie(
                title = "The Matrix",
                releaseDate = "1999-03-31",
                genres = listOf("Action", "Sci-Fi"),
                director = "The Wachowskis",
                mainActors = listOf("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"),
                posterUrl = "https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg",
                description = "A computer hacker learns about the true nature of his reality and his role in the war against its controllers."
            ),
            Movie(
                title = "The Lord of the Rings: The Fellowship of the Ring",
                releaseDate = "2001-12-19",
                genres = listOf("Adventure", "Drama", "Fantasy"),
                director = "Peter Jackson",
                mainActors = listOf("Elijah Wood", "Ian McKellen", "Orlando Bloom"),
                posterUrl = "https://upload.wikimedia.org/wikipedia/en/8/87/Ringstrilogyposter.jpg",
                description = "A young hobbit and his companions set out on a quest to destroy a powerful ring and defeat the Dark Lord Sauron."
            ),
            Movie(
                title = "The Silence of the Lambs",
                releaseDate = "1991-02-14",
                genres = listOf("Crime", "Drama", "Thriller"),
                director = "Jonathan Demme",
                mainActors = listOf("Jodie Foster", "Anthony Hopkins"),
                posterUrl = "https://upload.wikimedia.org/wikipedia/en/8/86/The_Silence_of_the_Lambs_poster.jpg",
                description = "A young FBI cadet seeks the help of an imprisoned cannibal to catch another serial killer on the loose."
            )
        )
    }
}