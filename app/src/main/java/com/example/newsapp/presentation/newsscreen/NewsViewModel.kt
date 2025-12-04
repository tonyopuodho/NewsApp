package com.example.newsapp.presentation.newsscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel(){
    var articles by mutableStateOf<List<Article>>(emptyList())
    private fun genNewsArticle(category: String){
        viewModelScope.launch {
            val results = newsRepository.getTopHeadline(category = category)
            when(results){
                is Resource.Error<*> -> TODO()
                is Resource.Success -> {
                    articles = results.data ?: emptyList()
                }
            }
        }
    }
}