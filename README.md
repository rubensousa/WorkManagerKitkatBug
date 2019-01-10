# WorkManagerKitkatBug

https://issuetracker.google.com/issues/122578012

Only happens on API 19 to 22 when there are constraints partially met:

```
Constraints.Builder()
        .setRequiredNetworkType(NetworkType.UNMETERED) // Constraint not met
        .setRequiresBatteryNotLow(true) // Constraint met
        .build()
```

```
01-09 17:08:14.403 8109-8122/com.github.rubensousa.workkitkatbug I/WM-WorkerWrapper: Work [ id=611978b9-8da6-4ae8-8479-7827a8c95d4e, tags={ com.github.rubensousa.workkitkatbug.TestWorkerA } ] was cancelled
    java.util.concurrent.CancellationException: Task was cancelled.
        at androidx.work.impl.utils.futures.AbstractFuture.cancellationExceptionWithCause(AbstractFuture.java:1184)
        at androidx.work.impl.utils.futures.AbstractFuture.getDoneValue(AbstractFuture.java:514)
        at androidx.work.impl.utils.futures.AbstractFuture.get(AbstractFuture.java:475)
        at androidx.work.impl.WorkerWrapper$2.run(WorkerWrapper.java:245)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1112)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:587)
        at java.lang.Thread.run(Thread.java:841)
```
