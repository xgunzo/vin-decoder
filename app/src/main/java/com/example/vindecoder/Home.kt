package com.example.vindecoder
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun Homepage(

) {

    Scaffold(

    ) {innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                ) {
            Text(text = "Test")
        }
    }
}
