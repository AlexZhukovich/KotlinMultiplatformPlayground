package com.alexzh.kmp.playground.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alexzh.kmp.playground.presentation.features.chart.ScrollableChartScreen
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
                onScrollableChart = { navController.navigate(ScrollableChartScreenRoute) }
            )
        }

        composable<ScrollableChartScreenRoute> {
            ScrollableChartScreen(
                onBack = { navController.navigateUp() }
            )
        }
    }
}