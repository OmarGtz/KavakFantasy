package com.omargtz.kavakfantasyapp

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KavakApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initFresco()
    }

    private fun initFresco() {
        Fresco.initialize(this)
    }
}

