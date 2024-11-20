package com.alexzh.kmp.playground

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform