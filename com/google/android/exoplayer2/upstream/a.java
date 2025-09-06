package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.EventDispatcher.Event;

public final class a implements Event {
    public final int a;
    public final long b;
    public final long c;

    public a(int v, long v1, long v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
    }

    @Override  // com.google.android.exoplayer2.util.EventDispatcher$Event
    public final void sendTo(Object object0) {
        DefaultBandwidthMeter.lambda$maybeNotifyBandwidthSample$0(this.a, this.b, this.c, ((EventListener)object0));
    }
}

