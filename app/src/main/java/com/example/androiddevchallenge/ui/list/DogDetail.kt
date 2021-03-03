package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Dog

@Composable
fun DogDetail(dog: Dog) {
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
            DogCard(dog = dog, modifier = modifier)
        },
    )
}