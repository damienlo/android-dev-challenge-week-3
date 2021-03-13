package com.example.androiddevchallenge.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.MyApp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MySootheTheme
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import java.util.*

@Composable
fun SplashScreen(navigateToNextScreen: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .background(MaterialTheme.colors.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.light_welcome),
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
            Button(
                onClick = navigateToNextScreen,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .height(72.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    stringResource(id = R.string.splash_screen_button_sign_up),
                    style = MaterialTheme.typography.button
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = navigateToNextScreen,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .height(72.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
            ) {
                Text(
                    stringResource(id = R.string.splash_screen_button_log_in),
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}


@Preview("SplashScreen", widthDp = 360, heightDp = 640)
@Composable
fun SplashScreenPreview() {
    SplashScreen { /* Preview */ }
}
