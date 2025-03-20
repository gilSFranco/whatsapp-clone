package com.fatec.aula_01.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fatec.aula_01.ui.theme.PRETO
import com.fatec.aula_01.ui.theme.Typography
import com.fatec.aula_01.ui.theme.VERDE_ESCURO

@Composable
fun ChatTextBox (
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    containsLabel: Boolean = false,
    label: String? = null,
    placeholder: String
) {
    if (!containsLabel) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            placeholder = {
                Text(
                    text = placeholder,
                    style = Typography.bodyMedium
                )
            },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = VERDE_ESCURO,
                unfocusedBorderColor = PRETO,
                cursorColor = VERDE_ESCURO,
                focusedLabelColor = VERDE_ESCURO,
                unfocusedLabelColor = PRETO,
                focusedPlaceholderColor = VERDE_ESCURO,
                focusedTextColor = VERDE_ESCURO
            )
        )
    } else {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            label = {
                Text(
                    text = label ?: "",
                    style = Typography.bodyMedium
                )
            },
            placeholder = {
                Text(
                    text = placeholder,
                    style = Typography.bodyMedium
                )
            },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = VERDE_ESCURO,
                unfocusedBorderColor = PRETO,
                cursorColor = VERDE_ESCURO,
                focusedLabelColor = VERDE_ESCURO,
                unfocusedLabelColor = PRETO,
                focusedPlaceholderColor = VERDE_ESCURO,
                focusedTextColor = VERDE_ESCURO
            ),
            singleLine = true
        )
    }
}