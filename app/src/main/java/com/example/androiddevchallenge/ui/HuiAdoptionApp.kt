package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HuiAdoptionApp() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            AppContent()
        }
    }
}

@Composable
private fun AppContent() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.subtitle2,
                        color = LocalContentColor.current
                    )
                }
            )
        },
        content = { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
        },
    )
}