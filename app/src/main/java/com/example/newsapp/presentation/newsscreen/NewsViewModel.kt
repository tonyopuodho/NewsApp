package com.example.newsapp.presentation.newsscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
    var state by mutableStateOf(NewsScreenState())

    fun onEvent(event: NewsScreenEvent){
        when(event){
            is NewsScreenEvent.onCategoryChenged -> {
                state = state.copy(category = event.category)
                genNewsArticle(category = state.category)
            }
            is NewsScreenEvent.onNewsCardClicked -> TODO()
        }
    }
    init {
        genNewsArticle(category = "general")
    }
    private fun genNewsArticle(category: String){
        //making an api call using viewModelScope as coroutine
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val results = newsRepository.getTopHeadline(category = category)
            when(results){
                is Resource.Error -> {

                }
                is Resource.Success -> {
                    state = state.copy(
                        articles = results.data ?: emptyList(),
                        isLoading = false
                    )
                }
            }
        }
    }
}