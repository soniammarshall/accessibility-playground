package com.accessibilityplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.accessibilityplayground.ui.AppRoot
import com.accessibilityplayground.ui.theme.AccessibilityPlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AccessibilityPlaygroundTheme {
                AppRoot()
            }
        }
    }
}