package com.example.moviescroll.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

data class Person(
    val name: String,
    val surname: String,
    val dateOfBirth: String? = null,
    val dateOfDeath: String? = null,
    val countries: List<String> = emptyList(),
    val photoUrl: String? = null,
    val occupations: List<String> = emptyList(),
    val movies: List<String> = emptyList()
) {
    @Composable
    fun Element() {
        CardWithImage(imageUrl = photoUrl, imageDescription = "$name $surname photo") {
            Text(text = "$name $surname", style = MaterialTheme.typography.headlineMedium)
            Text(text = listOfNotNull(dateOfBirth, dateOfDeath).joinToString(" - "))
            Text(text = "Country: ${countries.joinToString(", ")}")
            Text(text = "Occupation: ${occupations.joinToString(", ")}")
            Text(text = "Movies: ${movies.take(3).joinToString(", ")}")
        }
    }

    companion object {
        val ALL_PEOPLE = listOf(
            Person(
                name = "Steven",
                surname = "Spielberg",
                dateOfBirth = "1946-12-18",
                countries = listOf("American"),
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/8/82/Steven_Spielberg_%282011%29_cropped.jpg",
                occupations = listOf("Director", "Producer", "Screenwriter"),
                movies = listOf("Jaws", "E.T.", "Jurassic Park")
            ),
            Person(
                name = "Meryl",
                surname = "Streep",
                dateOfBirth = "1949-06-22",
                countries = listOf("American"),
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/e/e4/Meryl_Streep_at_the_2016_Berlinale.jpg",
                occupations = listOf("Actress"),
                movies = listOf("The Devil Wears Prada", "Sophie's Choice", "Mamma Mia!")
            ),
            Person(
                name = "Christopher",
                surname = "Nolan",
                dateOfBirth = "1970-07-30",
                countries = listOf("British", "American"),
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/0/08/Christopher_Nolan_Cannes_2018.jpg",
                occupations = listOf("Director", "Producer", "Screenwriter"),
                movies = listOf("Inception", "The Dark Knight", "Interstellar")
            ),
            Person(
                name = "Natalie",
                surname = "Portman",
                dateOfBirth = "1981-06-09",
                countries = listOf("Israeli", "American"),
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/a/a0/Natalie_Portman_Cannes_2015_5_%28cropped%29.jpg",
                occupations = listOf("Actress"),
                movies = listOf("Black Swan", "V for Vendetta", "Jackie")
            ),
            Person(
                name = "Quentin",
                surname = "Tarantino",
                dateOfBirth = "1963-03-27",
                countries = listOf("American"),
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/d/d6/Quentin_Tarantino_by_Gage_Skidmore.jpg",
                occupations = listOf("Director", "Writer", "Producer"),
                movies = listOf("Pulp Fiction", "Kill Bill", "Django Unchained")
            ),
            Person(
                name = "Cate",
                surname = "Blanchett",
                dateOfBirth = "1969-05-14",
                countries = listOf("Australian"),
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/a/a4/Cate_Blanchett_2018.jpg",
                occupations = listOf("Actress"),
                movies = listOf("Blue Jasmine", "Carol", "The Lord of the Rings")
            ),
            Person(
                name = "Martin",
                surname = "Scorsese",
                dateOfBirth = "1942-11-17",
                countries = listOf("American"),
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/a/aa/Martin_Scorsese_Berlinale_2010_%28cropped%29.jpg",
                occupations = listOf("Director", "Producer", "Screenwriter"),
                movies = listOf("Goodfellas", "Taxi Driver", "The Irishman")
            ),
            Person(
                name = "Leonardo",
                surname = "DiCaprio",
                dateOfBirth = "1974-11-11",
                countries = listOf("American"),
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/c/c1/Leonardo_DiCaprio_2014.jpg",
                occupations = listOf("Actor"),
                movies = listOf("Inception", "Titanic", "The Revenant")
            ),
            Person(
                name = "Greta",
                surname = "Gerwig",
                dateOfBirth = "1983-08-04",
                countries = listOf("American"),
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/5/58/Greta_Gerwig_Berlinale_2018_%28cropped%29.jpg",
                occupations = listOf("Director", "Actress", "Writer"),
                movies = listOf("Lady Bird", "Little Women", "Frances Ha")
            ),
            Person(
                name = "Denzel",
                surname = "Washington",
                dateOfBirth = "1954-12-28",
                countries = listOf("American"),
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/8/87/Denzel_Washington_at_a_Press_Conference_for_The_Equalizer.jpg",
                occupations = listOf("Actor", "Producer"),
                movies = listOf("Training Day", "Malcolm X", "Fences")
            )
        )
    }
}