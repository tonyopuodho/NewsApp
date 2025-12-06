package com.example.newsapp.util

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.newsapp.presentation.newsscreen.NewsScreen
import com.example.newsapp.presentation.newsscreen.NewsViewModel
import com.example.newsapp.presentation.secondscreen.ArticleScreen

@Composable
fun NavigationController(
    navController: NavHostController
){
    val argKey = "web_url"
    NavHost(
        navController = navController,
        startDestination = "news_screen"
    ) {
        composable(route = "news_screen"){
            val viewModel: NewsViewModel = hiltViewModel()
            NewsScreen(
                state = viewModel.state,
                onEvent = viewModel::onEvent,
                onReadFullStory = {url ->
                    navController.navigate(route = "article_screen?$argKey=$url")
                }
            )
        }
        composable(
            route = "article_screen?web_url={$argKey}",
            arguments = listOf(navArgument(name = argKey){
                type = NavType.StringType
            })
        ){ backEntry ->
            ArticleScreen(
                url = backEntry.arguments?.getString(argKey),
                onBackPress = { navController.navigateUp() }
            )
        }
    }
}