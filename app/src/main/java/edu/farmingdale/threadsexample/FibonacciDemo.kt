package edu.farmingdale.threadsexample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

@Composable
fun FibonacciDemoNoBgThrd() {
    var answer by remember { mutableStateOf("") }
    var textInput by remember { mutableStateOf("40") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 32.dp)
    ) {
        Row {
            TextField(
                value = textInput,
                onValueChange = { textInput = it },
                label = { Text("Number?") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            Button(onClick = {
                val num = textInput.toLongOrNull() ?: 0
                val fibNumber = fibonacci(num)
                answer = NumberFormat.getNumberInstance(Locale.US).format(fibNumber)
            }) {
                Text("Fibonacci")
            }
        }

        Text("Result: $answer")
    }
}

fun fibonacci(n: Long): Long {
    return if (n <= 1) n else fibonacci(n - 1) + fibonacci(n - 2)
}


// ToDo 2: Create a composable function called `FibonacciDemoWithCoroutine` that calculates the
//  Fibonacci number of a given number using a coroutine.
// ToDo 3: Start the application using the CountDownActivity
// ToDo 4: Make the Text of the timer larger
// ToDo 5: Show a visual indicator of the timer going down to 0
// ToDo 6: Add a button to rest the timer
// ToDo 7: Play a sound when the timer reaches 0
// ToDo 8: During the last 10 seconds, make the text red and bold

