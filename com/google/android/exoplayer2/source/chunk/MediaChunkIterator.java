package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.NoSuchElementException;

public interface MediaChunkIterator {
    public static final MediaChunkIterator EMPTY;

    static {
        MediaChunkIterator.EMPTY = new MediaChunkIterator() {
            @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
            public long getChunkEndTimeUs() {
                throw new NoSuchElementException();
            }

            @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
            public long getChunkStartTimeUs() {
                throw new NoSuchElementException();
            }

            @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
            public DataSpec getDataSpec() {
                throw new NoSuchElementException();
            }

            @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
            public boolean isEnded() {
                return true;
            }

            @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
            public boolean next() {
                return false;
            }

            @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
            public void reset() {
            }
        };
    }

    long getChunkEndTimeUs();

    long getChunkStartTimeUs();

    DataSpec getDataSpec();

    boolean isEnded();

    boolean next();

    void reset();
}

