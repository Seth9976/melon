package com.google.android.gms.internal.cast;

import M6.B;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzvr extends zzvh implements ScheduledFuture {
    private final ScheduledFuture zza;

    public zzvr(B b0, ScheduledFuture scheduledFuture0) {
        super(b0);
        this.zza = scheduledFuture0;
    }

    @Override  // com.google.android.gms.internal.cast.zzvg
    public final boolean cancel(boolean z) {
        boolean z1 = this.zzb().cancel(z);
        if(z1) {
            this.zza.cancel(z);
        }
        return z1;
    }

    @Override
    public final int compareTo(Object object0) {
        return this.zza.compareTo(((Delayed)object0));
    }

    @Override
    public final long getDelay(TimeUnit timeUnit0) {
        return this.zza.getDelay(timeUnit0);
    }
}

