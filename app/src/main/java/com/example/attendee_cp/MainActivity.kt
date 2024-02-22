@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.attendee_cp

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Size
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.attendee_cp.screens.AttendQuiz
import com.example.attendee_cp.screens.BottomSheet
import com.example.attendee_cp.screens.MainScreen
import com.example.attendee_cp.screens.StartQuiz
import com.example.attendee_cp.ui.theme.Attendee_cpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Attendee_cpTheme {


                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    page1()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun page1() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainScreen"){
        composable("mainScreen"){
            MainScreen(navController)
        }
        composable("bottomSheet"){
            BottomSheet(navController)
        }
        composable("startQuiz"){
            StartQuiz(navController)
        }
        composable("attendQuiz"){
            AttendQuiz(navController)
        }
    }






//    var code by remember {
//        mutableStateOf("")
//    }
//    var manualcode by remember {
//        mutableStateOf(false)
//    }
//    val context = LocalContext.current
//    val LifecycleOwner = LocalLifecycleOwner.current
//    val cameraProviderFuture = remember {
//        ProcessCameraProvider.getInstance(context)
//    }
//    var hascamPermission by remember {
//        mutableStateOf(
//            ContextCompat.checkSelfPermission(
//                context, android.Manifest.permission.CAMERA
//            ) == PackageManager.PERMISSION_GRANTED
//        )
//    }
//    val launcher =
//        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission(),
//            onResult = { granted ->
//                hascamPermission = granted
//            })
//    LaunchedEffect(key1 = true) {
//        launcher.launch(android.Manifest.permission.CAMERA)
//    }



//    Surface(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight()
//    ) {
//        Card(
//            modifier = Modifier
//                .width(200.dp)
//                .height(390.dp)
//                .padding(12.dp),
//            shape = RoundedCornerShape(corner = CornerSize(13.dp)),
//        ) {
//
//            // Top Header...
//            Column(
//                modifier = Modifier
////                .padding(top = 10.dp)
//                    .shadow(elevation = 5.dp)
//                    .background(Color.White)
//                    .height(40.dp)
//                    .fillMaxWidth(),
//                verticalArrangement = Arrangement.Center
//            ) {
//                Text(
//                    text = "Crowd Connect", style = MaterialTheme.typography.bodyLarge
//                )
//            }
//
//            Column(
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(400.dp)
//                    .padding(15.dp),
//                verticalArrangement = Arrangement.Top,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//
//                Image(
//                    painter = painterResource(id = R.drawable.qrcode),
//                    contentDescription = "Image",
//                    modifier = Modifier.size(300.dp)
//                )
//
//                Divider(Modifier.height(3.dp))
//
//                val sheetState = rememberModalBottomSheetState()
//                var isSheetOpen by rememberSaveable {
//                    mutableStateOf(false)
//                }
//                Button(modifier = Modifier.fillMaxWidth(), shape = RectangleShape, onClick = {
//                    isSheetOpen = true
//                }) {
//                    Text(
//                        text = "Join Session", style = MaterialTheme.typography.bodyMedium
//                    )
//                }
//
//                if (isSheetOpen) ModalBottomSheet(
//                    sheetState = sheetState,
//                    onDismissRequest = {
//                        isSheetOpen = false
//                    },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .fillMaxHeight()
//                            .width(400.dp)
//                            .padding(15.dp),
//                        verticalArrangement = Arrangement.Top,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//
//                        // camera scanner...
//                        val hasCamPermission = true
//                        if (hasCamPermission) {
//                            AndroidView(
//                                factory = { context ->
//                                    val previewView = PreviewView(context)
//                                    val preview = androidx.camera.core.Preview.Builder().build()
//                                    val selector = CameraSelector.Builder()
//                                        .requireLensFacing(CameraSelector.LENS_FACING_BACK).build()
//                                    preview.setSurfaceProvider(previewView.surfaceProvider)
//                                    val imageAnalysis = ImageAnalysis.Builder().setTargetResolution(
//                                            Size(
//                                                previewView.width,
//                                                previewView.height,
//                                            )
//                                        ).setBackpressureStrategy(STRATEGY_KEEP_ONLY_LATEST).build()
//                                    preview.setSurfaceProvider(previewView.surfaceProvider)
//                                    val ImageAnalysis = ImageAnalysis.Builder()
//                                    imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(context),
//                                        QrCodeAnalyzer { result ->
//                                            code = result
//                                        })
//                                    try {
//                                        cameraProviderFuture.get().bindToLifecycle(
//                                            LifecycleOwner, selector, preview, imageAnalysis
//                                        )
//                                    } catch (e: Exception) {
//                                        e.printStackTrace()
//                                    }
//                                    previewView
//                                }, modifier = Modifier.weight(1f)
//                            )
//                            Text(
//                                text = code,
//                                style = MaterialTheme.typography.bodyMedium,
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier
//                                    .width(50.dp)
//                                    .padding(32.dp)
//                            )
//
//                            if(manualcode){
//                                OutlinedTextField(value = "",
//                                    onValueChange = { text ->
//                                        var title = text
//                                    },
//                                    label = { Text("Enter Code") },
//                                    modifier = Modifier.fillMaxWidth()
//                                )
//                            }
//
//                            Button(modifier = Modifier.width(200.dp),
//                                shape = RectangleShape,
//                                onClick = {
//                                    manualcode = true
//
//                                }) {
//                                Text(
//                                    text = "Enter Code",
//                                    style = MaterialTheme.typography.bodyMedium,
//                                )
//                            }
//
//                        }
//                    }
//                }
//            }
//
//        }
//    }
}