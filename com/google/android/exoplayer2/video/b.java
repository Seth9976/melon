package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.decoder.DecoderCounters;

public final class b implements Runnable {
    public final int a;
    public final EventDispatcher b;
    public final DecoderCounters c;

    public b(EventDispatcher videoRendererEventListener$EventDispatcher0, DecoderCounters decoderCounters0, int v) {
        this.a = v;
        this.b = videoRendererEventListener$EventDispatcher0;
        this.c = decoderCounters0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
        }
    }
}

