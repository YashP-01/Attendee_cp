@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.attendee_cp.screens

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AttendQuiz(navController: NavController){

    var selectedOption by remember { mutableStateOf(0) }

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
                                imageVector = Icons.Default.Close,
                                contentDescription = "close"
                            )
                        }
                    })
            }) {

        }
        Spacer(modifier = Modifier.height(15.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Text(
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

        Spacer(modifier = Modifier.height(10.dp))

        LinearProgressIndicator(modifier = Modifier
            .fillMaxWidth()
            .height(9.dp),
            progress = timeProgress)

        Spacer(modifier = Modifier.height(10.dp))
        
        Text(
            modifier = Modifier.padding(5.dp),
            text = "Arrange three elements horizontally in a row using Jetpack Compose: a button labeled \"Accept\" aligned to the left edge, an image icon centered in the middle.",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Justify)

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(11.dp)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            )

        ) {
            Row(modifier = Modifier.fillMaxSize(),
                Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Row (Arrangement.SpaceBetween)",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Justify)
                RadioButton(selected = selectedOption == 0,
                            onClick = { selectedOption == 0 })
            }

        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(11.dp)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            )

        ) {
            Row(modifier = Modifier.fillMaxSize(),
                Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Row (Arrangement.SpaceBetween)",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Justify)
                RadioButton(selected = selectedOption == 0,
                    onClick = { selectedOption == 1 })
            }

        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(11.dp)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            )

        ) {
            Row(modifier = Modifier.fillMaxSize(),
                Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Row (Arrangement.SpaceBetween)",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Justify)
                RadioButton(selected = selectedOption == 0,
                    onClick = { selectedOption == 2 })
            }

        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(11.dp)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            )

        ) {
            Row(modifier = Modifier.fillMaxSize(),
                Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Row (Arrangement.SpaceBetween)",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Justify)
                RadioButton(selected = selectedOption == 0,
                    onClick = { selectedOption == 3 })
            }

        }

        Spacer(modifier = Modifier.height(150.dp))

        Row(modifier = Modifier.fillMaxSize().padding(17.dp),
            horizontalArrangement = Arrangement.Center) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                onClick = { /*TODO*/ }) {
                Text(text = "Continue",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}