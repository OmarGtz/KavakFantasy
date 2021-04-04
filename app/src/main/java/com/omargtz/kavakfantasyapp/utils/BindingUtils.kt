package com.omargtz.kavakfantasyapp.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView
import com.omargtz.kavakfantasyapp.R

@BindingAdapter("age")
fun TextView.setAge(age: Int) {
    text = resources.getString(R.string.age, age)
}

@BindingAdapter("hairColor")
fun TextView.setHairColor(color: String) {
    text = resources.getString(R.string.hair_color, color)
}

@BindingAdapter("name")
fun TextView.setName(name: String) {
    text = resources.getString(R.string.name, name)
}

@BindingAdapter("weight")
fun TextView.setWeight(weight: String) {
    text = resources.getString(R.string.name, weight)
}

@BindingAdapter("height")
fun TextView.setHeight(weight: String) {
    text = resources.getString(R.string.name, weight)
}

@BindingAdapter("friends")
fun TextView.setFriends(weight: String) {
    text = resources.getString(R.string.name, weight)
}

@BindingAdapter("professions")
fun TextView.setProfessions(weight: String) {
    text = resources.getString(R.string.name, weight)
}

@BindingAdapter("image")
fun SimpleDraweeView.setImageUrl(imageUrl: String) {
    setImageUrl(imageUrl)
}

