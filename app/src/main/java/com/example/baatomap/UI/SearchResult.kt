package com.example.baatomap.UI

import android.app.appsearch.SearchResult
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun SearchResults(results: List<com.example.baatomap.DataClasses.SearchResult>, onResultClick: (com.example.baatomap.DataClasses.SearchResult) -> Unit) {
    LazyColumn {
        items(results){result ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onResultClick(result) }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = result.name, fontWeight = FontWeight.Bold)
                    Text(text = result.address)
                    Text(text = "Type: ${result.type}")
                }
            }

        }
    }
}