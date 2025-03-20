package com.fatec.aula_01.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fatec.aula_01.ui.theme.Typography

@Composable
fun InfoUserData(
    name: String,
    email: String,
    phoneNumber: String
) {
    Text(
        text = name.ifEmpty { "Informações do Usuário" },
        style = Typography.titleLarge
    )

    Spacer(modifier = Modifier.height(10.dp))

    if (email.isNotEmpty() && phoneNumber.isNotEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Data(
                icon = Icons.Filled.Email,
                data = email
            )

            Data(
                icon = Icons.Filled.Call,
                data = phoneNumber
            )
        }

    } else {
        Text(
            "Ainda não há um \nusuário cadastrado.",
            style = Typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}