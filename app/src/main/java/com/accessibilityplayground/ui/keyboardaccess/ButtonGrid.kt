package com.accessibilityplayground.ui.keyboardaccess

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.accessibilityplayground.ui.components.FocusBorderButton
import com.accessibilityplayground.ui.components.FocusColorChangeButton
import com.accessibilityplayground.ui.theme.AccessibilityPlaygroundTheme
import com.accessibilityplayground.R.string as stringRes

@Composable
fun ButtonGrid(onClick: (String) -> Unit) {
    val first = stringResource(stringRes.first)
    val second = stringResource(stringRes.second)
    val third = stringResource(stringRes.third)
    val fourth = stringResource(stringRes.fourth)
    val fifth = stringResource(stringRes.fifth)
    val sixth = stringResource(stringRes.sixth)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            Button(
                onClick = { onClick(first) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(first) }
            Button(
                onClick = { onClick(second) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(second) }
        }
        Row {
            Button(
                onClick = { onClick(third) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(third) }
            Button(
                onClick = { onClick(fourth) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(fourth) }
        }
        Row {
            Button(
                onClick = { onClick(fifth) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(fifth) }
            Button(
                onClick = { onClick(sixth) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(sixth) }
        }
    }
}

@Composable
fun FocusBorderButtonGrid(onClick: (String) -> Unit) {
    val first = stringResource(stringRes.first)
    val second = stringResource(stringRes.second)
    val third = stringResource(stringRes.third)
    val fourth = stringResource(stringRes.fourth)
    val fifth = stringResource(stringRes.fifth)
    val sixth = stringResource(stringRes.sixth)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            FocusBorderButton(
                onClick = { onClick(first) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(first) }
            FocusBorderButton(
                onClick = { onClick(second) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(second) }
        }
        Row {
            FocusBorderButton(
                onClick = { onClick(third) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(third) }
            FocusBorderButton(
                onClick = { onClick(fourth) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(fourth) }
        }
        Row {
            FocusBorderButton(
                onClick = { onClick(fifth) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(fifth) }
            FocusBorderButton(
                onClick = { onClick(sixth) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(sixth) }
        }
    }
}

@Composable
fun FocusColorChangeButtonGrid(onClick: (String) -> Unit) {
    val first = stringResource(stringRes.first)
    val second = stringResource(stringRes.second)
    val third = stringResource(stringRes.third)
    val fourth = stringResource(stringRes.fourth)
    val fifth = stringResource(stringRes.fifth)
    val sixth = stringResource(stringRes.sixth)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            FocusColorChangeButton(
                onClick = { onClick(first) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(first) }
            FocusColorChangeButton(
                onClick = { onClick(second) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(second) }
        }
        Row {
            FocusColorChangeButton(
                onClick = { onClick(third) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(third) }
            FocusColorChangeButton(
                onClick = { onClick(fourth) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(fourth) }
        }
        Row {
            FocusColorChangeButton(
                onClick = { onClick(fifth) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(fifth) }
            FocusColorChangeButton(
                onClick = { onClick(sixth) },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) { Text(sixth) }
        }
    }
}

// TODO look into focusGroup modifier
@Composable
fun ButtonGridColumnFirst(onClick: (String) -> Unit) {
    val first = stringResource(stringRes.first)
    val second = stringResource(stringRes.second)
    val third = stringResource(stringRes.third)
    val fourth = stringResource(stringRes.fourth)
    val fifth = stringResource(stringRes.fifth)
    val sixth = stringResource(stringRes.sixth)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val (firstFocus, secondFocus, thirdFocus, fourthFocus, fifthFocus, sixthFocus) = remember {
            FocusRequester.createRefs()
        }
        Row {
            FocusBorderButton(
                onClick = { onClick(first) },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .focusRequester(firstFocus)
                    .focusProperties { next = secondFocus }
            ) { Text(first) }
            FocusBorderButton(
                onClick = { onClick(fourth) },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .focusRequester(fourthFocus)
                    .focusProperties { next = fifthFocus }
            ) { Text(fourth) }
        }
        Row {
            FocusBorderButton(
                onClick = { onClick(second) },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .focusRequester(secondFocus)
                    .focusProperties { next = thirdFocus }
            ) { Text(second) }
            FocusBorderButton(
                onClick = { onClick(fifth) },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .focusRequester(fifthFocus)
                    .focusProperties { next = sixthFocus }
            ) { Text(fifth) }
        }
        Row {
            FocusBorderButton(
                onClick = { onClick(third) },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .focusRequester(thirdFocus)
                    .focusProperties { next = fourthFocus }
            ) { Text(third) }
            FocusBorderButton(
                onClick = { onClick(sixth) },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .focusRequester(sixthFocus)
            ) { Text(sixth) }
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