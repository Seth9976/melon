package com.google.android.gms.internal.location;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class zzfd {
    public static boolean zza(CountDownLatch countDownLatch0, long v, TimeUnit timeUnit0) {
        boolean z1;
        try {
            boolean z = false;
            long v1 = timeUnit0.toNanos(30L);
            long v2 = System.nanoTime() + v1;
            while(true) {
                try {
                    z1 = countDownLatch0.await(v1, TimeUnit.NANOSECONDS);
                    break;
                }
                catch(InterruptedException unused_ex) {
                    z = true;
                    v1 = v2 - System.nanoTime();
                }
            }
        }
        catch(Throwable throwable0) {
            if(z) {
                Thread.currentThread().interrupt();
            }
            throw throwable0;
        }
        if(z) {
            Thread.currentThread().interrupt();
        }
        return z1;
    }
}

