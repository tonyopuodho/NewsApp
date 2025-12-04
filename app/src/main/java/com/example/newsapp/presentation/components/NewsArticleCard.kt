package com.example.newsapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.newsapp.domain.model.Article

@Composable
fun NewsArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: (Article) -> Unit
){
    // card is a composable that holds all the content in one place
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier.clickable{ onClick(article) }
    ) {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            ImageHolder(article.urlToImage)
            Spacer(modifier = modifier.height(4.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = article.source.name ?:"", style = MaterialTheme.typography.bodySmall)
                Text(text = article.publishedAt , style = MaterialTheme.typography.bodySmall)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = article.title,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )
        }
    }
}