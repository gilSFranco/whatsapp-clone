package com.fatec.aula_01.ui.component

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fatec.aula_01.ui.theme.BRANCO
import com.fatec.aula_01.ui.theme.Typography
import com.fatec.aula_01.ui.theme.VERDE_ESCURO

@Composable
fun InfoButton (
    onClick: () -> Unit,
    modifier: Modifier,
    text: String
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = BRANCO,
            containerColor = VERDE_ESCURO
        )
    ) {
        Text(
            text = text,
            style = Typography.bodySmall
        )
    }
}