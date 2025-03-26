package com.fatec.aula_01.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.fatec.aula_01.ui.theme.BRANCO
import com.fatec.aula_01.ui.theme.VERDE_ESCURO
import kotlinx.coroutines.launch

@Composable
fun ScrollToTopButton (
    state: LazyListState
) {
    val scope = rememberCoroutineScope()
    val showScrollToTopButton by remember {
        derivedStateOf {
            state.firstVisibleItemIndex >= 10
        }
    }

    if (showScrollToTopButton) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            FloatingActionButton(
                modifier = Modifier
                    .padding(8.dp)
                    .size(45.dp),
                onClick = {
                    scope.launch {
                        state.animateScrollToItem(0)
                    }
                },
                containerColor = VERDE_ESCURO,
                contentColor = BRANCO
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Go to top",
                    modifier = Modifier
                        .rotate(90f)
                )
            }
        }
    }
}