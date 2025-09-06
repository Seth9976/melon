package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;

public abstract class BaseMediaChunk extends MediaChunk {
    public final long clippedEndTimeUs;
    public final long clippedStartTimeUs;
    private int[] firstSampleIndices;
    private BaseMediaChunkOutput output;

    public BaseMediaChunk(DataSource dataSource0, DataSpec dataSpec0, Format format0, int v, Object object0, long v1, long v2, long v3, long v4, long v5) {
        super(dataSource0, dataSpec0, format0, v, object0, v1, v2, v5);
        this.clippedStartTimeUs = v3;
        this.clippedEndTimeUs = v4;
    }

    public final int getFirstSampleIndex(int v) {
        return this.firstSampleIndices[v];
    }

    public final BaseMediaChunkOutput getOutput() {
        return this.output;
    }

    public void init(BaseMediaChunkOutput baseMediaChunkOutput0) {
        this.output = baseMediaChunkOutput0;
        this.firstSampleIndices = baseMediaChunkOutput0.getWriteIndices();
    }
}

