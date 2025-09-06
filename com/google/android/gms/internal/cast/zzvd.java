package com.google.android.gms.internal.cast;

import M6.B;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

public abstract class zzvd extends AbstractExecutorService implements zzvp, AutoCloseable {
    @Override
    public void close() {
        if(this != ForkJoinPool.commonPool() && !this.isTerminated()) {
            this.shutdown();
            boolean z1 = false;
            for(boolean z = false; !z; z = this.awaitTermination(1L, TimeUnit.DAYS)) {
                try {
                }
                catch(InterruptedException unused_ex) {
                    if(!z1) {
                        this.shutdownNow();
                    }
                    z1 = true;
                }
            }
            if(z1) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public final RunnableFuture newTaskFor(Runnable runnable0, Object object0) {
        return zzvx.zzo(runnable0, object0);
    }

    @Override
    public final RunnableFuture newTaskFor(Callable callable0) {
        return new zzvx(callable0);
    }

    @Override
    public final Future submit(Runnable runnable0) {
        return (B)super.submit(runnable0);
    }

    @Override
    public final Future submit(Runnable runnable0, Object object0) {
        return (B)super.submit(runnable0, object0);
    }

    @Override
    public final Future submit(Callable callable0) {
        return (B)super.submit(callable0);
    }
}

