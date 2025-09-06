package com.google.android.exoplayer2.upstream.cache;

public final class NoOpCacheEvictor implements CacheEvictor {
    @Override  // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onCacheInitialized() {
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache$Listener
    public void onSpanAdded(Cache cache0, CacheSpan cacheSpan0) {
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache$Listener
    public void onSpanRemoved(Cache cache0, CacheSpan cacheSpan0) {
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache$Listener
    public void onSpanTouched(Cache cache0, CacheSpan cacheSpan0, CacheSpan cacheSpan1) {
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onStartFile(Cache cache0, String s, long v, long v1) {
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public boolean requiresCacheSpanTouches() {
        return false;
    }
}

