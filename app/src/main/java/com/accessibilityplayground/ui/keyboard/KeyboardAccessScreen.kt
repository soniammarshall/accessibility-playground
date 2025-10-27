package com.accessibilityplayground.ui.keyboard

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.accessibilityplayground.ui.components.TopBar
import com.accessibilityplayground.ui.theme.AccessibilityPlaygroundTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun KeyboardAccessScreen() {
    Scaffold(
        topBar = { TopBar("Keyboard Access") },
        content = { innerPadding ->
            KeyboardAccessScreenContent(contentPadding = innerPadding)
        }
    )
}

@Preview
@Composable
fun PreviewHomeScreen() {
    AccessibilityPlaygroundTheme {
       KeyboardAccessScreen()
    }
}
