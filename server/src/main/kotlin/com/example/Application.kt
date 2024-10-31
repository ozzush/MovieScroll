package com.example

import com.example.datamodel.Movie
import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSessions()
    configureSecurity()
    configureHTTP()
    configureMonitoring()
    configureSerialization()
    configureDatabases()

    routing {
        get("/movies") {
            val number = call.parameters["number"]!!.toInt()
            val movies = List(number) { Movie.ALL_MOVIES.random() }
            call.respond(movies)
        }
    }
}
