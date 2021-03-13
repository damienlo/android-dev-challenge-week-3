package com.example.androiddevchallenge.ui.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.ui.home.HomeScreen
import com.example.androiddevchallenge.ui.login.LoginScreen
import com.example.androiddevchallenge.ui.splash.SplashScreen

enum class Screen {
    SplashScreen,
    Login,
    Home
}

@Composable
fun AppNavigator() {
    var screen: Screen by rememberSaveable { mutableStateOf(Screen.SplashScreen) }
    Surface(modifier = Modifier.fillMaxSize()) {
        Crossfade(screen) { currentScreen ->
            when (currentScreen) {
                Screen.SplashScreen -> {
                    SplashScreen(navigateToNextScreen = { screen = Screen.Login })
                }
                Screen.Login -> {
                    LoginScreen(navigateToNextScreen = { screen = Screen.Home })
                    BackHandler { screen = Screen.SplashScreen }
                }
                Screen.Home -> {
                    HomeScreen()
                    BackHandler { screen = Screen.Login }
                }
            }
        }
    }
}