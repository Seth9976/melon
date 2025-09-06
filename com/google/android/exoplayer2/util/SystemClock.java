package com.google.android.exoplayer2.util;

import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;

public class SystemClock implements Clock {
    @Override  // com.google.android.exoplayer2.util.Clock
    public HandlerWrapper createHandler(Looper looper0, Handler.Callback handler$Callback0) {
        return new SystemHandlerWrapper(new Handler(looper0, handler$Callback0));
    }

    @Override  // com.google.android.exoplayer2.util.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override  // com.google.android.exoplayer2.util.Clock
    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    @Override  // com.google.android.exoplayer2.util.Clock
    public void sleep(long v) {
        android.os.SystemClock.sleep(v);
    }

    @Override  // com.google.android.exoplayer2.util.Clock
    public long uptimeMillis() {
        return android.os.SystemClock.uptimeMillis();
    }
}

