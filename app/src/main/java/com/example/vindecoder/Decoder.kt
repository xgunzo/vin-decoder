package com.example.vindecoder

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.compose.rememberNavController
import com.example.vindecoder.ui.theme.VINDECODERTheme
@Composable
fun DecoderScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(30.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(
                text = "DECODER",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        Text(
            text = "Enter your VIN below",
            color = Color.White,
            modifier = Modifier
                .padding(0.dp, 20.dp)
        )
        var text by remember { mutableStateOf("") }
        OutlinedTextField(value = text, onValueChange = { newText ->
            text = newText
        },
            label = { Text(text = "VIN")},
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color("#FE7833".toColorInt()),
                focusedLabelColor = Color("#FE7833".toColorInt()),
                unfocusedBorderColor = Color("#FE7833".toColorInt()),
                unfocusedLabelColor = Color("#FE7833".toColorInt()),
                cursorColor = Color("#FE7833".toColorInt()),
                textColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}