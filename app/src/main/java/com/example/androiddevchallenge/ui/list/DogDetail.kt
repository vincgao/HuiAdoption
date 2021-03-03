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
package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.dogsFakeList
import com.example.androiddevchallenge.model.Dog

@Composable
fun DogDetail(dog: Dog, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = dog.name,
                        style = MaterialTheme.typography.subtitle2,
                        color = LocalContentColor.current
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "back"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            DogDetail(dog = dog)
        },
    )
}

@Composable
fun DogDetail(dog: Dog) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp)
        .verticalScroll(rememberScrollState())) {
        Card(elevation = 4.dp, modifier = Modifier.padding(25.dp)) {
            Image(
                painter = painterResource(id = dog.photoRes),
                contentDescription = null,
                Modifier.aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(Modifier.size(10.dp))

        Text(text = "Name: ${dog.name}", style = MaterialTheme.typography.h4)
        ProvideTextStyle(MaterialTheme.typography.h6) {
            Text(text = "Breed: ${dog.breed.name}")
            Text(text = "Gender: ${dog.gender.name}")
            when {
                dog.age == null -> {
                    Text(text = "Age: Not Known")
                }
                dog.age < 1f -> {
                    Text(text = "Age: ${(dog.age * 12).toInt()} months old")
                }
                else -> {
                    Text(text = "Age: ${dog.age.toInt()} years old")
                }
            }
            Text(text = "Background: ${dog.background}")
        }

    }
}

@Preview
@Composable
fun PreviewDogDetail() {
    DogDetail(dog = dogsFakeList[0], {})
}
