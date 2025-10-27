@file:OptIn(ExperimentalMaterial3Api::class)

package com.accessibilityplayground.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import com.accessibilityplayground.ui.theme.Typography
import com.accessibilityplayground.R.drawable as uiResources

@Composable
fun TopBar(title: String) {
    TopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = Typography.headlineSmall,
            )
        },
        navigationIcon = {
            IconButton(
                onClick = { /* doSomething() */ },
                modifier = Modifier.focusBorder(),
            ) {
                Icon(
                    painter = painterResource(uiResources.menu),
                    contentDescription = "Menu"
                )
            }
        },
        actions = { }
    )
}