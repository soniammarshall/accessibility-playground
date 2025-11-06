package com.accessibilityplayground.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.accessibilityplayground.ui.components.TopBar
import com.accessibilityplayground.ui.components.focusBorder
import com.accessibilityplayground.ui.navigation.AppNavHost
import com.accessibilityplayground.ui.navigation.Home
import com.accessibilityplayground.ui.navigation.NavigationDestination
import com.accessibilityplayground.ui.navigation.navigationDestinations
import com.accessibilityplayground.ui.theme.AccessibilityPlaygroundTheme
import kotlinx.coroutines.launch

@Composable
fun AppRoot() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = navigationDestinations
    val selectedItem = remember { mutableStateOf(items[0]) }
    val firstNavItem = remember {  FocusRequester() }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            SideMenuContent(
                drawerState = drawerState,
                items = items,
                selectedItem = selectedItem.value,
                firstItem = firstNavItem,
                onClick = { item ->
                    scope.launch { drawerState.close() }
                    selectedItem.value = item
                    navController.navigate(route = item.route)
                },
            )
        },
        content = {
            val currentBackStack by navController.currentBackStackEntryAsState()
            val currentDestination = currentBackStack?.destination
            val currentScreen = navigationDestinations
                .find { it.route == currentDestination?.route } ?: Home
            Scaffold(
                topBar = {
                    TopBar(
                        title = stringResource(currentScreen.title),
                        onMenuClick = {
                            // open the side menu and move focus to the first menu item
                            scope.launch {
                                drawerState.open()
                                firstNavItem.requestFocus()
                            }
                        },
                    )
                }
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

@Composable
fun SideMenuContent(
    drawerState: DrawerState,
    items: List<NavigationDestination>,
    selectedItem: NavigationDestination,
    firstItem: FocusRequester,
    onClick: (NavigationDestination) -> Unit,
) {
    ModalDrawerSheet(drawerState) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            Spacer(Modifier.height(12.dp))
            items.forEachIndexed { index,  item ->
                NavigationDrawerItem(
                    icon = null,
                    label = {
                        Text(
                            text = stringResource(item.sideNavLabel),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    selected = item == selectedItem,
                    onClick = { onClick(item) },
                    modifier = Modifier
                        .padding(NavigationDrawerItemDefaults.ItemPadding)
                        .focusBorder()
                        .focusProperties {
                            // only focus the menu items when the side menu is open, to prevent
                            // focus from moving to hidden menu items when the side menu is closed
                            canFocus = drawerState.isOpen
                            // after the last menu item move focus back to the first item, to prevent
                            // focus going to the elements on the screen underneath the side menu
                            if (index == items.size - 1) next = firstItem
                        }
                        .then(if (index == 0) Modifier.focusRequester(firstItem) else Modifier)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppRoot() {
    AccessibilityPlaygroundTheme {
        AppRoot()
    }
}