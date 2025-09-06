package com.google.android.exoplayer2.source.chunk;

import java.util.NoSuchElementException;

public abstract class BaseMediaChunkIterator implements MediaChunkIterator {
    private long currentIndex;
    private final long fromIndex;
    private final long toIndex;

    public BaseMediaChunkIterator(long v, long v1) {
        this.fromIndex = v;
        this.toIndex = v1;
        this.reset();
    }

    public final void checkInBounds() {
        if(this.currentIndex < this.fromIndex || this.currentIndex > this.toIndex) {
            throw new NoSuchElementException();
        }
    }

    public final long getCurrentIndex() {
        return this.currentIndex;
    }

    @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public boolean isEnded() {
        return this.currentIndex > this.toIndex;
    }

    @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public boolean next() {
        ++this.currentIndex;
        return !this.isEnded();
    }

    @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public void reset() {
        this.currentIndex = this.fromIndex - 1L;
    }
}

