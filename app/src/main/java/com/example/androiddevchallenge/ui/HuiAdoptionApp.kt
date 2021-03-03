package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.DogViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.list.DogCard
import com.example.androiddevchallenge.ui.list.DogListScreen
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HuiAdoptionApp(dogViewModel: DogViewModel = viewModel()) {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            AppContent(dogViewModel)
        }
    }
}

@Composable
private fun AppContent(dogViewModel: DogViewModel) {
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
            dogViewModel.dogs.value?.let {
                DogList(dogs = it, modifier = modifier)
            }
        },
    )
}

@Composable
private fun DogList(dogs: List<Dog>, modifier: Modifier = Modifier) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier.padding(horizontal = 16.dp)) {
        items(dogs) { dog ->
            DogCard(dog, modifier)
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        HuiAdoptionApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        HuiAdoptionApp()
    }
}
