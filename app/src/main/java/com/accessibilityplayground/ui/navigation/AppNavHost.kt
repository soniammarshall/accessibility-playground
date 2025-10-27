package com.accessibilityplayground.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.accessibilityplayground.ui.HomeScreen
import com.accessibilityplayground.ui.colorcontrast.ColorContrastScreen
import com.accessibilityplayground.ui.keyboardaccess.KeyboardAccessScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier,
    ) {
        composable(route = KeyboardAccess.route) {
            KeyboardAccessScreen()
        }
        composable(route = Home.route) {
            HomeScreen()
        }
        composable(ColorContrast.route) {
            ColorContrastScreen()
        }
    }

}