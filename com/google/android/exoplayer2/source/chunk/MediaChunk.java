package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;

public abstract class MediaChunk extends Chunk {
    public final long chunkIndex;

    public MediaChunk(DataSource dataSource0, DataSpec dataSpec0, Format format0, int v, Object object0, long v1, long v2, long v3) {
        super(dataSource0, dataSpec0, 1, format0, v, object0, v1, v2);
        Assertions.checkNotNull(format0);
        this.chunkIndex = v3;
    }

    public long getNextChunkIndex() {
        return this.chunkIndex == -1L ? -1L : this.chunkIndex + 1L;
    }

    public abstract boolean isLoadCompleted();
}

