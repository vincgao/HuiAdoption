package com.example.androiddevchallenge.model

data class Dog(
    val id: Int,
    val name: String,
    val gender: Gender,
    val age: Float?,
    val breed: Breed,
    val background: String?,
)

enum class Gender {
    BOY, GIRL
}

enum class Breed {
    Labrador, Alaskan, Husky, Samoyed
}