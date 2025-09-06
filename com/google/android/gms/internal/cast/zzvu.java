package com.google.android.gms.internal.cast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class zzvu {
    public static zzvp zza(ExecutorService executorService0) {
        if(executorService0 instanceof zzvp) {
            return (zzvp)executorService0;
        }
        return executorService0 instanceof ScheduledExecutorService ? new zzvt(((ScheduledExecutorService)executorService0)) : new zzvq(executorService0);
    }
}

