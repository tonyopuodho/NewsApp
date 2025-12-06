package com.example.newsapp.util

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.newsapp.presentation.newsscreen.NewsScreen
import com.example.newsapp.presentation.newsscreen.NewsViewModel
import com.example.newsapp.presentation.secondscreen.ArticleScreen

@Composable
fun Navigation(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = "news_screen"
    ){
        composable(route = "news_screen"){
            val viewModel: NewsViewModel = hiltViewModel()
            NewsScreen(
                state = viewModel.state,
                onEvent = viewModel::onEvent
            )
        }
        composable(
            route = "article_screen?web_url={web_url}",
            arguments = listOf(navArgument(name = "web_url"){
                type = NavType.StringType
            })
        ){
            ArticleScreen(
             url = "",
             onBackPress = {}
            )
        }
    }

}