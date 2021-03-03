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
package com.example.androiddevchallenge.model

import android.os.Parcel
import android.os.Parcelable

data class Dog(
    val id: Int,
    val name: String,
    val gender: Gender,
    val photoRes: Int,
    val age: Float?,
    val breed: Breed,
    val background: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        Gender.valueOf(parcel.readString()!!),
        parcel.readInt(),
        parcel.readValue(Float::class.java.classLoader) as? Float,
        Breed.valueOf(parcel.readString()!!),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(gender.name)
        parcel.writeInt(photoRes)
        parcel.writeValue(age)
        parcel.writeString(breed.name)
        parcel.writeString(background)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dog> {
        override fun createFromParcel(parcel: Parcel): Dog {
            return Dog(parcel)
        }

        override fun newArray(size: Int): Array<Dog?> {
            return arrayOfNulls(size)
        }
    }
}

enum class Gender {
    BOY, GIRL
}

enum class Breed {
    Labrador, Alaskan, Husky, Samoyed
}
