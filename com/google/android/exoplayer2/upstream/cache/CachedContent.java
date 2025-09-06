package com.google.android.exoplayer2.upstream.cache;

import U4.x;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.io.File;
import java.util.TreeSet;

final class CachedContent {
    private static final String TAG = "CachedContent";
    private final TreeSet cachedSpans;
    public final int id;
    public final String key;
    private boolean locked;
    private DefaultContentMetadata metadata;

    public CachedContent(int v, String s) {
        this(v, s, DefaultContentMetadata.EMPTY);
    }

    public CachedContent(int v, String s, DefaultContentMetadata defaultContentMetadata0) {
        this.id = v;
        this.key = s;
        this.metadata = defaultContentMetadata0;
        this.cachedSpans = new TreeSet();
    }

    public void addSpan(SimpleCacheSpan simpleCacheSpan0) {
        this.cachedSpans.add(simpleCacheSpan0);
    }

    public boolean applyMetadataMutations(ContentMetadataMutations contentMetadataMutations0) {
        DefaultContentMetadata defaultContentMetadata0 = this.metadata;
        DefaultContentMetadata defaultContentMetadata1 = defaultContentMetadata0.copyWithMutationsApplied(contentMetadataMutations0);
        this.metadata = defaultContentMetadata1;
        return !defaultContentMetadata1.equals(defaultContentMetadata0);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return CachedContent.class == class0 && this.id == ((CachedContent)object0).id && this.key.equals(((CachedContent)object0).key) && this.cachedSpans.equals(((CachedContent)object0).cachedSpans) && this.metadata.equals(((CachedContent)object0).metadata);
        }
        return false;
    }

    public long getCachedBytesLength(long v, long v1) {
        boolean z = true;
        Assertions.checkArgument(Long.compare(v, 0L) >= 0);
        if(v1 < 0L) {
            z = false;
        }
        Assertions.checkArgument(z);
        SimpleCacheSpan simpleCacheSpan0 = this.getSpan(v);
        long v2 = 0x7FFFFFFFFFFFFFFFL;
        if(simpleCacheSpan0.isHoleSpan()) {
            if(!simpleCacheSpan0.isOpenEnded()) {
                v2 = simpleCacheSpan0.length;
            }
            return -Math.min(v2, v1);
        }
        long v3 = v + v1;
        if(v3 >= 0L) {
            v2 = v3;
        }
        long v4 = simpleCacheSpan0.position + simpleCacheSpan0.length;
        if(v4 < v2) {
            for(Object object0: this.cachedSpans.tailSet(simpleCacheSpan0, false)) {
                long v5 = ((SimpleCacheSpan)object0).position;
                if(v5 > v4) {
                    break;
                }
                v4 = Math.max(v4, v5 + ((SimpleCacheSpan)object0).length);
                if(v4 >= v2) {
                    break;
                }
            }
        }
        return Math.min(v4 - v, v1);
    }

    public DefaultContentMetadata getMetadata() {
        return this.metadata;
    }

    public SimpleCacheSpan getSpan(long v) {
        SimpleCacheSpan simpleCacheSpan0 = SimpleCacheSpan.createLookup(this.key, v);
        SimpleCacheSpan simpleCacheSpan1 = (SimpleCacheSpan)this.cachedSpans.floor(simpleCacheSpan0);
        if(simpleCacheSpan1 != null && simpleCacheSpan1.position + simpleCacheSpan1.length > v) {
            return simpleCacheSpan1;
        }
        SimpleCacheSpan simpleCacheSpan2 = (SimpleCacheSpan)this.cachedSpans.ceiling(simpleCacheSpan0);
        return simpleCacheSpan2 == null ? SimpleCacheSpan.createOpenHole(this.key, v) : SimpleCacheSpan.createClosedHole(this.key, v, simpleCacheSpan2.position - v);
    }

    public TreeSet getSpans() {
        return this.cachedSpans;
    }

    @Override
    public int hashCode() {
        return this.metadata.hashCode() + x.b(this.id * 0x1F, 0x1F, this.key);
    }

    public boolean isEmpty() {
        return this.cachedSpans.isEmpty();
    }

    public boolean isLocked() {
        return this.locked;
    }

    public boolean removeSpan(CacheSpan cacheSpan0) {
        if(this.cachedSpans.remove(cacheSpan0)) {
            cacheSpan0.file.delete();
            return true;
        }
        return false;
    }

    public SimpleCacheSpan setLastTouchTimestamp(SimpleCacheSpan simpleCacheSpan0, long v, boolean z) {
        long v1;
        Assertions.checkState(this.cachedSpans.remove(simpleCacheSpan0));
        File file0 = simpleCacheSpan0.file;
        if(z) {
            v1 = v;
            File file1 = SimpleCacheSpan.getCacheFile(file0.getParentFile(), this.id, simpleCacheSpan0.position, v1);
            if(file0.renameTo(file1)) {
                file0 = file1;
            }
            else {
                Log.w("CachedContent", "Failed to rename " + file0 + " to " + file1);
            }
        }
        else {
            v1 = v;
        }
        SimpleCacheSpan simpleCacheSpan1 = simpleCacheSpan0.copyWithFileAndLastTouchTimestamp(file0, v1);
        this.cachedSpans.add(simpleCacheSpan1);
        return simpleCacheSpan1;
    }

    public void setLocked(boolean z) {
        this.locked = z;
    }
}

