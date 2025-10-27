package com.accessibilityplayground.ui.keyboardaccess

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.accessibilityplayground.ui.components.CollapsibleSection
import com.accessibilityplayground.ui.components.Dialog
import com.accessibilityplayground.ui.theme.AccessibilityPlaygroundTheme
import com.accessibilityplayground.ui.theme.Typography
import com.accessibilityplayground.R.string as stringRes

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
        CollapsibleSection(stringResource(stringRes.about_title)) {
            AboutSection()
        }
        CollapsibleSection(stringResource(stringRes.default_title)) {
            Text(
                text = stringResource(stringRes.default_text),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
            )
            ButtonGrid { buttonId ->
                dialogState.value = DialogState(true, buttonId)
            }
        }
        CollapsibleSection(stringResource(stringRes.visible_focus_border_title)) {
            Text(
                text = stringResource(stringRes.visible_focus_border_text),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
            )
            FocusBorderButtonGrid { buttonId ->
                dialogState.value = DialogState(true, buttonId)
            }
        }
        CollapsibleSection(stringResource(stringRes.visible_focus_color_change_title)) {
            Text(
                text = stringResource(stringRes.visible_focus_color_change_text),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
            )
            FocusColorChangeButtonGrid { buttonId ->
                dialogState.value = DialogState(true, buttonId)
            }
        }
        CollapsibleSection(stringResource(stringRes.changed_focus_order_title)) {
            Text(
                text = stringResource(stringRes.changed_focus_order_text),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
            )
            ButtonGridColumnFirst { buttonId ->
                dialogState.value = DialogState(true, buttonId)
            }
        }
    }
}

@Composable
fun AboutSection() {
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
    ) {
        Text(
            text = stringResource(stringRes.about_section_1_title),
            style = Typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(stringRes.about_section_1_para_1),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = stringResource(stringRes.about_section_1_para_2),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text =  stringResource(stringRes.about_section_2_title),
            style = Typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(stringRes.about_section_2_para_1),
        )
    }
}

@Composable
fun FavouriteButtonDialog(
    buttonId: String?,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    var text = stringResource(stringRes.favorite_button_dialog_text)
    buttonId?.let { text =
        stringResource(stringRes.favorite_button_dialog_text_specific, buttonId)
    }
    Dialog(
        text = text,
        onDismiss = onDismiss,
        onConfirm = onConfirm,
    )
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