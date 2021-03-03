package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Dog

@Composable
fun DogCard(dog: Dog, modifier: Modifier = Modifier) {
    Card(modifier) {
        Column {
            Image(
                painter = painterResource(id = dog.photoRes),
                contentDescription = null,
                modifier = modifier
                    .size(100.dp, 100.dp)
                    .clip(MaterialTheme.shapes.small)
            )
            Text(text = dog.name)
        }
    }
}