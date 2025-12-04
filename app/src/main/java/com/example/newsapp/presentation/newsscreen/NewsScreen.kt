package com.example.newsapp.presentation.newsscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.newsapp.presentation.components.NewsArticleCard

@Composable
fun NewsScreen(
    viewModel: NewsViewModel = hiltViewModel()
){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(3.dp),
        contentPadding = PaddingValues(1.dp)
    ) {
        items(viewModel.articles){ article ->
            NewsArticleCard(
                article = article,
                onClick = {}
            )
        }
    }
}