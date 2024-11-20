package com.alexzh.kmp.playground.presentation.features.chart

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.github.koalaplot.core.ChartLayout
import io.github.koalaplot.core.bar.DefaultVerticalBar
import io.github.koalaplot.core.bar.VerticalBarPlot
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberFloatLinearAxisModel
import io.github.koalaplot.core.xygraph.rememberIntLinearAxisModel
import kotlin.random.Random

@OptIn(ExperimentalKoalaPlotApi::class)
@Composable
fun HorizontallyScrollableChartScreen(
    onBack: () -> Unit
) {
    val data = generateChartData()
    val xValues = data.map { it.dayOfMonth }
    val yValues = data.map { it.happiness }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Demo: Horizontally Scrollable Chart") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) {
        ChartLayout(
            modifier = Modifier.padding(16.dp),
        ) {
            XYGraph(
                xAxisModel = rememberIntLinearAxisModel(1..30, allowPanning = true).apply { setViewRange(1..15) },
                yAxisModel = rememberFloatLinearAxisModel(0f..5f),
                yAxisLabels = {value ->
                    when (value) {
                        1.0f -> "Crying"
                        2.0f -> "Sad"
                        3.0f -> "OK"
                        4.0f -> "Good"
                        5.0f -> "Happy"
                        else -> ""
                    }
                },
                panEnabled = true
            ) {
                VerticalBarPlot(
                    xData = xValues,
                    yData = yValues,
                    barWidth = 0.6f,
                    bar = {
                        DefaultVerticalBar(color = Color.Green)
                    }
                )
            }
        }
    }
}

data class DemoDailyMood(
    val dayOfMonth: Int,
    val happiness: Float
)

private fun generateChartData() = (1..30).map { day ->
    DemoDailyMood(day, Random.nextFloat() * (5f - 1f) + 1f)
}
