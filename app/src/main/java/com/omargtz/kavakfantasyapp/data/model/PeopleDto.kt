package com.omargtz.kavakfantasyapp.data.model

import com.google.gson.annotations.SerializedName

data class PeopleDto(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("thumbnail")
    val thumbnail: String = "",
    @SerializedName("age")
    val age: Int,
    @SerializedName("weight")
    val weight: Double = 0.0,
    @SerializedName("height")
    val height: Double = 0.0,
    @SerializedName("hair_color")
    val hair_color: String = "",
    @SerializedName("professions")
    val professions: List<String> = listOf(),
    @SerializedName("friends")
    val friends: List<String> = listOf()
)
