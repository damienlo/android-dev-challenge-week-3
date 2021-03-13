package com.example.androiddevchallenge.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.MySoothButton
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun LoginScreen(navigateToNextScreen: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .background(MaterialTheme.colors.background)
    ) {
        val backgroundImageResId =
            if (isSystemInDarkTheme()) R.drawable.dark_login else R.drawable.light_login
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

            Text(
                text = stringResource(id = R.string.login_screen_title),
                style = MaterialTheme.typography.h1
            )

            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 56.dp),
                textStyle = MaterialTheme.typography.body1,
                placeholder = { Text(text = stringResource(R.string.login_screen_field_email)) }
            )
            OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 56.dp),
                textStyle = MaterialTheme.typography.body1,
                placeholder = { Text(text = stringResource(R.string.login_screen_field_password)) }
            )

            Spacer(modifier = Modifier.height(8.dp))
            MySoothButton(
                text = stringResource(id = R.string.login_screen_button_log_in),
                onClick = navigateToNextScreen
            )

            Spacer(modifier = Modifier.height(16.dp))
            val secondaryText = buildAnnotatedString {
                val text = stringResource(id = R.string.login_screen_secondary_text)
                append(text)
                addStyle(
                    style = SpanStyle(textDecoration = TextDecoration.Underline),
                    start = text.length - 7,
                    end = text.length
                )
            }
            Text(
                text = secondaryText,
                style = MaterialTheme.typography.body1
            )
        }

    }
}
