package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.DummyItem
import com.example.androiddevchallenge.data.HomeDummyItems

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
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Spacer(modifier = Modifier.height(32.dp))

                // Search
                TextField(
                    value = "",
                    onValueChange = { },
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .fillMaxWidth()
                        .defaultMinSize(minHeight = 56.dp),
                    textStyle = MaterialTheme.typography.body1,
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.home_screen_field_search),
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onSurface,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface,
                        unfocusedIndicatorColor = MaterialTheme.colors.onSurface
                    ),
                    shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)
                )
            }

            // FAVORITE
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.home_screen_section_favorite),
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = MaterialTheme.colors.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.h2
                )
            }
            item {
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(contentPadding = PaddingValues(start = 8.dp)) {
                    items(
                        HomeDummyItems.favoriteList.chunked(2)
                            .map { it[0] to it[1] }) { itemContent ->
                        MySoothItemCardListVerticalItem(itemContent)
                    }
                }
            }

            // BODY
            item {
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = stringResource(R.string.home_screen_section_your_body),
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = MaterialTheme.colors.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.h2
                )
            }
            item {
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(contentPadding = PaddingValues(start = 8.dp)) {
                    items(HomeDummyItems.alignBodyList) { itemContent ->
                        MySoothImageListItem(itemContent)
                    }
                }
            }

            // MIND
            item {
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = stringResource(R.string.home_screen_section_your_mind),
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = MaterialTheme.colors.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.h2
                )
            }
            item {
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(contentPadding = PaddingValues(start = 8.dp)) {
                    items(HomeDummyItems.alignMindList) { itemContent ->
                        MySoothImageListItem(itemContent)
                    }
                }
            }

        }
    }
}

@Composable
fun MySoothItemCardListVerticalItem(itemContent: Pair<DummyItem, DummyItem>) {
    Column(
        modifier = Modifier
            .padding(start = 8.dp)
    ) {
        MySoothItemCardListItem(itemContent.first)
        Spacer(modifier = Modifier.height(8.dp))
        MySoothItemCardListItem(itemContent.second)
    }
}

@Composable
fun MySoothItemCardListItem(itemContent: DummyItem) {
    Card(
        modifier = Modifier
            .width(192.dp)
            .height(56.dp),
        shape = MaterialTheme.shapes.small,
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = itemContent.image),
                contentDescription = itemContent.text,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.aspectRatio(1f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = itemContent.text,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(8.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun MySoothImageListItem(itemContent: DummyItem) {
    Column(
        modifier = Modifier.padding(start = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = itemContent.image),
            contentDescription = itemContent.text,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(88.dp)
                .height(88.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = itemContent.text,
            modifier = Modifier.width(88.dp),
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
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
            selected = true,
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
