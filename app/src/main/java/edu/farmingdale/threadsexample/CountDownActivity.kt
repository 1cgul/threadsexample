package edu.farmingdale.threadsexample

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import android.media.MediaPlayer
import android.net.Uri
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext

@Composable
fun CountDownActivity() {
    //context for accessing system services
    val context = LocalContext.current

    //mediaPlayer for sound playback
    val mediaPlayer = remember {
        MediaPlayer.create(context, Uri.parse("android.resource://edu.farmingdale.threadsexample/raw/timer"))
    }

    //initialize the timer starting from 15
    var timer by remember { mutableStateOf(15) }

    // use LaunchedEffect to handle the countdown
    LaunchedEffect(key1 = timer) {
        while (timer > 0) {
            delay(1000) // wait 1 second before next count
            timer-- // decrement
        }

        //play sound when timer reaches 0
        if (timer == 0) {
            mediaPlayer?.start()
        }
    }

    // displays the timer in the center of the screen
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = timer.toString(),
                fontSize = 120.sp,
                fontWeight = if (timer <= 10) FontWeight.Bold else FontWeight.Normal,
                color = if (timer <= 10) Color.Red else Color.Black
            )
        }

        Button(
            onClick = {
                timer = 15
            }
        ) {
            Text("Reset Timer")
        }

        Spacer(modifier = Modifier.height(32.dp))
    }

    //dispose of MediaPlayer when the composable is disposed
    DisposableEffect(context) {
        onDispose {
            mediaPlayer?.release()
        }
    }
}