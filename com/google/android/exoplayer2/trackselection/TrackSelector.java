package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;

public abstract class TrackSelector {
    public interface InvalidationListener {
        void onTrackSelectionsInvalidated();
    }

    private BandwidthMeter bandwidthMeter;
    private InvalidationListener listener;

    public final BandwidthMeter getBandwidthMeter() {
        return (BandwidthMeter)Assertions.checkNotNull(this.bandwidthMeter);
    }

    public final void init(InvalidationListener trackSelector$InvalidationListener0, BandwidthMeter bandwidthMeter0) {
        this.listener = trackSelector$InvalidationListener0;
        this.bandwidthMeter = bandwidthMeter0;
    }

    public final void invalidate() {
        InvalidationListener trackSelector$InvalidationListener0 = this.listener;
        if(trackSelector$InvalidationListener0 != null) {
            trackSelector$InvalidationListener0.onTrackSelectionsInvalidated();
        }
    }

    public abstract void onSelectionActivated(Object arg1);

    public abstract TrackSelectorResult selectTracks(RendererCapabilities[] arg1, TrackGroupArray arg2, MediaPeriodId arg3, Timeline arg4);
}

