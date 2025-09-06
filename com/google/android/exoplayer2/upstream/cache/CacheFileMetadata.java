package com.google.android.exoplayer2.upstream.cache;

final class CacheFileMetadata {
    public final long lastTouchTimestamp;
    public final long length;

    public CacheFileMetadata(long v, long v1) {
        this.length = v;
        this.lastTouchTimestamp = v1;
    }
}

