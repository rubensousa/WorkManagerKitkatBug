package com.github.rubensousa.workkitkatbug

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class TestWorkerC(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        Log.d(this::class.java.simpleName, "I did some work")
        return Result.success()
    }


}