package com.alexzh.kmp.playground.presentation.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    onScrollableChart: () -> Unit,
    onIconList: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onScrollableChart) {
            Text("Scrollable Chart")
        }

        Button(onClick = onIconList) {
            Text("Icon List")
        }
    }
}