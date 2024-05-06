package com.sharkdroid.tweetfy

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Tweetfy: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}