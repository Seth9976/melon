package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LruCache;

public class LruResourceCache extends LruCache implements MemoryCache {
    private ResourceRemovedListener listener;

    public LruResourceCache(long v) {
        super(v);
    }

    public int getSize(Resource resource0) {
        return resource0 == null ? super.getSize(null) : resource0.getSize();
    }

    @Override  // com.bumptech.glide.util.LruCache
    public int getSize(Object object0) {
        return this.getSize(((Resource)object0));
    }

    public void onItemEvicted(Key key0, Resource resource0) {
        ResourceRemovedListener memoryCache$ResourceRemovedListener0 = this.listener;
        if(memoryCache$ResourceRemovedListener0 != null && resource0 != null) {
            memoryCache$ResourceRemovedListener0.onResourceRemoved(resource0);
        }
    }

    @Override  // com.bumptech.glide.util.LruCache
    public void onItemEvicted(Object object0, Object object1) {
        this.onItemEvicted(((Key)object0), ((Resource)object1));
    }

    @Override  // com.bumptech.glide.load.engine.cache.MemoryCache
    public Resource put(Key key0, Resource resource0) {
        return (Resource)super.put(key0, resource0);
    }

    @Override  // com.bumptech.glide.load.engine.cache.MemoryCache
    public Resource remove(Key key0) {
        return (Resource)super.remove(key0);
    }

    @Override  // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(ResourceRemovedListener memoryCache$ResourceRemovedListener0) {
        this.listener = memoryCache$ResourceRemovedListener0;
    }

    @Override  // com.bumptech.glide.load.engine.cache.MemoryCache
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int v) {
        if(v >= 40) {
            this.clearMemory();
            return;
        }
        if(v < 20 && v != 15) {
            return;
        }
        this.trimToSize(this.getMaxSize() / 2L);
    }
}

