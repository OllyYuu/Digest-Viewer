package com.example.digestviewer.app.scheduler;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by SER on 25.08.2015.
 */
public class TaskScheduler {

    private static int MAX_THREADS = 4;
    private static int KEEP_ALIVE = 10000;

    private static TaskScheduler INSTANCE;

    public static TaskScheduler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TaskScheduler();
        }
        return INSTANCE;
    }

    private ThreadPoolExecutor executor;
    private Handler handler;

    private TaskScheduler() {
        executor = new ThreadPoolExecutor(1, MAX_THREADS, KEEP_ALIVE, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        handler = new Handler(Looper.getMainLooper());
    }

    public <Result> Cancellable execute(Task<Result> task, Callback<Result> callback) {
        final TaskExecution<Result> taskExecution = new TaskExecution<Result>(task, callback, handler);
        executor.execute(taskExecution);
        return taskExecution;
    }

}
