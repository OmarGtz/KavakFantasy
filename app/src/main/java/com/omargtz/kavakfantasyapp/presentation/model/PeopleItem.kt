package com.omargtz.kavakfantasyapp.presentation.model

import com.google.gson.annotations.SerializedName

data class PeopleItem (
    val name: String,
    val thumbnail: String,
    val age: String,
    val weight: String,
    val height: String,
    val hair_color: String,
    val professions: String,
    val friends: String
)