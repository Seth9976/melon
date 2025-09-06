package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public interface LoadErrorHandlingPolicy {
    long getBlacklistDurationMsFor(int arg1, long arg2, IOException arg3, int arg4);

    int getMinimumLoadableRetryCount(int arg1);

    long getRetryDelayMsFor(int arg1, long arg2, IOException arg3, int arg4);
}

