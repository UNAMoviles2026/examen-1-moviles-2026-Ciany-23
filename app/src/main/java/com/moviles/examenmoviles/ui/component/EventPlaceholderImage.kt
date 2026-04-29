package com.moviles.examenmoviles.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.ui.theme.AppAccent
import com.moviles.examenmoviles.ui.theme.AppSurfaceVariant

@Composable
fun EventPlaceholderImage(
    height: Dp = 180.dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(16.dp))
            .background(AppSurfaceVariant),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector      = Icons.Outlined.Event,
            contentDescription = null,
            tint             = AppAccent.copy(alpha = 0.5f),
            modifier         = Modifier.height(48.dp)
        )
    }
}
