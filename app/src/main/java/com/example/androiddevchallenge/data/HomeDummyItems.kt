package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class DummyItem(
    val text: String,
    @DrawableRes val image: Int
)

object HomeDummyItems {

    val alignBodyList = listOf(
        DummyItem("Nature meditation", R.drawable.nature_meditation),
        DummyItem("Nature meditation", R.drawable.nature_meditation),
        DummyItem("Nature meditation", R.drawable.nature_meditation),
        DummyItem("Nature meditation", R.drawable.nature_meditation),
        DummyItem("Nature meditation", R.drawable.nature_meditation),
        DummyItem("Nature meditation", R.drawable.nature_meditation),
    )

    val alignMindList = listOf(
        DummyItem("Nature meditation", R.drawable.nature_meditation),
        DummyItem("Nature meditation", R.drawable.nature_meditation),
        DummyItem("Nature meditation", R.drawable.nature_meditation),
        DummyItem("Nature meditation", R.drawable.nature_meditation),
        DummyItem("Nature meditation", R.drawable.nature_meditation),
        DummyItem("Nature meditation", R.drawable.nature_meditation),
    )

}