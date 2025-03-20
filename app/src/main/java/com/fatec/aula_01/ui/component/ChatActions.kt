package com.fatec.aula_01.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ChatActions (
    onClickInfo: () -> Unit,
    iconInfo: ImageVector,
    modifierInfo: Modifier,
    onClickForm: () -> Unit,
    iconForm: ImageVector,
    modifierForm: Modifier
) {
    ChatIconButton(
        onClick = onClickInfo,
        icon = iconInfo,
        modifier = modifierInfo
    )

    ChatIconButton(
        onClick = onClickForm,
        icon = iconForm,
        modifier = modifierForm
    )
}