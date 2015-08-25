package com.example.digestviewer.app.scheduler;

import android.os.Handler;

import java.util.Objects;

/**
 * Created by SER on 25.08.2015.
 */
public class TaskExecution<Result> implements Cancellable, Runnable {

    private static final int STATE_INIT = 0;
    private static final int STATE_STARTED = 1;
    private static final int STATE_COMPLETED = 2;
    private static final int STATE_CANCELLED = 3;

    private Task<Result> task;
    private Callback<Result> callback;
    private Handler mainHandler;

    private volatile int state = STATE_INIT;

    public TaskExecution(Task<Result> task, Callback<Result> callback, Handler mainHandler) {
        this.task = task;
        this.callback = callback;
        this.mainHandler = mainHandler;
    }

    @Override
    public synchronized void cancel() {
        setState(STATE_CANCELLED);
    }

    public synchronized void setState(int state) {
        this.state = state;
    }

    private boolean isCancelled() {
        return state == STATE_CANCELLED;
    }

    @Override
    public void run() {
        try {
            onSuccess(task.doRequest());
        } catch (InterruptedException ex) {
            setState(STATE_CANCELLED);
        } catch (Exception ex) {
            setState(STATE_COMPLETED);
            onError(ex.toString());
        } finally {
            onComplete();
        }

    }

    public void onSuccess(final Result result) {
        if (callback != null) {
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    callback.onSuccess(result);
                }
            });
        }
    }

    public void onError(final String error) {
        if (callback != null) {
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    callback.onError(error);
                }
            });
        }
    }

    public void onComplete() {
        if (callback != null) {
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    callback.onComplete();
                }
            });
        }
    }
}
