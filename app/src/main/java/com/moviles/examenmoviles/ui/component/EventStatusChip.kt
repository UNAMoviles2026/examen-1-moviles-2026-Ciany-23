package com.moviles.examenmoviles.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.data.EventStatus
import com.moviles.examenmoviles.ui.theme.StatusAlmostFull
import com.moviles.examenmoviles.ui.theme.StatusAvailable
import com.moviles.examenmoviles.ui.theme.StatusFull
import com.moviles.examenmoviles.ui.theme.StatusOnColor

@Composable
fun EventStatusChip(status: EventStatus, modifier: Modifier = Modifier) {
    val (backgroundColor, label) = when (status) {
        EventStatus.AVAILABLE   -> Pair(StatusAvailable,  "Available")
        EventStatus.ALMOST_FULL -> Pair(StatusAlmostFull, "Almost Full")
        EventStatus.FULL        -> Pair(StatusFull,        "Full")
    }

    Text(
        text     = label,
        color    = StatusOnColor,
        style    = MaterialTheme.typography.labelMedium,
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .background(backgroundColor)
            .padding(horizontal = 10.dp, vertical = 4.dp)
    )
}