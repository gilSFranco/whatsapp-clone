package com.fatec.aula_01.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.fatec.aula_01.ui.theme.PRETO
import com.fatec.aula_01.ui.theme.Typography
import com.fatec.aula_01.ui.theme.VERDE_ESCURO
import com.fatec.aula_01.ui.theme.VERMELHO

@Composable
fun ChatTextBox (
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    containsLabel: Boolean = false,
    label: String? = null,
    placeholder: String,
    isError: Boolean = false,
    errorState: String? = null,
    lastOne: Boolean = false,
    keyboardType: KeyboardType
) {
    val focusManager = LocalFocusManager.current

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
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = if (!lastOne) ImeAction.Next else ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                },
                onDone = {
                    focusManager.clearFocus()
                }
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
            isError = isError,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = if (!lastOne) ImeAction.Next else ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                },
                onDone = {
                    focusManager.clearFocus()
                }
            )
        )

        if (errorState != null) {
            Text(
                text = errorState,
                color = VERMELHO,
                style = Typography.displaySmall
            )
        }
    }
}