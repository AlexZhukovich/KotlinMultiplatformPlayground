package com.alexzh.kmp.playground.presentation.features.chart

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import io.github.koalaplot.core.ChartLayout
import io.github.koalaplot.core.bar.DefaultVerticalBar
import io.github.koalaplot.core.bar.VerticalBarPlot
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberFloatLinearAxisModel
import io.github.koalaplot.core.xygraph.rememberIntLinearAxisModel
import kotlin.random.Random

@Composable
fun ScrollableChartScreen(
    onBack: () -> Unit
) {
    val data = generateChartData()
    val xValues = data.map { it.dayOfMonth }
    val yValues = data.map { it.happiness }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Demo: Scrollable Chart") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                backgroundColor = Color.White
            )
        }
    ) {
        DailyMoodChart(
            xData = xValues,
            yData = yValues
        )
    }
}

@OptIn(ExperimentalKoalaPlotApi::class)
@Composable
fun DailyMoodChart(
    modifier: Modifier = Modifier,
    xData: List<Int>,
    yData: List<Float>
) {
    ChartLayout(
        modifier = modifier.padding(16.dp)
    ) {
        val xAxisModel = rememberIntLinearAxisModel(
            range = 1..xData.size,
            allowPanning = true
        ).apply { setViewRange(1..15) }
        val yAxisModel = rememberFloatLinearAxisModel(
            range = 0f..5f
        )

        XYGraph(
            xAxisModel = xAxisModel,
            yAxisModel = yAxisModel,
            yAxisLabels = { value ->
                when (value) {
                    1.0f -> "Crying"
                    2.0f -> "Sad"
                    3.0f -> "OK"
                    4.0f -> "Good"
                    5.0f -> "Happy"
                    else -> ""
                }
            },
            horizontalMajorGridLineStyle = null,
            horizontalMinorGridLineStyle = null,
            verticalMajorGridLineStyle = null,
            verticalMinorGridLineStyle = null,
            panEnabled = true
        ) {
            VerticalBarPlot(
                xData = xData,
                yData = yData,
                barWidth = 0.6f,
                bar = {
                    val color = when (yData[it]) {
                        in 0f..1.65f -> Color(0xFFF2554A)
                        in 1.66f..3.3f -> Color(0xFFFFB31A)
                        else -> Color(0xFF8FBF41)
                    }

                    DefaultVerticalBar(
                        brush = SolidColor(color),
                        shape = RoundedCornerShape(100)
                    )
                }
            )
        }
    }
}

data class DemoDailyMood(
    val dayOfMonth: Int,
    val happiness: Float
)

private fun generateChartData(numDays: Int = 30) = (1..numDays).map { day ->
    DemoDailyMood(day, Random.nextFloat() * (5f - 1f) + 1f)
}