package com.moviles.examenmoviles.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.moviles.examenmoviles.data.mockEvents
import com.moviles.examenmoviles.ui.screens.EventsScreen
import com.moviles.examenmoviles.ui.screens.eventdetail.EventDetailScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController   = navController,
        startDestination = AppDestinations.EVENTS,
        modifier        = Modifier.fillMaxSize()
    ) {
        // ── Events list ──────────────────────────────────────────────────────
        composable(route = AppDestinations.EVENTS) {
            EventsScreen(
                events          = mockEvents,
                onEventSelected = { event ->
                    navController.navigate(AppDestinations.eventDetail(event.id))
                }
            )
        }

        // ── Event detail ─────────────────────────────────────────────────────
        composable(
            route     = AppDestinations.EVENT_DETAIL,
            arguments = listOf(navArgument("eventId") { type = NavType.IntType })
        ) { backStackEntry ->
            val eventId = backStackEntry.arguments?.getInt("eventId") ?: return@composable
            val event   = mockEvents.find { it.id == eventId } ?: return@composable

            EventDetailScreen(
                event     = event,
                onBack    = { navController.popBackStack() }
            )
        }
    }
}
