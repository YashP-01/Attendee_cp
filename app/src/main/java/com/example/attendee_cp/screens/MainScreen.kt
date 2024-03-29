package com.example.attendee_cp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.attendee_cp.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    var code by remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(13.dp)),
        ) {
            Scaffold(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                topBar = {
                    TopAppBar(title = {
                        Text(text = "Crowd Connect")
                    },
                        navigationIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "go back"
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")

                            }
                        }
                    )
                }
            ) {
                Text(
                    text = "Item",
                    modifier = Modifier.padding(16.dp)
                )
                }
            Column(
                modifier = Modifier
                    .height(400.dp)
                    .width(400.dp)
                    .padding(15.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.qrcode),
                    contentDescription = "Image",
                    modifier = Modifier.size(300.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Divider(Modifier.height(3.dp))
                Spacer(modifier = Modifier.height(5.dp))
                val sheetState = rememberModalBottomSheetState()
                var isSheetOpen by rememberSaveable {
                    mutableStateOf(false)
                }
                Button(modifier = Modifier
                    .fillMaxWidth(),
                    shape = RectangleShape,
                    elevation = ButtonDefaults.elevatedButtonElevation(7.dp),
                    onClick = {
                        navController.navigate("bottomSheet")
                        isSheetOpen = true
                    }) {
                    Text(
                        text = "Join Session", style = MaterialTheme.typography.bodyMedium
                    )
                }
                if (isSheetOpen) ModalBottomSheet(
                    sheetState = sheetState,
                    onDismissRequest = {
                        isSheetOpen = false
                    },
                ) {

                }
            }

            Spacer(modifier = Modifier.height(50.dp))


            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "• ",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp) // Adjust the spacing between bullet point and text
                )
                Text(text = "Review your quiz status.")
            }
            Row(
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = "• ",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp) // Adjust the spacing between bullet point and text
                )
                Text(text = "Check your assignment submission status.")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "• ",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp) // Adjust the spacing between bullet point and text
                )
                Text(text = "Check your attendance.")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "• ",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp) // Adjust the spacing between bullet point and text
                )
                Text(text = "Review your quiz status.")
            }
        }
    }
}