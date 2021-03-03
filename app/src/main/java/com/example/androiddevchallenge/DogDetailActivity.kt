package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.list.DogDetail
import com.example.androiddevchallenge.ui.theme.MyTheme

class DogDetailActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context, dog: Dog) {
            Intent(context, DogDetailActivity::class.java).apply {
                putExtra("dog", dog)
                context.startActivity(this)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                DogDetail(dog = intent.getParcelableExtra("dog")!!)
            }
        }
    }
}