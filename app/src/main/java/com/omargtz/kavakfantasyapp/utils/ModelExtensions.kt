package com.omargtz.kavakfantasyapp.utils


import com.google.gson.Gson
import com.omargtz.kavakfantasyapp.data.model.PeopleDto

fun PeopleDto.toJson(): String {
    return Gson().toJson(this)
}

fun <T: Any>String.fromJson(clazz: Class<T>, json: String): T {
    return Gson().fromJson<T>(json, clazz)
}