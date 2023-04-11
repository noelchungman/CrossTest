package com.example.crosstest

// Show get method got content (8/17)
import RocketLaunch
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

// Show get method got content (10/17)
import io.ktor.client.call.*
import io.ktor.client.request.*

import daysUntilNewYear

class Greeting {
    private val platform: Platform = getPlatform()

    // Show get method got content (9/17)
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    // fun greet(): String {
    //    return "Guess what it is! >  ${platform.name.reversed()}!" +
    //    "\nThere are only ${daysUntilNewYear()} days left until New Year! 🎆"
    // }

    // Show get method got content (11/17)
    // The suspend modifier in the greet() function is necessary because it now contains a call to get().
    // It's a suspend function that has an asynchronous operation to retrieve data over the internet and
    // can only be called from within a coroutine or another suspend function.
    // The network request will be executed in the HTTP client's thread pool.
    @Throws(Exception::class)
    suspend fun greet(): String {
        val rockets: List<RocketLaunch> =
            httpClient.get("https://api.spacexdata.com/v4/launches").body()
        val lastSuccessLaunch = rockets.last { it.launchSuccess == true }
        return "Guess what it is! > ${platform.name.reversed()}!" +
                "\nThere are only ${daysUntilNewYear()} left until New Year! 🎆" +
                "\nThe last successful launch was ${lastSuccessLaunch.launchDateUTC} 🚀"
    }

}