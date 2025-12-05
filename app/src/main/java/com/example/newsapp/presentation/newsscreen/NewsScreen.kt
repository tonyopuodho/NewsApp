package com.example.newsapp.presentation.newsscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.newsapp.presentation.components.NewsArticleCard
import com.example.newsapp.presentation.components.TopBar

@Composable
fun NewsScreen(
    viewModel: NewsViewModel = hiltViewModel()
){
    /**
     * using scaffold to place topbar navigation and bottom bar navigation
     */

    Scaffold(
        topBar = {
            TopBar(onMoverTClick = {})
        }
    ) {innerPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(3.dp),
            contentPadding = PaddingValues(1.dp),
            modifier = Modifier.padding(innerPadding).padding(top = 2.dp)
        ) {
            items(viewModel.articles){ article ->
                NewsArticleCard(
                    article = article,
                    onClick = {}
                )
            }
        }

    }
}