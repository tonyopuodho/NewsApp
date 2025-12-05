package com.example.newsapp.presentation.newsscreen

import com.example.newsapp.domain.model.Article

sealed class NewsScreenEvent {
    data class onNewsCardClicked(val article: Article): NewsScreenEvent()
    data class onCategoryChenged(val category: String): NewsScreenEvent()
}