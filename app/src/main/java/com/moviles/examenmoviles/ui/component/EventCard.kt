package com.moviles.examenmoviles.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.data.Event
import com.moviles.examenmoviles.data.EventStatus
import com.moviles.examenmoviles.ui.theme.AppBorder
import com.moviles.examenmoviles.ui.theme.AppIconTint
import com.moviles.examenmoviles.ui.theme.AppSecondaryText
@Composable
fun EventCard(
    event: Event,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier  = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape     = RoundedCornerShape(20.dp),
        border    = BorderStroke(1.dp, AppBorder),
        colors    = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            // ── Placeholder image ────────────────────────────────────────────
            EventPlaceholderImage(height = 140.dp)

            Spacer(modifier = Modifier.height(14.dp))

            // ── Title + status chip ──────────────────────────────────────────
            Row(
                modifier            = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment   = Alignment.CenterVertically
            ) {
                Text(
                    text      = event.name,
                    style     = MaterialTheme.typography.titleMedium,
                    modifier  = Modifier.weight(1f)
                )
                EventStatusChip(status = event.availabilityStatus)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // ── Date ─────────────────────────────────────────────────────────
            EventInfoRow(
                icon = {
                    Icon(
                        imageVector        = Icons.Outlined.CalendarToday,
                        contentDescription = null,
                        modifier           = Modifier.size(16.dp),
                        tint               = AppIconTint
                    )
                },
                text = "${event.date}  ·  ${event.time}"
            )

            // ── Location ──────────────────────────────────────────────────────
            EventInfoRow(
                icon = {
                    Icon(
                        imageVector        = Icons.Outlined.LocationOn,
                        contentDescription = null,
                        modifier           = Modifier.size(16.dp),
                        tint               = AppIconTint
                    )
                },
                text = event.location
            )

            Spacer(modifier = Modifier.height(4.dp))

            // ── Price ────────────────────────────────────────────────────────
            Text(
                text  = if (event.entryPrice == null) "Free entry"
                else "$${"%.2f".format(event.entryPrice)}",
                style = MaterialTheme.typography.labelLarge,
                color = AppSecondaryText
            )
        }
    }
}

/**
 * Small icon + text row reused inside EventCard.
 */
@Composable
fun EventInfoRow(
    icon: @Composable () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier          = modifier.padding(bottom = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        icon()
        Text(
            text  = text,
            color = AppSecondaryText,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EventCardPreview() {
    EventCard(
        event = Event(
            id                 = 1,
            name               = "Live Jazz Night",
            imageUrl           = "",
            description        = "A great jazz evening.",
            location           = "Central Park",
            date               = "May 10, 2025",
            time               = "7:00 PM",
            maxCapacity        = 200,
            entryPrice         = 12.50,
            availabilityStatus = EventStatus.AVAILABLE
        ),
        onClick = {}
    )
}