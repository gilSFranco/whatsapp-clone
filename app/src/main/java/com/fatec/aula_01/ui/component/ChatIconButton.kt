package com.fatec.aula_01.ui.component

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ChatIconButton (
    onClick: () -> Unit,
    icon: ImageVector,
    modifier: Modifier
) {
    IconButton(
        onClick = onClick
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            modifier = modifier
        )
    }
}