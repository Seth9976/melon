package com.google.android.exoplayer2.source;

public final class c implements Runnable {
    public final int a;
    public final EventDispatcher b;
    public final MediaSourceEventListener c;
    public final MediaPeriodId d;

    public c(EventDispatcher mediaSourceEventListener$EventDispatcher0, MediaSourceEventListener mediaSourceEventListener0, MediaPeriodId mediaSource$MediaPeriodId0, int v) {
        this.a = v;
        this.b = mediaSourceEventListener$EventDispatcher0;
        this.c = mediaSourceEventListener0;
        this.d = mediaSource$MediaPeriodId0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                this.b.lambda$mediaPeriodReleased$1(this.c, this.d);
                return;
            }
            case 1: {
                this.b.lambda$readingStarted$6(this.c, this.d);
                return;
            }
            default: {
                this.b.lambda$mediaPeriodCreated$0(this.c, this.d);
            }
        }
    }
}

