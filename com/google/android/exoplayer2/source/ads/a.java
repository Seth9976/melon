package com.google.android.exoplayer2.source.ads;

import java.io.IOException;

public final class a implements Runnable {
    public final int a;
    public final Object b;
    public final Object c;

    public a(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    public a(ComponentListener adsMediaSource$ComponentListener0, AdPlaybackState adPlaybackState0) {
        this.a = 2;
        super();
        this.c = adsMediaSource$ComponentListener0;
        this.b = adPlaybackState0;
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                ((AdsMediaSource)this.b).lambda$prepareSourceInternal$0(((ComponentListener)this.c));
                return;
            }
            case 1: {
                AdPrepareErrorListener.a(((AdPrepareErrorListener)this.b), ((IOException)this.c));
                return;
            }
            default: {
                ComponentListener.a(((ComponentListener)this.c), ((AdPlaybackState)this.b));
            }
        }
    }
}

