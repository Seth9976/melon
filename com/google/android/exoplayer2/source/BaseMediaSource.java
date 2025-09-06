package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class BaseMediaSource implements MediaSource {
    private final HashSet enabledMediaSourceCallers;
    private final EventDispatcher eventDispatcher;
    private Looper looper;
    private final ArrayList mediaSourceCallers;
    private Timeline timeline;

    public BaseMediaSource() {
        this.mediaSourceCallers = new ArrayList(1);
        this.enabledMediaSourceCallers = new HashSet(1);
        this.eventDispatcher = new EventDispatcher();
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public final void addEventListener(Handler handler0, MediaSourceEventListener mediaSourceEventListener0) {
        this.eventDispatcher.addEventListener(handler0, mediaSourceEventListener0);
    }

    public final EventDispatcher createEventDispatcher(int v, MediaPeriodId mediaSource$MediaPeriodId0, long v1) {
        return this.eventDispatcher.withParameters(v, mediaSource$MediaPeriodId0, v1);
    }

    public final EventDispatcher createEventDispatcher(MediaPeriodId mediaSource$MediaPeriodId0) {
        return this.eventDispatcher.withParameters(0, mediaSource$MediaPeriodId0, 0L);
    }

    public final EventDispatcher createEventDispatcher(MediaPeriodId mediaSource$MediaPeriodId0, long v) {
        Assertions.checkArgument(mediaSource$MediaPeriodId0 != null);
        return this.eventDispatcher.withParameters(0, mediaSource$MediaPeriodId0, v);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public final void disable(MediaSourceCaller mediaSource$MediaSourceCaller0) {
        this.enabledMediaSourceCallers.remove(mediaSource$MediaSourceCaller0);
        if(!this.enabledMediaSourceCallers.isEmpty() && this.enabledMediaSourceCallers.isEmpty()) {
            this.disableInternal();
        }
    }

    public void disableInternal() {
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public final void enable(MediaSourceCaller mediaSource$MediaSourceCaller0) {
        Assertions.checkNotNull(this.looper);
        this.enabledMediaSourceCallers.add(mediaSource$MediaSourceCaller0);
        if(this.enabledMediaSourceCallers.isEmpty()) {
            this.enableInternal();
        }
    }

    public void enableInternal() {
    }

    public final boolean isEnabled() {
        return !this.enabledMediaSourceCallers.isEmpty();
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public final void prepareSource(MediaSourceCaller mediaSource$MediaSourceCaller0, TransferListener transferListener0) {
        Looper looper0 = Looper.myLooper();
        Assertions.checkArgument(this.looper == null || this.looper == looper0);
        Timeline timeline0 = this.timeline;
        this.mediaSourceCallers.add(mediaSource$MediaSourceCaller0);
        if(this.looper == null) {
            this.looper = looper0;
            this.enabledMediaSourceCallers.add(mediaSource$MediaSourceCaller0);
            this.prepareSourceInternal(transferListener0);
            return;
        }
        if(timeline0 != null) {
            this.enable(mediaSource$MediaSourceCaller0);
            mediaSource$MediaSourceCaller0.onSourceInfoRefreshed(this, timeline0);
        }
    }

    public abstract void prepareSourceInternal(TransferListener arg1);

    public final void refreshSourceInfo(Timeline timeline0) {
        this.timeline = timeline0;
        for(Object object0: this.mediaSourceCallers) {
            ((MediaSourceCaller)object0).onSourceInfoRefreshed(this, timeline0);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public final void releaseSource(MediaSourceCaller mediaSource$MediaSourceCaller0) {
        this.mediaSourceCallers.remove(mediaSource$MediaSourceCaller0);
        if(this.mediaSourceCallers.isEmpty()) {
            this.looper = null;
            this.timeline = null;
            this.enabledMediaSourceCallers.clear();
            this.releaseSourceInternal();
            return;
        }
        this.disable(mediaSource$MediaSourceCaller0);
    }

    public abstract void releaseSourceInternal();

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public final void removeEventListener(MediaSourceEventListener mediaSourceEventListener0) {
        this.eventDispatcher.removeEventListener(mediaSourceEventListener0);
    }
}

