package com.google.android.gms.internal.cast;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzvt extends zzvq implements zzvp, AutoCloseable, ScheduledExecutorService {
    final ScheduledExecutorService zza;

    public zzvt(ScheduledExecutorService scheduledExecutorService0) {
        super(scheduledExecutorService0);
        scheduledExecutorService0.getClass();
        this.zza = scheduledExecutorService0;
    }

    @Override  // com.google.android.gms.internal.cast.zzvd
    public final void close() {
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
    public final ScheduledFuture schedule(Runnable runnable0, long v, TimeUnit timeUnit0) {
        zzvx zzvx0 = zzvx.zzo(runnable0, null);
        return new zzvr(zzvx0, this.zza.schedule(zzvx0, v, timeUnit0));
    }

    @Override
    public final ScheduledFuture schedule(Callable callable0, long v, TimeUnit timeUnit0) {
        zzvx zzvx0 = new zzvx(callable0);
        return new zzvr(zzvx0, this.zza.schedule(zzvx0, v, timeUnit0));
    }

    @Override
    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        zzvs zzvs0 = new zzvs(runnable0);
        return new zzvr(zzvs0, this.zza.scheduleAtFixedRate(zzvs0, v, v1, timeUnit0));
    }

    @Override
    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        zzvs zzvs0 = new zzvs(runnable0);
        return new zzvr(zzvs0, this.zza.scheduleWithFixedDelay(zzvs0, v, v1, timeUnit0));
    }
}

