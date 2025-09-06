package org.apache.http.pool;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.Args;

@ThreadSafe
abstract class PoolEntryFuture implements Future {
    private final FutureCallback callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private final Condition condition;
    private final Lock lock;
    private Object result;

    public PoolEntryFuture(Lock lock0, FutureCallback futureCallback0) {
        this.lock = lock0;
        this.condition = lock0.newCondition();
        this.callback = futureCallback0;
    }

    public boolean await(Date date0) {
        boolean z;
        this.lock.lock();
        try {
            if(!this.cancelled) {
                if(date0 == null) {
                    this.condition.await();
                    z = true;
                }
                else {
                    z = this.condition.awaitUntil(date0);
                }
                if(this.cancelled) {
                    throw new InterruptedException("Operation interrupted");
                }
                return z;
            }
        }
        finally {
            this.lock.unlock();
        }
        throw new InterruptedException("Operation interrupted");
    }

    @Override
    public boolean cancel(boolean z) {
        this.lock.lock();
        if(this.completed) {
            this.lock.unlock();
            return false;
        }
        try {
            this.completed = true;
            this.cancelled = true;
            FutureCallback futureCallback0 = this.callback;
            if(futureCallback0 != null) {
                futureCallback0.cancelled();
            }
            this.condition.signalAll();
            return true;
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override
    public Object get() {
        try {
            return this.get(0L, TimeUnit.MILLISECONDS);
        }
        catch(TimeoutException timeoutException0) {
            throw new ExecutionException(timeoutException0);
        }
    }

    @Override
    public Object get(long v, TimeUnit timeUnit0) {
        Args.notNull(timeUnit0, "Time unit");
        this.lock.lock();
        try {
            if(!this.completed) {
                this.result = this.getPoolEntry(v, timeUnit0);
                this.completed = true;
                FutureCallback futureCallback0 = this.callback;
                if(futureCallback0 != null) {
                    futureCallback0.completed(this.result);
                }
            }
            return this.result;
        }
        catch(IOException iOException0) {
            this.completed = true;
            this.result = null;
            FutureCallback futureCallback1 = this.callback;
            if(futureCallback1 != null) {
                futureCallback1.failed(iOException0);
            }
            throw new ExecutionException(iOException0);
        }
        finally {
            this.lock.unlock();
        }
    }

    public abstract Object getPoolEntry(long arg1, TimeUnit arg2);

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public boolean isDone() {
        return this.completed;
    }

    public void wakeup() {
        this.lock.lock();
        try {
            this.condition.signalAll();
        }
        finally {
            this.lock.unlock();
        }
    }
}

