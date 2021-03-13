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