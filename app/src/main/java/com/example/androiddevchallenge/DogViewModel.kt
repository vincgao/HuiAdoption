package com.example.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.dogsFakeList
import com.example.androiddevchallenge.model.Dog

class DogViewModel : ViewModel() {

    private val _dogs = MutableLiveData(dogsFakeList)
    val dogs: LiveData<List<Dog>> = _dogs

    fun onDogsListChanged(dogs: List<Dog>) {
        _dogs.value = dogs
    }
}