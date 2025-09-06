package com.google.android.exoplayer2.text.pgs;

import com.google.android.exoplayer2.text.Subtitle;
import java.util.List;

final class PgsSubtitle implements Subtitle {
    private final List cues;

    public PgsSubtitle(List list0) {
        this.cues = list0;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public List getCues(long v) {
        return this.cues;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int v) {
        return 0L;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long v) {
        return -1;
    }
}

