package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.decoder.DecoderCounters;

public final class b implements Runnable {
    public final int a;
    public final EventDispatcher b;
    public final DecoderCounters c;

    public b(EventDispatcher audioRendererEventListener$EventDispatcher0, DecoderCounters decoderCounters0, int v) {
        this.a = v;
        this.b = audioRendererEventListener$EventDispatcher0;
        this.c = decoderCounters0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
        }
    }
}

