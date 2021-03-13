/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
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
