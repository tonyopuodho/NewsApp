package com.example.newsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.presentation.newsscreen.NewsScreen
import com.example.newsapp.presentation.newsscreen.NewsViewModel
import com.example.newsapp.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            navigationBarStyle = SystemBarStyle.dark(
                android.graphics.Color.BLACK
            )
        )
        setContent {
            val navController = rememberNavController()
            Navigation(navController = navController)
        }
    }
}