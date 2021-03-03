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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.DogDetailActivity
import com.example.androiddevchallenge.DogViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.list.DogCard
import com.example.androiddevchallenge.ui.theme.MyTheme

@ExperimentalFoundationApi
@Composable
fun HuiAdoptionApp(dogViewModel: DogViewModel = viewModel()) {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            AppContent(dogViewModel)
        }
    }
}

@ExperimentalFoundationApi
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

@ExperimentalFoundationApi
@Composable
private fun DogList(dogs: List<Dog>, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 150.dp),
        modifier = modifier.padding(5.dp)
    ) {
        items(dogs) { dog ->
            DogCard(
                dog,
                modifier.clickable {
                    DogDetailActivity.start(context, dog)
                }.padding(5.dp)
            )
        }
    }
}

@ExperimentalFoundationApi

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        HuiAdoptionApp()
    }
}

@ExperimentalFoundationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        HuiAdoptionApp()
    }
}
