package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public final class CachedRegionTracker implements Listener {
    static class Region implements Comparable {
        public long endOffset;
        public int endOffsetIndex;
        public long startOffset;

        public Region(long v, long v1) {
            this.startOffset = v;
            this.endOffset = v1;
        }

        public int compareTo(Region cachedRegionTracker$Region0) {
            return Util.compareLong(this.startOffset, cachedRegionTracker$Region0.startOffset);
        }

        @Override
        public int compareTo(Object object0) {
            return this.compareTo(((Region)object0));
        }
    }

    public static final int CACHED_TO_END = -2;
    public static final int NOT_CACHED = -1;
    private static final String TAG = "CachedRegionTracker";
    private final Cache cache;
    private final String cacheKey;
    private final ChunkIndex chunkIndex;
    private final Region lookupRegion;
    private final TreeSet regions;

    public CachedRegionTracker(Cache cache0, String s, ChunkIndex chunkIndex0) {
        this.cache = cache0;
        this.cacheKey = s;
        this.chunkIndex = chunkIndex0;
        this.regions = new TreeSet();
        this.lookupRegion = new Region(0L, 0L);
        synchronized(this) {
            Iterator iterator0 = cache0.addListener(s, this).descendingIterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                this.mergeSpan(((CacheSpan)object0));
            }
        }
    }

    public int getRegionEndTimeMs(long v) {
        synchronized(this) {
            this.lookupRegion.startOffset = v;
            Region cachedRegionTracker$Region0 = (Region)this.regions.floor(this.lookupRegion);
            if(cachedRegionTracker$Region0 != null) {
                long v2 = cachedRegionTracker$Region0.endOffset;
                if(v <= v2) {
                    int v3 = cachedRegionTracker$Region0.endOffsetIndex;
                    if(v3 != -1) {
                        ChunkIndex chunkIndex0 = this.chunkIndex;
                        return v3 == chunkIndex0.length - 1 && v2 == chunkIndex0.offsets[v3] + ((long)chunkIndex0.sizes[v3]) ? -2 : (chunkIndex0.timesUs[v3] + (v2 - chunkIndex0.offsets[v3]) * chunkIndex0.durationsUs[v3] / ((long)chunkIndex0.sizes[v3])) / 1000L;
                    }
                }
            }
            return -1;
        }
    }

    private void mergeSpan(CacheSpan cacheSpan0) {
        Region cachedRegionTracker$Region0 = new Region(cacheSpan0.position, cacheSpan0.length + cacheSpan0.position);
        Region cachedRegionTracker$Region1 = (Region)this.regions.floor(cachedRegionTracker$Region0);
        Region cachedRegionTracker$Region2 = (Region)this.regions.ceiling(cachedRegionTracker$Region0);
        boolean z = this.regionsConnect(cachedRegionTracker$Region1, cachedRegionTracker$Region0);
        if(this.regionsConnect(cachedRegionTracker$Region0, cachedRegionTracker$Region2)) {
            if(z) {
                cachedRegionTracker$Region1.endOffset = cachedRegionTracker$Region2.endOffset;
                cachedRegionTracker$Region1.endOffsetIndex = cachedRegionTracker$Region2.endOffsetIndex;
            }
            else {
                cachedRegionTracker$Region0.endOffset = cachedRegionTracker$Region2.endOffset;
                cachedRegionTracker$Region0.endOffsetIndex = cachedRegionTracker$Region2.endOffsetIndex;
                this.regions.add(cachedRegionTracker$Region0);
            }
            this.regions.remove(cachedRegionTracker$Region2);
            return;
        }
        if(z) {
            cachedRegionTracker$Region1.endOffset = cachedRegionTracker$Region0.endOffset;
            int v;
            for(v = cachedRegionTracker$Region1.endOffsetIndex; v < this.chunkIndex.length - 1 && this.chunkIndex.offsets[v + 1] <= cachedRegionTracker$Region1.endOffset; ++v) {
            }
            cachedRegionTracker$Region1.endOffsetIndex = v;
            return;
        }
        int v1 = Arrays.binarySearch(this.chunkIndex.offsets, cachedRegionTracker$Region0.endOffset);
        if(v1 < 0) {
            v1 = -v1 - 2;
        }
        cachedRegionTracker$Region0.endOffsetIndex = v1;
        this.regions.add(cachedRegionTracker$Region0);
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache$Listener
    public void onSpanAdded(Cache cache0, CacheSpan cacheSpan0) {
        synchronized(this) {
            this.mergeSpan(cacheSpan0);
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache$Listener
    public void onSpanRemoved(Cache cache0, CacheSpan cacheSpan0) {
        synchronized(this) {
            Region cachedRegionTracker$Region0 = new Region(cacheSpan0.position, cacheSpan0.length + cacheSpan0.position);
            Region cachedRegionTracker$Region1 = (Region)this.regions.floor(cachedRegionTracker$Region0);
            if(cachedRegionTracker$Region1 == null) {
                Log.e("CachedRegionTracker", "Removed a span we were not aware of");
                return;
            }
            this.regions.remove(cachedRegionTracker$Region1);
            long v1 = cachedRegionTracker$Region1.startOffset;
            long v2 = cachedRegionTracker$Region0.startOffset;
            if(v1 < v2) {
                Region cachedRegionTracker$Region2 = new Region(v1, v2);
                int v3 = Arrays.binarySearch(this.chunkIndex.offsets, cachedRegionTracker$Region2.endOffset);
                if(v3 < 0) {
                    v3 = -v3 - 2;
                }
                cachedRegionTracker$Region2.endOffsetIndex = v3;
                this.regions.add(cachedRegionTracker$Region2);
            }
            long v4 = cachedRegionTracker$Region1.endOffset;
            long v5 = cachedRegionTracker$Region0.endOffset;
            if(v4 > v5) {
                Region cachedRegionTracker$Region3 = new Region(v5 + 1L, v4);
                cachedRegionTracker$Region3.endOffsetIndex = cachedRegionTracker$Region1.endOffsetIndex;
                this.regions.add(cachedRegionTracker$Region3);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.Cache$Listener
    public void onSpanTouched(Cache cache0, CacheSpan cacheSpan0, CacheSpan cacheSpan1) {
    }

    private boolean regionsConnect(Region cachedRegionTracker$Region0, Region cachedRegionTracker$Region1) {
        return cachedRegionTracker$Region0 != null && cachedRegionTracker$Region1 != null && cachedRegionTracker$Region0.endOffset == cachedRegionTracker$Region1.startOffset;
    }

    public void release() {
        this.cache.removeListener(this.cacheKey, this);
    }
}

