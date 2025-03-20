package com.fatec.aula_01.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fatec.aula_01.model.ChatMessage

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

        Message(
            user = message.user,
            text = message.text
        )
    }
}