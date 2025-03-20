package com.fatec.aula_01.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fatec.aula_01.model.UserData
import com.fatec.aula_01.ui.theme.BRANCO

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
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    ChatIcon(
                        icon = Icons.Filled.AccountCircle,
                        modifier = Modifier
                            .size(80.dp)
                    )

                    InfoUserData(
                        name = userData.name,
                        email = userData.email,
                        phoneNumber = userData.phoneNumber
                    )
                }

                Spacer(modifier = Modifier.weight(1F))

                InfoButton(
                    onClick = onDismiss,
                    modifier = Modifier,
                    text = "Fechar"
                )
            }
        }
    }
}