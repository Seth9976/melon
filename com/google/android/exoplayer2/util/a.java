package com.google.android.exoplayer2.util;

public final class a implements Runnable {
    public final HandlerAndListener a;
    public final Event b;

    public a(HandlerAndListener eventDispatcher$HandlerAndListener0, Event eventDispatcher$Event0) {
        this.a = eventDispatcher$HandlerAndListener0;
        this.b = eventDispatcher$Event0;
    }

    @Override
    public final void run() {
        this.a.lambda$dispatch$0(this.b);
    }
}

