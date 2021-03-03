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
package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.list.DogDetail
import com.example.androiddevchallenge.ui.theme.MyTheme

@ExperimentalFoundationApi
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
                DogDetail(
                    dog = intent.getParcelableExtra("dog")!!,
                    onBack = { finish() }
                )
            }
        }
    }
}
