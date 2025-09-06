package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.Timeline;

public abstract class ForwardingTimeline extends Timeline {
    protected final Timeline timeline;

    public ForwardingTimeline(Timeline timeline0) {
        this.timeline = timeline0;
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public int getFirstWindowIndex(boolean z) {
        return this.timeline.getFirstWindowIndex(z);
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(Object object0) {
        return this.timeline.getIndexOfPeriod(object0);
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public int getLastWindowIndex(boolean z) {
        return this.timeline.getLastWindowIndex(z);
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public int getNextWindowIndex(int v, int v1, boolean z) {
        return this.timeline.getNextWindowIndex(v, v1, z);
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public Period getPeriod(int v, Period timeline$Period0, boolean z) {
        return this.timeline.getPeriod(v, timeline$Period0, z);
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return this.timeline.getPeriodCount();
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public int getPreviousWindowIndex(int v, int v1, boolean z) {
        return this.timeline.getPreviousWindowIndex(v, v1, z);
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public Object getUidOfPeriod(int v) {
        return this.timeline.getUidOfPeriod(v);
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public Window getWindow(int v, Window timeline$Window0, long v1) {
        return this.timeline.getWindow(v, timeline$Window0, v1);
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return this.timeline.getWindowCount();
    }
}

