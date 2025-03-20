package com.fatec.aula_01.ui.component

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.fatec.aula_01.ui.theme.PRETO

@Composable
fun ChatIcon (
    icon: ImageVector,
    modifier: Modifier,
    color: Color = PRETO
) {
    Icon(
        imageVector = icon,
        contentDescription = "",
        modifier = modifier,
        tint = color
    )
}