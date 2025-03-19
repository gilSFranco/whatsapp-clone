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
import androidx.compose.ui.unit.dp
import com.fatec.aula_01.ui.theme.BRANCO
import com.fatec.aula_01.ui.theme.PRETO
import com.fatec.aula_01.ui.theme.VERDE_ESCURO

@Composable
fun InfoForm (

) {
    var name by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var telefone by remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier
            .padding(20.dp)
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
                    text = "Nome"
                )
            },
            placeholder = {
                Text(
                    text = "Digite seu nome"
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
                    text = "Email"
                )
            },
            placeholder = {
                Text(
                    text = "Digite seu email"
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
            value = telefone,
            onValueChange = {
                telefone = it
            },
            label = {
                Text(
                    text = "Telefone"
                )
            },
            placeholder = {
                Text(
                    text = "Digite seu telefone"
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
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = BRANCO,
                containerColor = VERDE_ESCURO
            )
        ) {
            Text(
                text = "Cadastrar"
            )
        }
    }
}