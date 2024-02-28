@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.attendee_cp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    Page1()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Page1() {
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