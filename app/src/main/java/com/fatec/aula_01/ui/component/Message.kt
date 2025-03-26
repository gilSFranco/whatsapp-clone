package com.fatec.aula_01.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fatec.aula_01.ui.theme.BRANCO
import com.fatec.aula_01.ui.theme.PRETO
import com.fatec.aula_01.ui.theme.Typography
import com.fatec.aula_01.ui.theme.VERDE_ESCURO

@Composable
fun Message(
    user: Int,
    text: String
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    var showMore by remember {
        mutableStateOf(false)
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .widthIn(
                max = screenWidth - 100.dp
            )
            .padding(8.dp)
            .clip(
                shape =
                if (user == 1)
                    RoundedCornerShape(16.dp, 0.dp, 0.dp, 16.dp)
                else
                    RoundedCornerShape(0.dp, 16.dp, 16.dp, 0.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = if (user == 1) VERDE_ESCURO else PRETO,
            contentColor = BRANCO
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 3.dp
        )
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 14.dp),
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            maxLines = if (expanded) Int.MAX_VALUE else 6,
            overflow = TextOverflow.Ellipsis,
            onTextLayout = {
                if (it.hasVisualOverflow) {
                    showMore = true
                }
            }
        )

        if (showMore) {
            Row(
                Modifier
                    .padding(
                        end = 10.dp, bottom = 5.dp
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        expanded = !expanded
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (user == 1) VERDE_ESCURO else PRETO
                    ),
                    contentPadding = PaddingValues(horizontal = 10.dp),
                    shape = CircleShape
                ) {
                    Text(
                        text = if (expanded) "Ler menos" else "Ler mais",
                        style = Typography.bodySmall,
                        color = BRANCO
                    )
                }
            }

        }
    }
}