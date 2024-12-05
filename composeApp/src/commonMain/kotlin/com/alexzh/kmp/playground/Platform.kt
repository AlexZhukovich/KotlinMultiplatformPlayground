package com.alexzh.kmp.playground

sealed class Platform {
    data object Android : Platform()
    data object Desktop : Platform()
    data object Ios : Platform()
    data object Web : Platform()
}

expect val platform: Platform