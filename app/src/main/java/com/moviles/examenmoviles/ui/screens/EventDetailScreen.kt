package com.moviles.examenmoviles.ui.screens.eventdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Payments
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.data.Event
import com.moviles.examenmoviles.data.EventStatus
import com.moviles.examenmoviles.data.mockEvents
import com.moviles.examenmoviles.ui.components.AppBottomBar
import com.moviles.examenmoviles.ui.components.AppButton
import com.moviles.examenmoviles.ui.components.EventInfoRow
import com.moviles.examenmoviles.ui.components.EventPlaceholderImage
import com.moviles.examenmoviles.ui.components.EventStatusChip
import com.moviles.examenmoviles.ui.theme.AppAccent
import com.moviles.examenmoviles.ui.theme.AppBackground
import com.moviles.examenmoviles.ui.theme.AppBorder
import com.moviles.examenmoviles.ui.theme.AppIconTint
import com.moviles.examenmoviles.ui.theme.AppSecondaryText
import kotlinx.coroutines.launch

/**
 * Full detail screen for a selected event.
 * Shows all available data and a reserve/register button.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(
    event: Event,
    onBack: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope    = rememberCoroutineScope()
    val isFull            = event.availabilityStatus == EventStatus.FULL

    Scaffold(
        modifier       = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text  = "Event Detail",
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector        = Icons.AutoMirrored.Outlined.ArrowBack,
                            contentDescription = "Back",
                            tint               = AppAccent
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        bottomBar = {
            AppBottomBar(currentRoute = "home")
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                Snackbar(
                    modifier         = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                    snackbarData     = data,
                    containerColor   = AppAccent,
                    contentColor     = AppBackground
                )
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {

            // ── Hero image ───────────────────────────────────────────────────
            EventPlaceholderImage(height = 220.dp)

            Spacer(modifier = Modifier.height(20.dp))

            // ── Title + status ───────────────────────────────────────────────
            Row(
                modifier              = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment     = Alignment.Top
            ) {
                Text(
                    text     = event.name,
                    style    = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )
                EventStatusChip(
                    status   = event.availabilityStatus,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = AppBorder)
            Spacer(modifier = Modifier.height(16.dp))

            // ── Key info rows ────────────────────────────────────────────────
            EventInfoRow(
                icon = {
                    Icon(
                        Icons.Outlined.CalendarToday,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint = AppIconTint
                    )
                },
                text = "${event.date}  ·  ${event.time}"
            )

            EventInfoRow(
                icon = {
                    Icon(
                        Icons.Outlined.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint = AppIconTint
                    )
                },
                text = event.location
            )

            EventInfoRow(
                icon = {
                    Icon(
                        Icons.Outlined.Groups,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint = AppIconTint
                    )
                },
                text = "Capacity: ${event.maxCapacity} people"
            )

            EventInfoRow(
                icon = {
                    Icon(
                        Icons.Outlined.Payments,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint = AppIconTint
                    )
                },
                text = if (event.entryPrice == null) "Free entry"
                else "Entry price: $${"%.2f".format(event.entryPrice)}"
            )

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = AppBorder)
            Spacer(modifier = Modifier.height(16.dp))

            // ── Description ──────────────────────────────────────────────────
            Text(
                text  = "About this event",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text  = event.description,
                style = MaterialTheme.typography.bodyLarge,
                color = AppSecondaryText
            )

            Spacer(modifier = Modifier.height(28.dp))

            // ── Reserve button ───────────────────────────────────────────────
            AppButton(
                text    = if (isFull) "No spots available" else "Reserve a spot",
                enabled = !isFull,
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Your spot has been reserved!")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}