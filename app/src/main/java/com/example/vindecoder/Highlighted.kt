package com.example.vindecoder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HighlightedScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(30.dp)
    ) {
        Text(text = "Highlighted screen")
    }
}