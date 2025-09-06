package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class DefaultClock implements Clock {
    private static final DefaultClock zza;

    static {
        DefaultClock.zza = new DefaultClock();
    }

    @Override  // com.google.android.gms.common.util.Clock
    public final long currentThreadTimeMillis() {
        return SystemClock.currentThreadTimeMillis();
    }

    @Override  // com.google.android.gms.common.util.Clock
    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override  // com.google.android.gms.common.util.Clock
    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @KeepForSdk
    public static Clock getInstance() {
        return DefaultClock.zza;
    }

    @Override  // com.google.android.gms.common.util.Clock
    public final long nanoTime() {
        return System.nanoTime();
    }
}

