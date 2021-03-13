package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier
            .navigationBarsPadding()
            .background(MaterialTheme.colors.background)
            .fillMaxSize(),
        bottomBar = {
            MySoothBottomNavigation()
        },
        floatingActionButton = { MySoothFab() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Spacer(modifier = Modifier.height(32.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .fillMaxWidth()
                        .defaultMinSize(minHeight = 56.dp),
                    textStyle = MaterialTheme.typography.body1,
                    placeholder = { Text(text = stringResource(R.string.home_screen_field_search)) },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                )
            }

        }
    }
}

@Composable
fun MySoothFab() {
    FloatingActionButton(
        backgroundColor = MaterialTheme.colors.primary,
        onClick = {}
    ) {
        Icon(
            Icons.Filled.PlayArrow,
            contentDescription = "play",
            tint = MaterialTheme.colors.onPrimary,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
private fun MySoothBottomNavigation() {
    BottomNavigation( // BottomAppBar?
        backgroundColor = MaterialTheme.colors.background,
        elevation = 8.dp
    ) {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Spa, contentDescription = "home") },
            label = {
                Text(
                    text = stringResource(R.string.navigation_bottom_bar_home),
                    style = MaterialTheme.typography.caption
                )
            },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.AccountCircle, contentDescription = "Profile") },
            label = {
                Text(
                    text = stringResource(R.string.navigation_bottom_bar_profile),
                    style = MaterialTheme.typography.caption
                )
            },
            selected = false,
            onClick = {}
        )
    }
}
