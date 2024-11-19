package edu.farmingdale.threadsexample

import androidx.compose.runtime.Composable
import edu.farmingdale.threadsexample.countdowntimer.CountDownActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun CountDownActivity() {
    //initialize the timer starting from 10
    var timer by remember { mutableStateOf(10) }

    //use LaunchedEffect to handle the countdown
    LaunchedEffect(key1 = timer) {
        while (timer > 0) {
            delay(1000) // wait 1 second before next count
            timer-- // decrement
        }
    }

    //displays the timer in the center of the screen
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = timer.toString(),
            fontSize = 120.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}
// ToDo 5: Show a visual indicator of the timer going down to 0
// ToDo 6: Add a button to rest the timer
// ToDo 7: Play a sound when the timer reaches 0
// ToDo 8: During the last 10 seconds, make the text red and bold

