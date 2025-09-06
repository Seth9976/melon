package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;

public class LruCache {
    static final class Entry {
        final int size;
        final Object value;

        public Entry(Object object0, int v) {
            this.value = object0;
            this.size = v;
        }
    }

    private final Map cache;
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    public LruCache(long v) {
        this.cache = new LinkedHashMap(100, 0.75f, true);
        this.initialMaxSize = v;
        this.maxSize = v;
    }

    public void clearMemory() {
        this.trimToSize(0L);
    }

    public boolean contains(Object object0) {
        synchronized(this) {
            return this.cache.containsKey(object0);
        }
    }

    private void evict() {
        this.trimToSize(this.maxSize);
    }

    public Object get(Object object0) {
        synchronized(this) {
            Entry lruCache$Entry0 = (Entry)this.cache.get(object0);
            return lruCache$Entry0 == null ? null : lruCache$Entry0.value;
        }
    }

    public int getCount() {
        synchronized(this) {
        }
        return this.cache.size();
    }

    public long getCurrentSize() {
        synchronized(this) {
        }
        return this.currentSize;
    }

    public long getMaxSize() {
        synchronized(this) {
        }
        return this.maxSize;
    }

    public int getSize(Object object0) {
        return 1;
    }

    public void onItemEvicted(Object object0, Object object1) {
    }

    public Object put(Object object0, Object object1) {
        synchronized(this) {
            int v1 = this.getSize(object1);
            Object object2 = null;
            if(Long.compare(v1, this.maxSize) >= 0) {
                this.onItemEvicted(object0, object1);
                return null;
            }
            if(object1 != null) {
                this.currentSize += (long)v1;
            }
            Entry lruCache$Entry0 = object1 == null ? null : new Entry(object1, v1);
            Entry lruCache$Entry1 = (Entry)this.cache.put(object0, lruCache$Entry0);
            if(lruCache$Entry1 != null) {
                this.currentSize -= (long)lruCache$Entry1.size;
                if(!lruCache$Entry1.value.equals(object1)) {
                    this.onItemEvicted(object0, lruCache$Entry1.value);
                }
            }
            this.evict();
            if(lruCache$Entry1 != null) {
                object2 = lruCache$Entry1.value;
            }
            return object2;
        }
    }

    public Object remove(Object object0) {
        synchronized(this) {
            Entry lruCache$Entry0 = (Entry)this.cache.remove(object0);
            if(lruCache$Entry0 == null) {
                return null;
            }
            this.currentSize -= (long)lruCache$Entry0.size;
            return lruCache$Entry0.value;
        }
    }

    public void setSizeMultiplier(float f) {
        synchronized(this) {
            if(f >= 0.0f) {
                this.maxSize = (long)Math.round(((float)this.initialMaxSize) * f);
                this.evict();
                return;
            }
        }
        throw new IllegalArgumentException("Multiplier must be >= 0");
    }

    public void trimToSize(long v) {
        synchronized(this) {
            while(this.currentSize > v) {
                Iterator iterator0 = this.cache.entrySet().iterator();
                Object object0 = iterator0.next();
                Entry lruCache$Entry0 = (Entry)((Map.Entry)object0).getValue();
                this.currentSize -= (long)lruCache$Entry0.size;
                Object object1 = ((Map.Entry)object0).getKey();
                iterator0.remove();
                this.onItemEvicted(object1, lruCache$Entry0.value);
            }
        }
    }
}

