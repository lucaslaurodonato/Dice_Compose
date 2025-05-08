package com.lucasdonato.dice

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp

fun DrawScope.center() {
    circle {
        Offset((size.width / 2f) + (it / 2f), (size.height / 2) + (it / 2f))
    }
}

fun DrawScope.centerLeft() {
    circle {
        Offset(it * 2f, (size.height / 2) + (it / 2f))
    }
}

fun DrawScope.centerRight() {
    circle {
        Offset(size.width - it, (size.height / 2) + (it / 2f))
    }
}

fun DrawScope.topRight() {
    circle {
        Offset(size.width - it, it * 2f)
    }
}

fun DrawScope.topLeft() {
    circle {
        Offset(it * 2f, it * 2f)
    }
}

fun DrawScope.bottomLeft() {
    circle {
        Offset(it * 2f, size.height - it)
    }
}

fun DrawScope.bottomRight() {
    circle {
        Offset(size.width - it, size.height - it)
    }
}

fun DrawScope.circle(offset: (Float) -> Offset) {
    val radius = Dp(20f).value
    drawCircle(
        Color.Black,
        radius = radius,
        center = offset(radius)
    )
}

fun DrawScope.bullet(number: Int) {
    when (number) {
        1 -> {
            center()
        }
        2 -> {
            topRight()
            bottomLeft()
        }
        3 -> {
            center()
            topRight()
            bottomLeft()
        }
        4 -> {
            topLeft()
            topRight()
            bottomLeft()
            bottomRight()
        }
        5 -> {
            center()
            topLeft()
            topRight()
            bottomLeft()
            bottomRight()
        }
        6 -> {
            topLeft()
            topRight()
            bottomLeft()
            bottomRight()
            centerLeft()
            centerRight()
        }
    }
}