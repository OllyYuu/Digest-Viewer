package com.example.digestviewer.app.scheduler;

/**
 * Created by SER on 25.08.2015.
 */
abstract public class Task<Result> {

    public abstract Result doRequest() throws Exception;

}
