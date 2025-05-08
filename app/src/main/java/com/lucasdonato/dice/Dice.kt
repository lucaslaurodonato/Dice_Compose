package com.lucasdonato.dice

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Dice(number: Int, modifier: Modifier) {
    Canvas(
        modifier = modifier
            .size(96.dp, 96.dp)
    ) {
        drawRoundRect(
            Color.White,
            cornerRadius = CornerRadius(20f, 20f),
            topLeft = Offset(10f, 10f),
            size = size,
        )
        bullet(number)
    }
}

@Preview
@Composable
fun PreviewDice() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Dice(1, Modifier)
    }
}