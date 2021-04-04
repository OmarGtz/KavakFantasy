package com.omargtz.kavakfantasyapp.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
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
    text = name
}

@BindingAdapter("weight")
fun TextView.setWeight(weight: String) {
    text = resources.getString(R.string.weight, weight)
}

@BindingAdapter("height")
fun TextView.setHeight(weight: String) {
    text = resources.getString(R.string.height, weight)
}

@BindingAdapter("friends")
fun TextView.setFriends(friends: List<String>) {
    text = resources.getString(R.string.friends, friends.joinToString { "" })
}

@BindingAdapter("professions")
fun TextView.setProfessions(professions: List<String>) {
    text = resources.getString(R.string.professions, professions.joinToString { " " })
}

@BindingAdapter("image")
fun ImageView.setImageUrl(imageUrl: String) {
    val url = GlideUrl(
        imageUrl, LazyHeaders.Builder()
            .addHeader("User-Agent", "Kavak-Agent")
            .build()
    )
    val request = Glide.with(this).load(url).diskCacheStrategy(
        DiskCacheStrategy.NONE)

    request.into(this)
}


