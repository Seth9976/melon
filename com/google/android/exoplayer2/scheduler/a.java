package com.google.android.exoplayer2.scheduler;

public final class a implements Runnable {
    public final int a;
    public final NetworkCallback b;

    public a(NetworkCallback requirementsWatcher$NetworkCallback0, int v) {
        this.a = v;
        this.b = requirementsWatcher$NetworkCallback0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            NetworkCallback.a(this.b);
            return;
        }
        NetworkCallback.b(this.b);
    }
}

