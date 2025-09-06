package com.google.android.exoplayer2.text.ssa;

import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

final class SsaSubtitle implements Subtitle {
    private final List cueTimesUs;
    private final List cues;

    public SsaSubtitle(List list0, List list1) {
        this.cues = list0;
        this.cueTimesUs = list1;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public List getCues(long v) {
        int v1 = Util.binarySearchFloor(this.cueTimesUs, v, true, false);
        return v1 == -1 ? Collections.EMPTY_LIST : ((List)this.cues.get(v1));
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int v) {
        boolean z = false;
        Assertions.checkArgument(v >= 0);
        if(v < this.cueTimesUs.size()) {
            z = true;
        }
        Assertions.checkArgument(z);
        return (long)(((Long)this.cueTimesUs.get(v)));
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.cueTimesUs.size();
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long v) {
        int v1 = Util.binarySearchCeil(this.cueTimesUs, v, false, false);
        return v1 >= this.cueTimesUs.size() ? -1 : v1;
    }
}

