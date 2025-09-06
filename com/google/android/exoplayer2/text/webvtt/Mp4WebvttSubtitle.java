package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

final class Mp4WebvttSubtitle implements Subtitle {
    private final List cues;

    public Mp4WebvttSubtitle(List list0) {
        this.cues = Collections.unmodifiableList(list0);
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public List getCues(long v) {
        return v < 0L ? Collections.EMPTY_LIST : this.cues;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int v) {
        Assertions.checkArgument(v == 0);
        return 0L;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long v) {
        return v >= 0L ? -1 : 0;
    }
}

