package com.fatec.aula_01.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fatec.aula_01.model.UserData
import com.fatec.aula_01.ui.theme.BRANCO
import com.fatec.aula_01.ui.theme.Typography
import com.fatec.aula_01.ui.theme.VERDE_ESCURO

@Composable
fun InfoCard(
    onDismiss: () -> Unit,
    paddingTop: Dp,
    paddingBottom: Dp,
    userData: UserData
) {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = paddingTop, start = 20.dp, end = 20.dp, bottom = paddingBottom + 20.dp),
            colors = CardDefaults.cardColors(
                containerColor = BRANCO
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Filled.AccountCircle,
                        contentDescription = "",
                        modifier = Modifier
                            .size(80.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = userData.name.ifEmpty { "Informações do Usuário" },
                        style = Typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    if (userData.email.isNotEmpty() && userData.phoneNumber.isNotEmpty()) {
                        Text(
                            userData.email,
                            style = Typography.bodyMedium
                        )

                        Text(
                            userData.phoneNumber,
                            style = Typography.bodyMedium
                        )
                    } else {
                        Text(
                            "Ainda não há um \nusuário cadastrado.",
                            style = Typography.bodyMedium,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1F))

                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = VERDE_ESCURO,
                        contentColor = BRANCO
                    )
                ) {
                    Text(
                        text = "Fechar",
                        style = Typography.bodySmall
                    )
                }
            }
        }
    }
}