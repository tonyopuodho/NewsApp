package com.example.newsapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsapp.R

@Composable
fun ImageHolder(
    imageUrl: String?,
    modifier: Modifier = Modifier
){
    /*
    AsyncImage is a coil method used to load data from online to the device
    * */
    AsyncImage(
        model = ImageRequest
            .Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = "Image description",
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth().height(150.dp),
        placeholder = painterResource(R.drawable.ic_launcher_foreground),
        error = painterResource(R.drawable.ic_launcher_foreground)
    )
}