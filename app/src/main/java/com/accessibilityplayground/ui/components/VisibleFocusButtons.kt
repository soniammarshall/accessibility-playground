package com.accessibilityplayground.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.accessibilityplayground.ui.theme.AccessibilityPlaygroundTheme
import kotlin.Unit

@Composable
fun Modifier.focusBorder(shape: Shape = RectangleShape): Modifier {
    var isFocused by remember { mutableStateOf(false) }

    return this
        .onFocusChanged { isFocused = it.isFocused }
        .border(
            width = 2.dp,
            color = if (isFocused) MaterialTheme.colorScheme.inversePrimary else Color.Transparent,
            shape = shape,
        )
        .padding(4.dp)
}

@Composable
fun FocusBorderButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier.focusBorder(),
        content = content,
    )
}

@Composable
fun FocusBorderButton2(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    var borderColor by remember { mutableStateOf(Color.Transparent)}
    val focusedColor = MaterialTheme.colorScheme.inversePrimary
    Button(
        onClick = onClick,
        modifier = modifier
            .border(width = 2.dp, color = borderColor)
            .onFocusChanged { borderColor = if (it.isFocused) focusedColor else Color.Transparent },
        content = content,
    )
}

@Composable
fun FocusColorChangeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    val defaultColors = ButtonDefaults.buttonColors()
    var colors by remember { mutableStateOf(defaultColors)}
    // TODO actually set proper color contrast colours here
    val focusedColors = ButtonColors(
        containerColor = MaterialTheme.colorScheme.inversePrimary,
        contentColor = Color.Black,
        disabledContainerColor = MaterialTheme.colorScheme.inversePrimary,
        disabledContentColor = MaterialTheme.colorScheme.inversePrimary,
    )
    Button(
        onClick = onClick,
        colors = colors,
        modifier = modifier
            .onFocusChanged { colors = if (it.isFocused) focusedColors else defaultColors },
        content = content,
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewFocusBorderButtons() {
    AccessibilityPlaygroundTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FocusBorderButton(onClick = {}) { Text("Test Button") }
            FocusBorderButton(onClick = {}) { Text("Test Button") }
            FocusBorderButton(onClick = {}) { Text("Test Button") }
            Text("No. 2:", modifier = Modifier.padding(12.dp))
            FocusBorderButton2(onClick = {}) { Text("Test Button") }
            FocusBorderButton2(onClick = {}) { Text("Test Button") }
            FocusBorderButton2(onClick = {}) { Text("Test Button") }
        }
    }
}