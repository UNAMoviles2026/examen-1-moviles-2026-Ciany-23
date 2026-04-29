package com.moviles.examenmoviles.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.ui.theme.AppAccent
import com.moviles.examenmoviles.ui.theme.AppSurface

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick  = onClick,
        enabled  = enabled,
        modifier = modifier.height(52.dp),
        shape    = RoundedCornerShape(16.dp),
        colors   = ButtonDefaults.buttonColors(
            containerColor         = AppAccent,
            contentColor           = AppSurface,
            disabledContainerColor = AppAccent.copy(alpha = 0.4f),
            disabledContentColor   = AppSurface.copy(alpha = 0.6f)
        )
    ) {
        Text(text = text)
    }
}