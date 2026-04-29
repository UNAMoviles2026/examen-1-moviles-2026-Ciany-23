package com.moviles.examenmoviles.ui.component

import androidx.compose.runtime.Composable

@Composable
fun AppBottomBar(currentRoute: String = "home") {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick  = { /* navigation handled by NavHost */ },
            icon     = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label    = { Text("Home") },
            colors   = appNavItemColors()
        )

        NavigationBarItem(
            selected = currentRoute == "calendar",
            onClick  = { },
            icon     = { Icon(Icons.Outlined.CalendarToday, contentDescription = "Calendar") },
            label    = { Text("Calendar") },
            colors   = appNavItemColors()
        )

        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick  = { },
            icon     = { Icon(Icons.Outlined.Person, contentDescription = "Profile") },
            label    = { Text("Profile") },
            colors   = appNavItemColors()
        )
    }
}

@Composable
private fun appNavItemColors() = NavigationBarItemDefaults.colors(
    selectedIconColor   = AppAccent,
    selectedTextColor   = AppAccent,
    unselectedIconColor = AppNavUnselected,
    unselectedTextColor = AppNavUnselected,
    indicatorColor      = AppBackground
)
