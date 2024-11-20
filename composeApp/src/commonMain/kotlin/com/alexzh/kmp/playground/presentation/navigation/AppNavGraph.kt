package com.alexzh.kmp.playground.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alexzh.kmp.playground.presentation.features.chart.HorizontallyScrollableChartScreen
import com.alexzh.kmp.playground.presentation.features.home.HomeScreen

@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeScreenRoute
    ) {
        composable<HomeScreenRoute> {
            HomeScreen(
                onHorizontallyScrollableChart = { navController.navigate(HorizontallyScrollableChartScreenRoute) }
            )
        }

        composable<HorizontallyScrollableChartScreenRoute> {
            HorizontallyScrollableChartScreen(
                onBack = { navController.navigateUp() }
            )
        }
    }
}