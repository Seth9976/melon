package com.google.android.exoplayer2.upstream.cache;

import E1.a;
import java.util.TreeSet;

public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor {
    private long currentSize;
    private final TreeSet leastRecentlyUsed;
    private final long maxBytes;

    public LeastRecentlyUsedCacheEvictor(long v) {
        this.maxBytes = v;
        this.leastRecentlyUsed = new TreeSet(new a(10));
    }

    private static int compare(CacheSpan cacheSpan0, CacheSpan cacheSpan1) {
        long v = cacheSpan0.lastTouchTimestamp;
        long v1 = cacheSpan1.lastTouchTimestamp;
        if(v - v1 == 0L) {
            return cacheSpan0.compareTo(cacheSpan1);
        }
        return v >= v1 ? 1 : -1;
    }

    private void evictCache(Cache cache0, long v) {
        while(this.currentSize + v > this.maxBytes && !this.leastRecentlyUsed.isEmpty()) {
            try {
                cache0.removeSpan(((CacheSpan)this.leastRecentlyUsed.first()));
            }
            catch(CacheException unused_ex) {
            }
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onCacheInitialized() {
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache$Listener
    public void onSpanAdded(Cache cache0, CacheSpan cacheSpan0) {
        this.leastRecentlyUsed.add(cacheSpan0);
        this.currentSize += cacheSpan0.length;
        this.evictCache(cache0, 0L);
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache$Listener
    public void onSpanRemoved(Cache cache0, CacheSpan cacheSpan0) {
        this.leastRecentlyUsed.remove(cacheSpan0);
        this.currentSize -= cacheSpan0.length;
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache$Listener
    public void onSpanTouched(Cache cache0, CacheSpan cacheSpan0, CacheSpan cacheSpan1) {
        this.onSpanRemoved(cache0, cacheSpan0);
        this.onSpanAdded(cache0, cacheSpan1);
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onStartFile(Cache cache0, String s, long v, long v1) {
        if(v1 != -1L) {
            this.evictCache(cache0, v1);
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public boolean requiresCacheSpanTouches() {
        return true;
    }
}

