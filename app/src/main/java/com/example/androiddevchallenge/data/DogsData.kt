package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Breed
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.model.Gender

val dogsFakeList = listOf(
    Dog(id = 1,
        name = "sijia",
        gender = Gender.GIRL,
        photoRes = R.drawable.sijia,
        age = null,
        breed = Breed.Labrador,
        background = "rescued in the dog meat car",
    ),
    Dog(id = 2,
        name = "siji",
        gender = Gender.GIRL,
        photoRes = R.drawable.siji,
        age = null,
        breed = Breed.Labrador,
        background = "rescued from the dog dealer",
    )
)