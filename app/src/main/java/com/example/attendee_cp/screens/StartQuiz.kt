@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.attendee_cp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StartQuiz(navController: NavController) {
    Surface(modifier = Modifier
        .fillMaxSize(),
        ) {
        Column(modifier = Modifier) {
            Scaffold(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(top = 5.dp),
                topBar = {
                    TopAppBar(title = { /*TODO*/ },
                        navigationIcon = {
                            IconButton(onClick = { navController.navigate("bottomSheet") }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "close"
                                )
                            }
                        })
                }) {

            }
            Text(
                modifier = Modifier.padding(start = 13.dp),
                text = "Join quiz",
                style = MaterialTheme.typography.displayMedium,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                modifier = Modifier.padding(start = 13.dp),
                text = "Title",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(25.dp))

            Row {
                Text(
                    modifier = Modifier.padding(start = 13.dp),
                    text = "Quiz duration:",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = "15 min")
            }

            Text(
                modifier = Modifier.padding(start = 13.dp),
                text = "Date: "+ convertLongToTime(System.currentTimeMillis()))

            Spacer(modifier = Modifier.height(25.dp))

            Row {
            Button(
                modifier = Modifier
                    .padding(start = 13.dp),
                shape = RoundedCornerShape(5.dp),
                onClick = { Color.Blue }
            ) {
                Text(text = "Start Quiz")
            }
                Button(
                    modifier = Modifier.padding(start = 100.dp),
                    shape = RoundedCornerShape(5.dp),
                    onClick = { /*TODO*/ }) {
                    Text(text = "Need Help?")
                }
            }
        }
    }
}
fun convertLongToTime(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("dd/MM/yyyy")
    return format.format(date)
}