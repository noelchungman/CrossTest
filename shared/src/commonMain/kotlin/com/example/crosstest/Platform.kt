package com.example.crosstest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform