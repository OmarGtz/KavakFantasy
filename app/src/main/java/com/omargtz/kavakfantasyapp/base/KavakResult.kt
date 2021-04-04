package com.omargtz.kavakfantasyapp.base

import androidx.lifecycle.MutableLiveData

sealed class KavakResult<out R> {

    data class Success<out T>(val data: T) : KavakResult<T>()
    data class Error(val exception: Throwable) : KavakResult<Nothing>()
    object Loading : KavakResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

/**
 * [Success.data] if [KavakResult] is of type [Success]
 */
fun <T> KavakResult<T>.successOr(fallback: T): T {
    return (this as? KavakResult.Success<T>)?.data ?: fallback
}

val <T> KavakResult<T>.data: T?
    get() = (this as? KavakResult.Success)?.data

/**
 * Updates value of [liveData] if [KavakResult] is of type [Success]
 */
inline fun <reified T> KavakResult<T>.updateOnSuccess(liveData: MutableLiveData<T>) {
    if (this is KavakResult.Success) {
        liveData.value = data
    }
}