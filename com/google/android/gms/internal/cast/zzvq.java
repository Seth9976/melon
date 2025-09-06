package com.google.android.gms.internal.cast;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class zzvq extends zzvd {
    private final ExecutorService zza;

    public zzvq(ExecutorService executorService0) {
        executorService0.getClass();
        this.zza = executorService0;
    }

    @Override
    public final boolean awaitTermination(long v, TimeUnit timeUnit0) {
        return this.zza.awaitTermination(v, timeUnit0);
    }

    @Override
    public final void execute(Runnable runnable0) {
        this.zza.execute(runnable0);
    }

    @Override
    public final boolean isShutdown() {
        return this.zza.isShutdown();
    }

    @Override
    public final boolean isTerminated() {
        return this.zza.isTerminated();
    }

    @Override
    public final void shutdown() {
        this.zza.shutdown();
    }

    @Override
    public final List shutdownNow() {
        return this.zza.shutdownNow();
    }

    @Override
    public final String toString() {
        return super.toString() + "[" + this.zza + "]";
    }
}

