package com.omargtz.kavakfantasyapp.utils

import android.graphics.drawable.Drawable
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
fun TextView.setWeight(weight: Double) {
    text = resources.getString(R.string.weight, weight.toString())
}

@BindingAdapter("height")
fun TextView.setHeight(weight: Double) {
    text = resources.getString(R.string.height, weight.toString())
}

@BindingAdapter("friends")
fun TextView.setFriends(friends: List<String>) {
   val description = if (friends.isNotEmpty()) {
       friends.joinToString(", ")
   } else {
       resources.getString(R.string.friends_empty)
   }

    text = resources.getString(R.string.friends, description)
}

@BindingAdapter("professions")
fun TextView.setProfessions(professions: List<String>) {
    val description = if (professions.isNotEmpty()) {
        professions.joinToString(", ")
    } else {
        resources.getString(R.string.professions_empty_text)
    }
    text = resources.getString(R.string.professions, description)
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

@BindingAdapter("srcUrl", "circleCrop", "placeholder", requireAll = false)
fun ImageView.bindSrcUrl(
    url: String,
    circleCrop: Boolean,
    placeholder: Drawable?
) {
    val imageUrl = GlideUrl(
        url, LazyHeaders.Builder()
            .addHeader("User-Agent", "Kavak-Agent")
            .build()
    )
    val request = Glide.with(this).load(imageUrl)
    if (circleCrop) request.circleCrop()
    if (placeholder != null) request.placeholder(placeholder)
    request.into(this)
}
