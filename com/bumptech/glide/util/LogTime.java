package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.SystemClock;

public final class LogTime {
    private static final double MILLIS_MULTIPLIER;

    static {
        LogTime.MILLIS_MULTIPLIER = 0.000001;
    }

    public static double getElapsedMillis(long v) {
        return ((double)(LogTime.getLogTime() - v)) * LogTime.MILLIS_MULTIPLIER;
    }

    @TargetApi(17)
    public static long getLogTime() {
        return SystemClock.elapsedRealtimeNanos();
    }
}

