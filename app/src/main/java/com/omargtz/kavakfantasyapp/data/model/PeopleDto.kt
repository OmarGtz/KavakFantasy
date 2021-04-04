package com.omargtz.kavakfantasyapp.data.model

data class PeopleDto(
    val id: Int,
    val name: String,
    val thumbnail: String,
    val age: String,
    val weight: String,
    val hair_color: String,
    val professions: List<String>,
    val friends: List<String>
)
