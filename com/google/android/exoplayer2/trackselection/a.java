package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.upstream.BandwidthMeter;

public final class a implements AdaptiveTrackSelectionFactory {
    public final com.google.android.exoplayer2.trackselection.BufferSizeAdaptationBuilder.1 a;
    public final BandwidthMeter b;

    public a(com.google.android.exoplayer2.trackselection.BufferSizeAdaptationBuilder.1 bufferSizeAdaptationBuilder$10, BandwidthMeter bandwidthMeter0) {
        this.a = bufferSizeAdaptationBuilder$10;
        this.b = bandwidthMeter0;
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelectionUtil$AdaptiveTrackSelectionFactory
    public final TrackSelection createAdaptiveTrackSelection(Definition trackSelection$Definition0) {
        return this.a.lambda$createTrackSelections$0(this.b, trackSelection$Definition0);
    }
}

