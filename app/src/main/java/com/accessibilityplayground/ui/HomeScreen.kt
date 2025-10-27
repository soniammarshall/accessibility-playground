package com.accessibilityplayground.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.accessibilityplayground.R.string as stringRes


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize(),
    ) {
        Text(text = stringResource(stringRes.home_welcome_text))
    }
}