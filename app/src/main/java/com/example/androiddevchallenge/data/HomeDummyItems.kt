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
package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class DummyItem(
    val text: String,
    @DrawableRes val image: Int
)

object HomeDummyItems {

    val favoriteList = listOf(
        DummyItem("Short mantras", R.drawable.mantras),
        DummyItem("Nature meditation", R.drawable.nature_meditation),
        DummyItem("Stress and anxiety", R.drawable.stress_anxiety),
        DummyItem("Self-massage", R.drawable.self_massage),
        DummyItem("Overwhelmed", R.drawable.overwhelmed),
        DummyItem("Nightly wind down", R.drawable.nightly)
    )

    val alignBodyList = listOf(
        DummyItem("Inversions", R.drawable.inversions),
        DummyItem("Quick yoga", R.drawable.quick_yoga),
        DummyItem("Stretching", R.drawable.stretching),
        DummyItem("Tabata", R.drawable.tabata),
        DummyItem("HIIT", R.drawable.hiit),
        DummyItem("Pre-natal yoga", R.drawable.pre_natal_yoga),
    )

    val alignMindList = listOf(
        DummyItem("Meditate", R.drawable.meditate),
        DummyItem("With kids", R.drawable.with_kids),
        DummyItem("Aromatherapy", R.drawable.aromatherapy),
        DummyItem("On the go", R.drawable.on_the_go),
        DummyItem("With pets", R.drawable.with_pets),
        DummyItem("High stress", R.drawable.high_stress),
    )
}
