package com.example.newsapp.presentation.newsscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.newsapp.presentation.components.CategoryTabRow
import com.example.newsapp.presentation.components.NewsArticleCard
import com.example.newsapp.presentation.components.TopBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    state: NewsScreenState,
    onEvent: (NewsScreenEvent) -> Unit
){
    /**
     * using scaffold to place topbar navigation and bottom bar navigation
     */
   //val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val pagerState = rememberPagerState(
        pageCount = {7}
    )
    val categories = listOf(
        "General", "Business","Health","Science","Sports","Technology","Entertainment"
    )
    val coroutineScope = rememberCoroutineScope()
    // launched effect used to change the category on news screen
    LaunchedEffect(key1 = pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            onEvent(NewsScreenEvent.onCategoryChenged(category = categories[page]))
        }
    }
    Scaffold(
        //modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar(
                //scrollBehavior = scrollBehavior,
                onMoverTClick = {}
            )
        },
    ) {innerPadding ->
        Column(
            modifier = Modifier.fillMaxWidth().padding(innerPadding)
        ) {
            CategoryTabRow(
                pagerState = pagerState,
                category = categories,
                onTabClick = { index ->
                    coroutineScope.launch { pagerState.animateScrollToPage(index) }
                }
            )
            HorizontalPager(
                beyondViewportPageCount = categories.size,
                state = pagerState
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(3.dp),
                    contentPadding = PaddingValues(1.dp),
                    modifier = Modifier.padding().padding(top = 2.dp)
                ) {
                    items(state.articles){ article ->
                        NewsArticleCard(
                            article = article,
                            onClick = {}
                        )
                    }
                }
            }
        }


    }
}