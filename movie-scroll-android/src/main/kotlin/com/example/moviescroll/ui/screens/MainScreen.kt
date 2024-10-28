package com.example.moviescroll.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.example.moviescroll.client.Client
import com.example.moviescroll.ui.elements.*
import com.example.moviescroll.ui.screens.interfaces.ScreenWithNavigator
import com.example.moviescroll.ui.screens.interfaces.ScreenWithRoute
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainScreen(override val navigator: NavHostController) : ScreenWithNavigator, ScreenWithRoute {
    override val route = ROUTE

//    private val client = Client("http://0.0.0.0:8080")
    private val movieItems = mutableStateOf(emptyList<ComposableElement>())
    private val personItems = mutableStateOf(emptyList<ComposableElement>())

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
                        onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                        text = { Text(title) }
                    )
                }
            }

            HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
                when (page) {
                    0 -> MoviesTab()
                    1 -> PeopleTab()
                }
            }
        }
    }

    @Composable
    fun MoviesTab() = InfiniteScrollList(movieItems) { _ ->
        val movie = runBlocking { Person.ALL_PEOPLE.random() }
        return@InfiniteScrollList { movie.Element() }
    }

    @Composable
    fun PeopleTab() = InfiniteScrollBox(personItems) { i ->
        val person = Person.ALL_PEOPLE.random()
        return@InfiniteScrollBox { person.Element() }
    }

    companion object {
        const val ROUTE = "main_screen"
    }
}




