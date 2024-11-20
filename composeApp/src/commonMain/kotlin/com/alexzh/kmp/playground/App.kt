package com.alexzh.kmp.playground

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.alexzh.kmp.playground.presentation.features.main.MainScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        MainScreen()
    }
}