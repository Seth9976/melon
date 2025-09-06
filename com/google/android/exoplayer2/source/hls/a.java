package com.google.android.exoplayer2.source.hls;

public final class a implements Runnable {
    public final int a;
    public final Object b;

    public a(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                ((HlsSampleStreamWrapper)this.b).maybeFinishPrepare();
                return;
            }
            case 1: {
                ((HlsSampleStreamWrapper)this.b).onTracksEnded();
                return;
            }
            default: {
                ((Callback)this.b).onPrepared();
            }
        }
    }
}

