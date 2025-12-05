package com.example.newsapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RetryScreen(
   error: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        Text(text = error, fontSize = 18.sp, color = Color.Red)
        Spacer(modifier = modifier.height(10.dp))
        Button(onClick = onRetry,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ){
            Text(text = "Retry")
        }
    }
}