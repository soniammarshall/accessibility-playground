package com.accessibilityplayground.ui.keyboardaccess

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.accessibilityplayground.ui.components.CollapsibleSection
import com.accessibilityplayground.ui.components.Dialog
import com.accessibilityplayground.ui.theme.AccessibilityPlaygroundTheme
import com.accessibilityplayground.ui.theme.Typography

@Composable
fun KeyboardAccessScreen() {
    val scrollState = rememberScrollState()
    val dialogState = remember { mutableStateOf(DialogState()) }
    if (dialogState.value.show) {
        FavouriteButtonDialog(
            buttonId = dialogState.value.buttonId,
            onDismiss = { dialogState.value = DialogState() },
            onConfirm = { dialogState.value = DialogState() },

        )
    }

    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        CollapsibleSection("About") {
            AboutSection()
        }
        CollapsibleSection("Default") {
            Text(
                text = "By default, a button is shown to be in focus by a slight change in colour:",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
            )
            ButtonGrid { buttonId ->
                dialogState.value = DialogState(true, buttonId)
            }
        }
        CollapsibleSection("Visible Focus - Border") {
            Text(
                text = "Here a border makes it clearer which element is in focus:",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
            )
            FocusBorderButtonGrid { buttonId ->
                dialogState.value = DialogState(true, buttonId)
            }
        }
        CollapsibleSection("Visible Focus - Color Change") {
            Text(
                text = "Here a higher contrast color change makes it clearer which element is in focus:",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
            )
            FocusColorChangeButtonGrid { buttonId ->
                dialogState.value = DialogState(true, buttonId)
            }
        }
        CollapsibleSection("Changed Focus Order") {
            Text(
                text = "Here the focus order is specified to be different from the default:",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
            )
            ButtonGridColumnFirst { buttonId ->
                dialogState.value = DialogState(true, buttonId)
            }
        }
    }
//    LazyColumn(
//        contentPadding = contentPadding,
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        val list = (0..10).map { it.toString() }
//        items(count = list.size) {
//            ButtonRow(
//                index = list[it],
//                onClick = { buttonId -> dialogState.value = DialogState(true, buttonId) }
//            )
//        }
//    }
}

@Composable
fun AboutSection() {
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
    ) {
        Text(
            text = "What is Keyboard Access?",
            style = Typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Users can navigate and interact with their Android device using a physical keyboard, rather than touching the screen. Your app should allow keyboard users to perform all the actions that are possible using touch.",
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "When navigating with a keyboard, all interactable elements should be focusable. Note, this is different to navigating with a screen reader, which should also focus for example on text elements in order to read them out.",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "How to test your app using a keyboard to navigate?",
            style = Typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "With your app running in an emulator in Android Studio you can simply press the tab key to move focus to the next element. Press enter to interact with the currently focused element. You can also navigate the screen using the arrow keys.",
        )
    }
}

@Composable
fun FavouriteButtonDialog(
    buttonId: String?,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    var text = "Select this option as your favourite?"
    buttonId?.let { text = "Select $buttonId as your favourite?" }
    Dialog(
        text = text,
        onDismiss = onDismiss,
        onConfirm = onConfirm,
    )
}

@Composable
fun ButtonRow(index: String, onClick: (String) -> Unit) {
    Row {
        val buttonIdA = "${index}a"
        val buttonIdB = "${index}b"
        Button(
            onClick = { onClick(buttonIdA) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = buttonIdA,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        Button(
            onClick = { onClick(buttonIdB) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = buttonIdB,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

data class DialogState(
    val show: Boolean = false,
    val buttonId: String? = null,
)

@Preview(showBackground = true)
@Composable
fun PreviewKeyboardAccessScreenContent() {
    AccessibilityPlaygroundTheme {
        KeyboardAccessScreen()
    }
}