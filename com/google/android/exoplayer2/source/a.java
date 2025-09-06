package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;

public final class a implements MediaSourceCaller {
    public final CompositeMediaSource a;
    public final Object b;

    public a(CompositeMediaSource compositeMediaSource0, Object object0) {
        this.a = compositeMediaSource0;
        this.b = object0;
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller
    public final void onSourceInfoRefreshed(MediaSource mediaSource0, Timeline timeline0) {
        this.a.lambda$prepareChildSource$0(this.b, mediaSource0, timeline0);
    }
}

