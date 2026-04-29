package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.data.Event
import com.moviles.examenmoviles.data.mockEvents
import com.moviles.examenmoviles.ui.components.AppBottomBar
import com.moviles.examenmoviles.ui.components.EventCard
import com.moviles.examenmoviles.ui.theme.AppSecondaryText



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsScreen(
    events: List<Event> = mockEvents,
    onEventSelected: (Event) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier       = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text  = "Discover Events",
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        bottomBar = {
            AppBottomBar(currentRoute = "home")
        }
    ) { innerPadding ->

        if (events.isEmpty()) {
            // ── Empty state ──────────────────────────────────────────────────
            Box(
                modifier          = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment  = Alignment.Center
            ) {
                Text(
                    text  = "No events available right now",
                    color = AppSecondaryText,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        } else {
            // ── Event list ───────────────────────────────────────────────────
            LazyColumn(
                modifier       = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentPadding = PaddingValues(
                    start  = 16.dp,
                    end    = 16.dp,
                    top    = 12.dp,
                    bottom = 96.dp        // space above bottom bar
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(events) { event ->
                    EventCard(
                        event   = event,
                        onClick = { onEventSelected(event) }
                    )
                }
            }
        }
    }
}
