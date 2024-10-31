package com.example.moviescroll.ui.elements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InfiniteScrollList(
    items: MutableState<List<ComposableElement>>,
    expandBy: Int = 5,
    generateContent: (Int) -> ComposableElement,
) {
    var itemsRemember by remember { items }
    fun expandItems() {
        itemsRemember = itemsRemember + List(expandBy) { generateContent(it + itemsRemember.size) }
    }

    if (itemsRemember.isEmpty()) expandItems()

    LazyColumn(modifier = Modifier.padding(horizontal = 8.dp).fillMaxSize()) {
        itemsIndexed(itemsRemember) { index, item ->
            item()
            if (index == itemsRemember.lastIndex) expandItems()
        }
    }
}