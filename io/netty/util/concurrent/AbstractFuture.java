package io.netty.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class AbstractFuture implements Future {
    @Override
    public Object get() {
        this.await();
        Throwable throwable0 = this.cause();
        if(throwable0 == null) {
            return this.getNow();
        }
        if(!(throwable0 instanceof CancellationException)) {
            throw new ExecutionException(throwable0);
        }
        throw (CancellationException)throwable0;
    }

    @Override
    public Object get(long v, TimeUnit timeUnit0) {
        if(!this.await(v, timeUnit0)) {
            throw new TimeoutException();
        }
        Throwable throwable0 = this.cause();
        if(throwable0 == null) {
            return this.getNow();
        }
        if(!(throwable0 instanceof CancellationException)) {
            throw new ExecutionException(throwable0);
        }
        throw (CancellationException)throwable0;
    }
}

