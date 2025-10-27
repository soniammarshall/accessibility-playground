package com.accessibilityplayground.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.accessibilityplayground.ui.theme.AccessibilityPlaygroundTheme
import com.accessibilityplayground.ui.theme.Typography
import com.accessibilityplayground.R.drawable as uiResources

@Composable
fun CollapsibleSection(title: String, isInitiallyExpanded: Boolean = false, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        val isExpanded = remember { mutableStateOf(isInitiallyExpanded) }
        SectionHeader(title, isExpanded.value) { isExpanded.value = !isExpanded.value }
        if (isExpanded.value) {
            content()
        }
    }
}

// TODO add state description for screen readers
@Composable
fun SectionHeader(title: String, isExpanded: Boolean, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 8.dp)
            .focusBorder()
            .semantics(
                mergeDescendants = true,
                properties = { role = Button }
            )
            .clickable(onClick = onClick),
    ) {
        val iconId = if (isExpanded) uiResources.keyboard_arrow_up else uiResources.keyboard_arrow_down
        Icon(
            painter = painterResource(iconId),
            contentDescription = null,
            modifier = Modifier.padding(4.dp),
        )
        Text(
            text = title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = Typography.titleLarge,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCollapsibleSection() {
    AccessibilityPlaygroundTheme {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            CollapsibleSection(
                title = "Tap here to collapse/expand",
                content = {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text("Here is the text content!")
                        FocusBorderButton(onClick = {}) { Text("Click meeee") }
                    }
                }
            )
        }
    }
}