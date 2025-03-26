package com.fatec.aula_01.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.fatec.aula_01.ui.theme.Typography
import com.fatec.aula_01.ui.theme.VERDE_ESCURO

@Composable
fun ChatTitle (
    userName: String,
    showTitle: Boolean
) {
    val name = userName.split(" ")[0]

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ChatIcon(
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            modifier = Modifier
                .scale(1.2F),
            color = VERDE_ESCURO
        )

        if (showTitle) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ChatIcon(
                    icon = Icons.Filled.AccountCircle,
                    modifier = Modifier
                        .scale(1.2F)
                )

                Text(
                    text = if (userName.isNotEmpty()) name else "Usuário",
                    style = Typography.titleMedium
                )
            }
        }
    }
}