package com.example.moviescroll.client

//import io.ktor.client.plugins.logging.*
import com.example.moviescroll.ui.elements.Movie
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.request.*
import io.ktor.http.*

class Client(private val url: String) {
    private val client = try {
        HttpClient(OkHttp) {
            engine {
                config {
                    followRedirects(true)
                }
            }
//        install(ContentNegotiation) {
//            json()
//        }
//        install(Logging) {}
        }
    } catch (e: Exception) {
        println("Couldn't initialize HTTP client for url $url")
        println(e)
        null
    }

    suspend fun getMovies(number: Int = 1): List<Movie> {
        val response = client?.get(url) {
            url { path("movies") }
            parameters { append("number", number.toString()) }
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
        return response?.body() ?: List(number) { Movie.ALL_MOVIES.random() }
    }
}