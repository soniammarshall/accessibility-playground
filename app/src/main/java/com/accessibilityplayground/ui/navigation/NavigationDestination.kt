package com.accessibilityplayground.ui.navigation

import androidx.annotation.StringRes
import com.accessibilityplayground.R.string as stringRes

interface NavigationDestination {
    val route: String
    val title: Int
    val sideNavLabel: Int
}

object Home : NavigationDestination {
    override val route = "home"
    @StringRes override val title = stringRes.app_name
    @StringRes override val sideNavLabel = stringRes.home
}

object KeyboardAccess: NavigationDestination {
    override val route = "keyboard_access"
    @StringRes override val title = stringRes.keyboard_access
    @StringRes override val sideNavLabel = stringRes.keyboard_access
}

object ColorContrast : NavigationDestination {
    override val route = "color_contrast"
    @StringRes override val title = stringRes.color_contrast
    @StringRes override val sideNavLabel = stringRes.color_contrast
}

val navigationDestinations = listOf(
    Home,
    KeyboardAccess,
    ColorContrast,
)