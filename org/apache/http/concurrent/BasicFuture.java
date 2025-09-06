package org.apache.http.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.util.Args;

public class BasicFuture implements Future, Cancellable {
    private final FutureCallback callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private volatile Exception ex;
    private volatile Object result;

    public BasicFuture(FutureCallback futureCallback0) {
        this.callback = futureCallback0;
    }

    @Override  // org.apache.http.concurrent.Cancellable
    public boolean cancel() {
        return this.cancel(true);
    }

    @Override
    public boolean cancel(boolean z) {
        synchronized(this) {
            if(this.completed) {
                return false;
            }
            this.completed = true;
            this.cancelled = true;
            this.notifyAll();
        }
        FutureCallback futureCallback0 = this.callback;
        if(futureCallback0 != null) {
            futureCallback0.cancelled();
        }
        return true;
    }

    public boolean completed(Object object0) {
        synchronized(this) {
            if(this.completed) {
                return false;
            }
            this.completed = true;
            this.result = object0;
            this.notifyAll();
        }
        FutureCallback futureCallback0 = this.callback;
        if(futureCallback0 != null) {
            futureCallback0.completed(object0);
        }
        return true;
    }

    public boolean failed(Exception exception0) {
        synchronized(this) {
            if(this.completed) {
                return false;
            }
            this.completed = true;
            this.ex = exception0;
            this.notifyAll();
        }
        FutureCallback futureCallback0 = this.callback;
        if(futureCallback0 != null) {
            futureCallback0.failed(exception0);
        }
        return true;
    }

    @Override
    public Object get() {
        synchronized(this) {
            while(!this.completed) {
                this.wait();
            }
            return this.getResult();
        }
    }

    @Override
    public Object get(long v, TimeUnit timeUnit0) {
        synchronized(this) {
            Args.notNull(timeUnit0, "Time unit");
            long v2 = timeUnit0.toMillis(v);
            int v3 = Long.compare(v2, 0L);
            long v4 = v3 > 0 ? System.currentTimeMillis() : 0L;
            if(this.completed) {
                return this.getResult();
            }
            if(v3 > 0) {
                long v5 = v2;
                do {
                    this.wait(v5);
                    if(this.completed) {
                        return this.getResult();
                    }
                    v5 = v2 - (System.currentTimeMillis() - v4);
                }
                while(v5 > 0L);
                throw new TimeoutException();
            }
        }
        throw new TimeoutException();
    }

    private Object getResult() {
        if(this.ex != null) {
            throw new ExecutionException(this.ex);
        }
        return this.result;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public boolean isDone() {
        return this.completed;
    }
}

