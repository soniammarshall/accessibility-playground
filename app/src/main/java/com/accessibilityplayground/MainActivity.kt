package com.accessibilityplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.accessibilityplayground.ui.keyboard.KeyboardAccessScreen
import com.accessibilityplayground.ui.theme.AccessibilityPlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AccessibilityPlaygroundTheme {
                AccessibilityPlaygroundApp()
            }
        }
    }
}

@Composable
fun AccessibilityPlaygroundApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "keyboard_access",
    ) {
        composable(route = "keyboard_access") {
            KeyboardAccessScreen()
        }
    }
}