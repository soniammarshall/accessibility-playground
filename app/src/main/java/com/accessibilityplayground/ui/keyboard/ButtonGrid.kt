package com.accessibilityplayground.ui.keyboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.FocusRequesterFactory.component1
import androidx.compose.ui.focus.FocusRequester.Companion.FocusRequesterFactory.component2
import androidx.compose.ui.focus.FocusRequester.Companion.FocusRequesterFactory.component3
import androidx.compose.ui.focus.FocusRequester.Companion.FocusRequesterFactory.component4
import androidx.compose.ui.focus.FocusRequester.Companion.FocusRequesterFactory.component5
import androidx.compose.ui.focus.FocusRequester.Companion.FocusRequesterFactory.component6
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.accessibilityplayground.ui.components.FocusBorderButton
import com.accessibilityplayground.ui.components.FocusColorChangeButton
import com.accessibilityplayground.ui.theme.AccessibilityPlaygroundTheme

@Composable
fun ButtonGrid(onClick: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            Button(
                onClick = { onClick("First") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("First") }
            Button(
                onClick = { onClick("Second") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Second") }
        }
        Row {
            Button(
                onClick = { onClick("Third") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Third") }
            Button(
                onClick = { onClick("Fourth") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Fourth") }
        }
        Row {
            Button(
                onClick = { onClick("Fifth") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Fifth") }
            Button(
                onClick = { onClick("Sixth") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Sixth") }
        }
    }
}

@Composable
fun FocusBorderButtonGrid(onClick: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            FocusBorderButton(
                onClick = { onClick("First") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("First") }
            FocusBorderButton(
                onClick = { onClick("Second") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Second") }
        }
        Row {
            FocusBorderButton(
                onClick = { onClick("Third") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Third") }
            FocusBorderButton(
                onClick = { onClick("Fourth") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Fourth") }
        }
        Row {
            FocusBorderButton(
                onClick = { onClick("Fifth") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Fifth") }
            FocusBorderButton(
                onClick = { onClick("Sixth") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Sixth") }
        }
    }
}

@Composable
fun FocusColorChangeButtonGrid(onClick: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            FocusColorChangeButton(
                onClick = { onClick("First") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("First") }
            FocusColorChangeButton(
                onClick = { onClick("Second") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Second") }
        }
        Row {
            FocusColorChangeButton(
                onClick = { onClick("Third") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Third") }
            FocusColorChangeButton(
                onClick = { onClick("Fourth") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Fourth") }
        }
        Row {
            FocusColorChangeButton(
                onClick = { onClick("Fifth") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Fifth") }
            FocusColorChangeButton(
                onClick = { onClick("Sixth") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text("Sixth") }
        }
    }
}

@Composable
fun ButtonGridColumnFirst(onClick: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val (first, second, third, fourth, fifth, sixth) = remember {
            FocusRequester.createRefs()
        }
        Row {
            FocusBorderButton(
                onClick = { onClick("First") },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .focusRequester(first)
                    .focusProperties { next = second }
            ) { Text("First") }
            FocusBorderButton(
                onClick = { onClick("Fourth") },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .focusRequester(fourth)
                    .focusProperties { next = fifth }
            ) { Text("Fourth") }
        }
        Row {
            FocusBorderButton(
                onClick = { onClick("Second") },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .focusRequester(second)
                    .focusProperties { next = third }
            ) { Text("Second") }
            FocusBorderButton(
                onClick = { onClick("Fifth") },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .focusRequester(fifth)
                    .focusProperties { next = sixth }
            ) { Text("Fifth") }
        }
        Row {
            FocusBorderButton(
                onClick = { onClick("Third") },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .focusRequester(third)
                    .focusProperties { next = fourth }
            ) { Text("Third") }
            FocusBorderButton(
                onClick = { onClick("Sixth") },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .focusRequester(sixth)
            ) { Text("Sixth") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonGrid() {
    AccessibilityPlaygroundTheme {
        ButtonGrid {  }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonGridColumnFirst() {
    AccessibilityPlaygroundTheme {
        ButtonGridColumnFirst {  }
    }
}