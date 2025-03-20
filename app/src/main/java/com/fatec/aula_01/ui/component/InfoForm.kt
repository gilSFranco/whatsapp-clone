package com.fatec.aula_01.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fatec.aula_01.model.UserData

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
        ChatTextBox(
            containsLabel = true,
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier
                .fillMaxWidth(),
            label = "Nome",
            placeholder = "Digite seu nome"
        )

        ChatTextBox(
            containsLabel = true,
            value = email,
            onValueChange = {
                email = it
            },
            modifier = Modifier
                .fillMaxWidth(),
            label = "Email",
            placeholder = "Digite seu email"
        )

        ChatTextBox(
            containsLabel = true,
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
            },
            modifier = Modifier
                .fillMaxWidth(),
            label = "Telefone",
            placeholder = "Digite seu telefone"
        )

        Spacer(
            modifier = Modifier
                .weight(1F)
        )

        InfoButton(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth(),
            text = "Cadastrar"
        )
    }

    return UserData(
        name = name,
        email = email,
        phoneNumber = phoneNumber
    )
}