package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.List;

public final class MediaChunkListIterator extends BaseMediaChunkIterator {
    private final List chunks;
    private final boolean reverseOrder;

    public MediaChunkListIterator(List list0, boolean z) {
        super(0L, ((long)(list0.size() - 1)));
        this.chunks = list0;
        this.reverseOrder = z;
    }

    @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public long getChunkEndTimeUs() {
        return this.getCurrentChunk().endTimeUs;
    }

    @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public long getChunkStartTimeUs() {
        return this.getCurrentChunk().startTimeUs;
    }

    // 去混淆评级： 低(20)
    private MediaChunk getCurrentChunk() {
        return (MediaChunk)this.chunks.get((this.reverseOrder ? this.chunks.size() - 1 - ((int)this.getCurrentIndex()) : ((int)this.getCurrentIndex())));
    }

    @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public DataSpec getDataSpec() {
        return this.getCurrentChunk().dataSpec;
    }
}

