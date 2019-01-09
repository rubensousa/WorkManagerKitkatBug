package com.github.rubensousa.workkitkatbug

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val classes = arrayOf(
                TestWorkerA::class.java,
                TestWorkerB::class.java,
                TestWorkerC::class.java,
                TestWorkerD::class.java,
                TestWorkerE::class.java
            )
            for (classe in classes) {
                WorkManager.getInstance().enqueueUniquePeriodicWork(
                    classe.simpleName,
                    ExistingPeriodicWorkPolicy.KEEP,
                    PeriodicWorkRequest.Builder(classe, 15, TimeUnit.MINUTES)
                        .setConstraints(getDefaultConstraints()).build()
                )
            }
        }
    }

    private fun getDefaultConstraints() = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.UNMETERED)
        .setRequiresBatteryNotLow(true)
        .build()
}
