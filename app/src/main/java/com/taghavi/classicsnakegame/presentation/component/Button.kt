package com.taghavi.classicsnakegame.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.taghavi.classicsnakegame.ui.theme.corner4dp
import com.taghavi.classicsnakegame.ui.theme.size64dp

@Composable
fun AppButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.onBackground,
            contentColor = MaterialTheme.colors.onPrimary
        )
    ) {
        Text(text = text)
    }
}

@Composable
fun AppIconButton(modifier: Modifier = Modifier, icon: ImageVector, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(size64dp)
            .background(
                color = MaterialTheme.colors.onBackground,
                shape = RoundedCornerShape(corner4dp)
            ),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colors.onPrimary,
        )
    }
}