package com.example.vindecoder
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(30.dp)
    ) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.car_intro),
                contentDescription = "Image",
                modifier = Modifier
                    .fillMaxWidth()

            )
        }

        Box(
            modifier = Modifier
                .padding(0.dp, 20.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = "Decode your vehicles VIN",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier
                .align(Alignment.Center)
                )
        }

        Box(
            modifier = Modifier
                .padding(0.dp, 10.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = ("For free".uppercase()),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 45.sp,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 30.dp)
        ) {
            DecoderButton(onClick = { navController.navigate(Routes.Decoder.route) })
        }

    }
}


@Composable
fun DecoderButton(onClick: () -> Unit) {
    val navController = rememberNavController()


        Button(
            onClick = { navController.navigate(Routes.Decoder.route) },
            contentPadding = PaddingValues(
                start = 30.dp,
                top = 20.dp,
                end = 30.dp,
                bottom = 20.dp,
            ),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color("#FE7833".toColorInt()))

            ) {
            Text(
                "Decode VIN",
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                color = Color.White,
                textAlign = TextAlign.Center
                )
        }
}
