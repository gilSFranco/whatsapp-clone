package com.fatec.aula_01.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fatec.aula_01.ui.theme.BRANCO
import com.fatec.aula_01.ui.theme.VERDE_ESCURO

@Composable
fun InfoCard(
    onDismiss: () -> Unit,
    innerPadding: Dp,
    infoName: String,
    infoEmail: String,
    infoTelefone: String,
) {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = innerPadding, start = 20.dp, end = 20.dp),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 4.dp
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 30.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Informação do Usuário",
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    "Nome: $infoName",
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    "Email: $infoEmail",
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    "Telefone: $infoTelefone",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = VERDE_ESCURO,
                        contentColor = BRANCO
                    )
                ) {
                    Text(
                        text = "Fechar"
                    )
                }
            }
        }

        InfoForm()
    }
}