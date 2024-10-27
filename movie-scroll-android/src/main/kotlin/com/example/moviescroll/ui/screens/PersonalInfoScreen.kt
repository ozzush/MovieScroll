package com.example.moviescroll.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.moviescroll.ui.screens.interfaces.ScreenWithNavigator
import com.example.moviescroll.ui.screens.interfaces.ScreenWithRoute

class PersonalInfoScreen(override val navigator: NavHostController) : ScreenWithRoute, ScreenWithNavigator {
    override val route = ROUTE

    @Composable
    fun Run(
        name: String,
        email: String
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Account Info", style = MaterialTheme.typography.headlineLarge)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = name)
            Text(text = email)

            Spacer(modifier = Modifier.height(16.dp))
        }
    }

    companion object {
        const val ROUTE = "account_info"
    }
}
