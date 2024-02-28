@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.attendee_cp.screens

import android.annotation.SuppressLint
import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlin.math.round

@ExperimentalComposeUiApi
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AttendQuiz(navController: NavController){

    var remainingTime by remember { mutableStateOf(10 * 60L) } // 10 minutes in seconds
    LaunchedEffect(Unit) {
        repeat(remainingTime.toInt()) { // Repeat for the remaining time
            delay(1000) // Update every second
            remainingTime-- // Decrement remaining time
        }
    }
    val minutes = remainingTime / 60
    val seconds = remainingTime % 60

    val options = listOf("Row (Arrange.SpaceBetween)", "Row (Arrangement.Space)", "Row (Arrangement.SpaceBet)", "Row (Arrangement.Between)")
    var selectedOption by remember { mutableStateOf(options[0]) }

    var timeProgress by remember {
        mutableStateOf(0.1f)
    }
    LaunchedEffect(timeProgress){
        while (timeProgress < 1f){
            delay(1000L)
            timeProgress += 0.1f
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Scaffold(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
            topBar = {
                TopAppBar(title = {
                    Text(
                        text = "Quiz",
                        textAlign = TextAlign.Center)
                },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate("startQuiz") }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "close"
                            )
                        }
                    })
            }) {

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.End,
        ) {
            Text(
                text = "TimeOut : $minutes:${"%02d".format(seconds)}", textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = "Question 1/10",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
            Row {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Previous"
                    )

                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Previous"
                    )

                }
            }
        }
        LinearProgressIndicator(modifier = Modifier
            .clip(shape = RoundedCornerShape(9.dp))
            .padding(start = 20.dp, end = 20.dp, top = 10.dp)
            .fillMaxWidth()
            .height(10.dp),
//            shape = RoundedCornerShape(7.dp),
            progress = timeProgress,
        )
        Text(
            modifier = Modifier.padding(21.dp),
            text = "Arrange three elements horizontally in a row using Jetpack Compose: a button labeled \"Accept\" aligned to the left edge, an image icon centered in the middle.",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Justify)



        options.forEach { option ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
                shape = RoundedCornerShape(corner = CornerSize(7.dp)),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(start = 7.dp),
                        text = option,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify
                    )
                    RadioButton(
                        selected = selectedOption == option,
                        onClick = { selectedOption = option})
                }

            }
        }

        Spacer(modifier = Modifier.height(70.dp))

        Row(modifier = Modifier
            .fillMaxSize()
            .padding(17.dp),
            horizontalArrangement = Arrangement.Center) {
            Button(
                modifier = Modifier.fillMaxWidth().height(57.dp),
                shape = RoundedCornerShape(45.dp),
                onClick = { /*TODO*/ }) {
                Text(text = "Continue",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}




