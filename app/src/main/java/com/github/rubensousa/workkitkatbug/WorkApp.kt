package com.github.rubensousa.workkitkatbug

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager

class WorkApp : Application() {

    override fun onCreate() {
        super.onCreate()
        WorkManager.initialize(this, Configuration.Builder().build())
    }

}