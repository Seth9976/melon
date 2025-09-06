package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class TimestampAdjusterProvider {
    private final SparseArray timestampAdjusters;

    public TimestampAdjusterProvider() {
        this.timestampAdjusters = new SparseArray();
    }

    public TimestampAdjuster getAdjuster(int v) {
        TimestampAdjuster timestampAdjuster0 = (TimestampAdjuster)this.timestampAdjusters.get(v);
        if(timestampAdjuster0 == null) {
            timestampAdjuster0 = new TimestampAdjuster(0x7FFFFFFFFFFFFFFFL);
            this.timestampAdjusters.put(v, timestampAdjuster0);
        }
        return timestampAdjuster0;
    }

    public void reset() {
        this.timestampAdjusters.clear();
    }
}

