package com.fatec.aula_01.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fatec.aula_01.model.ChatMessage
import com.fatec.aula_01.ui.theme.BRANCO
import com.fatec.aula_01.ui.theme.PRETO

@Composable
fun ChatMessageItem (
    message: ChatMessage
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = if (message.user == 1) Arrangement.End else Arrangement.Start
    ) {
        if (message.user == 1) {
            Spacer(modifier = Modifier.weight(1f))
        }

        Card(
            modifier = Modifier
                .padding(8.dp)
                .clip(
                    shape =
                    if (message.user == 1)
                        RoundedCornerShape(16.dp, 16.dp, 16.dp, 16.dp)
                    else
                        RoundedCornerShape(16.dp, 0.dp, 0.dp, 16.dp)
                ),
            colors = CardDefaults.cardColors(
                containerColor = PRETO,
                contentColor = BRANCO
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 3.dp
            )
        ) {
            Text(
                text = message.text,
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 14.dp),
                textAlign = TextAlign.Start,
                fontSize = 16.sp
            )
        }
    }
}