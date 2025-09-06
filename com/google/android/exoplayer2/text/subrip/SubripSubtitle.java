package com.google.android.exoplayer2.text.subrip;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

final class SubripSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final Cue[] cues;

    public SubripSubtitle(Cue[] arr_cue, long[] arr_v) {
        this.cues = arr_cue;
        this.cueTimesUs = arr_v;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public List getCues(long v) {
        int v1 = Util.binarySearchFloor(this.cueTimesUs, v, true, false);
        if(v1 != -1) {
            Cue cue0 = this.cues[v1];
            return cue0 == Cue.EMPTY ? Collections.EMPTY_LIST : Collections.singletonList(cue0);
        }
        return Collections.EMPTY_LIST;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int v) {
        boolean z = false;
        Assertions.checkArgument(v >= 0);
        if(v < this.cueTimesUs.length) {
            z = true;
        }
        Assertions.checkArgument(z);
        return this.cueTimesUs[v];
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.cueTimesUs.length;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long v) {
        int v1 = Util.binarySearchCeil(this.cueTimesUs, v, false, false);
        return v1 >= this.cueTimesUs.length ? -1 : v1;
    }
}

