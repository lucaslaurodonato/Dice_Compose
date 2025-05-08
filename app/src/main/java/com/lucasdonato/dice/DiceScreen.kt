package com.lucasdonato.dice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun Dice() {
    var randomNumber by remember {
        mutableIntStateOf(1)
    }
    var timer by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(key1 = timer) {
        if (timer > 0) {
            delay((500 * (1.0f / timer)).toLong())
            randomNumber = Random.nextInt(1..6)
            timer -= 1
        }
    }

    Box(
        modifier = Modifier
            .background(Color.Black)
    ) {
        Dice(randomNumber, modifier = Modifier.align(Alignment.Center))
        Button(
            onClick = {
                timer = 60
            },
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (100).dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            if (timer > 0) Text("$timer")
            else Text(stringResource(R.string.play))
        }
    }
}

@Preview
@Composable
fun PreviewApp() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Dice()
    }
}