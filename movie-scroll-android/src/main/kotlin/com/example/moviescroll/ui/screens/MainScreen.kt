package com.example.moviescroll.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.example.moviescroll.ui.elements.InfiniteScrollList
import com.example.moviescroll.ui.elements.Movie
import com.example.moviescroll.ui.elements.Person
import com.example.moviescroll.ui.screens.interfaces.ScreenWithNavigator
import com.example.moviescroll.ui.screens.interfaces.ScreenWithRoute
import kotlinx.coroutines.launch

class MainScreen(override val navigator: NavHostController) : ScreenWithNavigator, ScreenWithRoute {
    override val route = ROUTE

    @Composable
    fun Run() {
        val tabTitles = listOf("Movies", "People")
        val pagerState = rememberPagerState { tabTitles.size }
        val coroutineScope = rememberCoroutineScope()

        Column {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                indicator = { tabPositions ->
                    SecondaryIndicator(
                        Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
                    )
                }
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = { Text(title) }
                    )
                }
            }

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                when (page) {
                    0 -> MoviesTab()
                    1 -> PeopleTab()
                }
            }
        }
    }

    companion object {
        const val ROUTE = "main_screen"
    }
}

@Composable
fun MoviesTab() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        InfiniteScrollList { _ ->
            { Movie.ALL_MOVIES.random().Element() }
        }
    }
}

@Composable
fun PeopleTab() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        InfiniteScrollList { _ ->
            { Person.ALL_PEOPLE.random().Element() }
        }
    }
}


