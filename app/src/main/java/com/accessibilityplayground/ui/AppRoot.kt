package com.accessibilityplayground.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.accessibilityplayground.ui.navigation.AppNavHost
import com.accessibilityplayground.ui.navigation.ColorContrast
import com.accessibilityplayground.ui.navigation.Home
import com.accessibilityplayground.ui.navigation.KeyboardAccess
import com.accessibilityplayground.ui.components.TopBar
import com.accessibilityplayground.ui.components.focusBorder
import com.accessibilityplayground.ui.theme.AccessibilityPlaygroundTheme
import kotlinx.coroutines.launch

@Composable
fun AppRoot() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = listOf(Home, KeyboardAccess, ColorContrast)
    val selectedItem = remember { mutableStateOf(items[0]) }
    // TODO fix keyboard focus for sidebar
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerState) {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    Spacer(Modifier.height(12.dp))
                    items.forEach { item ->
                        NavigationDrawerItem(
                            icon = null,
                            label = { Text(item.sideNavLabel) },
                            selected = item == selectedItem.value,
                            onClick = {
                                scope.launch { drawerState.close() }
                                selectedItem.value = item
                                navController.navigate(route = item.route)
                            },
                            modifier = Modifier
                                .padding(NavigationDrawerItemDefaults.ItemPadding)
                                .focusBorder(),
                        )
                    }
                }
            }
        },
        content = {
            Scaffold(
                topBar = { TopBar(selectedItem.value.title) { scope.launch { drawerState.open() } } }
            ) { innerPadding ->
                AppNavHost(
                    navController = navController,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewAppRoot() {
    AccessibilityPlaygroundTheme {
        AppRoot()
    }
}