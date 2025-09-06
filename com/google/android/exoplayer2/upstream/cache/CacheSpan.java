package com.google.android.exoplayer2.upstream.cache;

import java.io.File;

public class CacheSpan implements Comparable {
    public final File file;
    public final boolean isCached;
    public final String key;
    public final long lastTouchTimestamp;
    public final long length;
    public final long position;

    public CacheSpan(String s, long v, long v1) {
        this(s, v, v1, 0x8000000000000001L, null);
    }

    public CacheSpan(String s, long v, long v1, long v2, File file0) {
        this.key = s;
        this.position = v;
        this.length = v1;
        this.isCached = file0 != null;
        this.file = file0;
        this.lastTouchTimestamp = v2;
    }

    public int compareTo(CacheSpan cacheSpan0) {
        if(!this.key.equals(cacheSpan0.key)) {
            return this.key.compareTo(cacheSpan0.key);
        }
        int v = Long.compare(this.position - cacheSpan0.position, 0L);
        if(v == 0) {
            return 0;
        }
        return v >= 0 ? 1 : -1;
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((CacheSpan)object0));
    }

    public boolean isHoleSpan() {
        return !this.isCached;
    }

    public boolean isOpenEnded() {
        return this.length == -1L;
    }
}

