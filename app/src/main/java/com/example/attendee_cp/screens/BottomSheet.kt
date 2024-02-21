package com.example.attendee_cp.screens

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.drawable.Icon
import android.media.Image
import android.util.Size
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberScrollableState
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.attendee_cp.QrCodeAnalyzer
import com.example.attendee_cp.R

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(navController: NavController) {
    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    var isStartQuiz by rememberSaveable {
        mutableStateOf(false)
    }
    var btnText by remember { mutableStateOf("Enter Code") }

//    val items = listOf(
//        BottomNavigationItem(
//                title = "Scan QR Code",
//                selectedIcon = Icons.Filled.Info,
//                unselectedIcon = Icons.Filled.Info,
//                hasNews = false
//        ),
//        BottomNavigationItem(
//            title = "Enter Code",
//            selectedIcon = Icons.Filled.Create,
//            unselectedIcon = Icons.Filled.Create,
//            hasNews = false
//        )
//    )
//    var selectedItemIndex by rememberSaveable {
//        mutableStateOf(0)
//    }

    var code by remember {
        mutableStateOf("")
    }
    var manualcode by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    val LifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember {
        ProcessCameraProvider.getInstance(context)
    }
    var hascamPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context, Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission(),
            onResult = { granted ->
                hascamPermission = granted
            })
    LaunchedEffect(key1 = true) {
        launcher.launch(Manifest.permission.CAMERA)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(300.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(5.dp)),
        ) {


            Column(
                modifier = Modifier
//                    .fillMaxHeight()
                    .height(500.dp)
                    .width(400.dp)
                    .padding(15.dp),

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // camera scanner...
                val hasCamPermission = true
                if (hasCamPermission) {
                    AndroidView(
                        factory = { context ->
                            val previewView = PreviewView(context)
                            val preview = Preview.Builder().build()
                            val selector = CameraSelector.Builder()
                                .requireLensFacing(CameraSelector.LENS_FACING_BACK).build()
                            preview.setSurfaceProvider(previewView.surfaceProvider)
                            val imageAnalysis = ImageAnalysis.Builder().setTargetResolution(
                                Size(
                                    previewView.width,
                                    previewView.height,
                                )
                            ).setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                                .build()
                            preview.setSurfaceProvider(previewView.surfaceProvider)
                            val ImageAnalysis = ImageAnalysis.Builder()
                            imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(context),
                                QrCodeAnalyzer { result ->
                                    code = result
                                })
                            try {
                                cameraProviderFuture.get().bindToLifecycle(
                                    LifecycleOwner, selector, preview, imageAnalysis
                                )
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                            previewView
                        }, modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = code,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .width(50.dp)
                            .padding(32.dp)
                    )
                }
//        Scaffold (
//            bottomBar = {
//                NavigationBar {
//                    items.forEachIndexed{ index, item ->
//                        NavigationBarItem(
//                            selected = selectedItemIndex == index,
//                            onClick = { /*TODO*/ },
//                            icon = { /*TODO*/ })
//                    }
//                }
//            }
//
//        ){}
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(15.dp),

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (manualcode) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = title,
                        onValueChange = { text ->
                            title = text
                        },
                        label = { Text("Enter Code", maxLines = 1) },
                        placeholder = {
                            Text(text = "Type here")
                        }
                    )
                }
                else{
                    manualcode = false
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .width(150.dp)
                        .padding(start = 10.dp),
                        shape = RectangleShape,

                        onClick = {
                            if (btnText == "Submit") navController.navigate("startQuiz")
                            else
                            btnText = "Submit"
                            isStartQuiz = true
                            manualcode = true

                        }) {
                        Text(text = btnText)
                    }
//                    Spacer(modifier = Modifier.width(15.dp))
//                    Button(modifier = Modifier
//                        .width(150.dp)
//                        .padding(start = 15.dp),
//                        shape = RectangleShape,
//                        onClick = {
//                            manualcode = false
//
//                        }) {
//                        Text(
//                            text = "Scan QR",
//                            style = MaterialTheme.typography.bodyMedium,
//                        )
//                    }
                }
            }
        }
    }
}

