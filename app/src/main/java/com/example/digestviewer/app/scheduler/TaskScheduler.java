package com.example.digestviewer.app.scheduler;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by SER on 25.08.2015.
 */
public class TaskScheduler {

    private static String NAME = "TaskExecutor";

    private static int MAX_THREADS = 8;
    private static int KEEP_ALIVE = 30000;

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
        final AtomicInteger integer = new AtomicInteger();
        executor = new ThreadPoolExecutor(1, MAX_THREADS, KEEP_ALIVE, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
            @Override
            public Thread newThread(final Runnable r) {
                return new Thread(new Runnable() {
                    @Override
                    public void run() {
                        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                        r.run();
                    }
                }, NAME + integer.incrementAndGet());
            }
        });
        handler = new Handler(Looper.getMainLooper());
    }

    public <Result> Cancellable execute(Task<Result> task, Callback<Result> callback) {
        final TaskExecution<Result> taskExecution = new TaskExecution<Result>(task, callback, handler);
        executor.execute(taskExecution);
        return taskExecution;
    }

}
