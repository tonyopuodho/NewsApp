package com.example.newsapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryTab(
    pagerState: PagerState,
    category: List<String>,
    onTabClick: (Int) -> Unit
){
    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        edgePadding = 0.dp,
        containerColor = Color.White,
        contentColor = Color.White
    ) {
        category.forEachIndexed { index,categories ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = { onTabClick(index) },
                content = {
                    Text(
                        text = categories,
                        modifier = Modifier.padding(vertical = 6.dp, horizontal = 2.dp)
                    )
                }
            )
        }
    }
}