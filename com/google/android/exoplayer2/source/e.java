package com.google.android.exoplayer2.source;

public final class e implements Runnable {
    public final int a;
    public final ProgressiveMediaPeriod b;

    public e(ProgressiveMediaPeriod progressiveMediaPeriod0, int v) {
        this.a = v;
        this.b = progressiveMediaPeriod0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.lambda$new$0();
            return;
        }
        this.b.maybeFinishPrepare();
    }
}

