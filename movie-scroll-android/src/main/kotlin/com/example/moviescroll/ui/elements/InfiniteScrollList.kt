package com.example.moviescroll.ui.elements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InfiniteScrollList(generateContent: (Int) -> @Composable (() -> Unit)) {
    var items by remember { mutableStateOf(List(20) { generateContent(it) }) }

    LazyColumn(modifier = Modifier.padding(horizontal = 8.dp).fillMaxSize()) {
        itemsIndexed(items) { index, item ->
            item()
            if (index == items.lastIndex) {
                items = items + List(20) { generateContent(it + items.size) }
            }
        }
    }
}