package com.example.moviescroll.ui.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun InfiniteScrollBox(
    items: MutableState<List<ComposableElement>>,
    expandBy: Int = 5,
    generateContent: (Int) -> ComposableElement
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        InfiniteScrollList(items, expandBy, generateContent)
    }
}