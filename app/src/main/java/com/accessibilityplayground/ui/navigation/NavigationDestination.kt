package com.accessibilityplayground.ui.navigation

interface NavigationDestination {
    val route: String
    val title: String
    val sideNavLabel : String
}

object Home : NavigationDestination {
    override val route = "home"
    override val title = "Accessibility Playground"
    override val sideNavLabel = "Home"
}

object KeyboardAccess: NavigationDestination {
    override val route = "keyboard_access"
    override val title = "Keyboard Access"
    override val sideNavLabel = "Keyboard Access"
}

object ColorContrast : NavigationDestination {
    override val route = "color_contrast"
    override val title = "Color Contrast"
    override val sideNavLabel = "Color Contrast"
}