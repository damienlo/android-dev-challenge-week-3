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
package com.example.androiddevchallenge.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.MySoothButton
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import java.util.Locale

@Composable
fun SplashScreen(navigateToNextScreen: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .background(MaterialTheme.colors.background)
    ) {
        val backgroundImageResId =
            if (isSystemInDarkTheme()) R.drawable.dark_welcome else R.drawable.light_welcome
        Image(
            painter = painterResource(id = backgroundImageResId),
            contentDescription = "background image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            val title = buildAnnotatedString {
                append(stringResource(id = R.string.app_name).toUpperCase(Locale.getDefault()))
                addStyle(style = SpanStyle(fontWeight = FontWeight.Light), start = 0, end = 2)
                addStyle(style = SpanStyle(fontWeight = FontWeight.Normal), start = 2, end = 7)
            }
            Text(
                text = title,
                style = MaterialTheme.typography.h1
            )

            Spacer(modifier = Modifier.height(32.dp))
            MySoothButton(
                text = stringResource(id = R.string.splash_screen_button_sign_up),
                onClick = navigateToNextScreen
            )

            Spacer(modifier = Modifier.height(8.dp))
            MySoothButton(
                text = stringResource(id = R.string.splash_screen_button_log_in),
                onClick = navigateToNextScreen,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            )
        }
    }
}

@Preview("SplashScreen", widthDp = 360, heightDp = 640)
@Composable
fun SplashScreenPreview() {
    SplashScreen { /* Preview */ }
}
