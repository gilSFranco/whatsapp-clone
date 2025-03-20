package com.fatec.aula_01.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fatec.aula_01.model.UserData
import com.fatec.aula_01.ui.theme.BRANCO
import com.fatec.aula_01.ui.theme.PRETO
import com.fatec.aula_01.ui.theme.Typography
import com.fatec.aula_01.ui.theme.VERDE_ESCURO

@Composable
fun InfoForm(
    paddingTop: Dp,
    paddingBottom: Dp,
    onClick: () -> Unit
) : UserData {
    var name by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var phoneNumber by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(
                top = paddingTop,
                bottom = paddingBottom,
                start = 20.dp,
                end = 20.dp
            )
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            space = 10.dp,
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text(
                    text = "Nome",
                    style = Typography.bodyMedium
                )
            },
            placeholder = {
                Text(
                    text = "Digite seu nome",
                    style = Typography.bodyMedium
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
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

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(
                    text = "Email",
                    style = Typography.bodyMedium
                )
            },
            placeholder = {
                Text(
                    text = "Digite seu email",
                    style = Typography.bodyMedium
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
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

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
            },
            label = {
                Text(
                    text = "Telefone",
                    style = Typography.bodyMedium
                )
            },
            placeholder = {
                Text(
                    text = "Digite seu telefone",
                    style = Typography.bodyMedium
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
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

        Spacer(
            modifier = Modifier
                .weight(1F)
        )

        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = BRANCO,
                containerColor = VERDE_ESCURO
            )
        ) {
            Text(
                text = "Cadastrar",
                style = Typography.bodySmall
            )
        }
    }

    return UserData(
        name = name,
        email = email,
        phoneNumber = phoneNumber
    )
}