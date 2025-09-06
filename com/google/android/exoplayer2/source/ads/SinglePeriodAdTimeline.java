package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.util.Assertions;

public final class SinglePeriodAdTimeline extends ForwardingTimeline {
    private final AdPlaybackState adPlaybackState;

    public SinglePeriodAdTimeline(Timeline timeline0, AdPlaybackState adPlaybackState0) {
        super(timeline0);
        boolean z = false;
        Assertions.checkState(timeline0.getPeriodCount() == 1);
        if(timeline0.getWindowCount() == 1) {
            z = true;
        }
        Assertions.checkState(z);
        this.adPlaybackState = adPlaybackState0;
    }

    @Override  // com.google.android.exoplayer2.source.ForwardingTimeline
    public Period getPeriod(int v, Period timeline$Period0, boolean z) {
        this.timeline.getPeriod(v, timeline$Period0, z);
        timeline$Period0.set(timeline$Period0.id, timeline$Period0.uid, timeline$Period0.windowIndex, (timeline$Period0.durationUs == 0x8000000000000001L ? this.adPlaybackState.contentDurationUs : timeline$Period0.durationUs), timeline$Period0.getPositionInWindowUs(), this.adPlaybackState);
        return timeline$Period0;
    }
}

