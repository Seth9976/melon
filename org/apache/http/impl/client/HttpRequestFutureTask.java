package org.apache.http.impl.client;

import java.util.concurrent.FutureTask;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpRequestFutureTask extends FutureTask {
    private final HttpRequestTaskCallable callable;
    private final HttpUriRequest request;

    public HttpRequestFutureTask(HttpUriRequest httpUriRequest0, HttpRequestTaskCallable httpRequestTaskCallable0) {
        super(httpRequestTaskCallable0);
        this.request = httpUriRequest0;
        this.callable = httpRequestTaskCallable0;
    }

    @Override
    public boolean cancel(boolean z) {
        this.callable.cancel();
        if(z) {
            this.request.abort();
        }
        return super.cancel(z);
    }

    public long endedTime() {
        if(!this.isDone()) {
            throw new IllegalStateException("Task is not done yet");
        }
        return this.callable.getEnded();
    }

    public long requestDuration() {
        if(!this.isDone()) {
            throw new IllegalStateException("Task is not done yet");
        }
        return this.endedTime() - this.startedTime();
    }

    public long scheduledTime() {
        return this.callable.getScheduled();
    }

    public long startedTime() {
        return this.callable.getStarted();
    }

    public long taskDuration() {
        if(!this.isDone()) {
            throw new IllegalStateException("Task is not done yet");
        }
        return this.endedTime() - this.scheduledTime();
    }

    @Override
    public String toString() {
        return this.request.getRequestLine().getUri();
    }
}

