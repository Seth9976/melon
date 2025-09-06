package com.google.android.exoplayer2.source;

public final class d implements Runnable {
    public final int a;
    public final EventDispatcher b;
    public final MediaSourceEventListener c;
    public final LoadEventInfo d;
    public final MediaLoadData e;

    public d(EventDispatcher mediaSourceEventListener$EventDispatcher0, MediaSourceEventListener mediaSourceEventListener0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0, int v) {
        this.a = v;
        this.b = mediaSourceEventListener$EventDispatcher0;
        this.c = mediaSourceEventListener0;
        this.d = mediaSourceEventListener$LoadEventInfo0;
        this.e = mediaSourceEventListener$MediaLoadData0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                this.b.lambda$loadCompleted$3(this.c, this.d, this.e);
                return;
            }
            case 1: {
                this.b.lambda$loadStarted$2(this.c, this.d, this.e);
                return;
            }
            default: {
                this.b.lambda$loadCanceled$4(this.c, this.d, this.e);
            }
        }
    }
}

