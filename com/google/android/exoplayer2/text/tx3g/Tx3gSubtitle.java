package com.google.android.exoplayer2.text.tx3g;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

final class Tx3gSubtitle implements Subtitle {
    public static final Tx3gSubtitle EMPTY;
    private final List cues;

    static {
        Tx3gSubtitle.EMPTY = new Tx3gSubtitle();
    }

    private Tx3gSubtitle() {
        this.cues = Collections.EMPTY_LIST;
    }

    public Tx3gSubtitle(Cue cue0) {
        this.cues = Collections.singletonList(cue0);
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

