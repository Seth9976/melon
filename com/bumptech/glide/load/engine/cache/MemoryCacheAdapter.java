package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

public class MemoryCacheAdapter implements MemoryCache {
    private ResourceRemovedListener listener;

    @Override  // com.bumptech.glide.load.engine.cache.MemoryCache
    public void clearMemory() {
    }

    @Override  // com.bumptech.glide.load.engine.cache.MemoryCache
    public long getCurrentSize() {
        return 0L;
    }

    @Override  // com.bumptech.glide.load.engine.cache.MemoryCache
    public long getMaxSize() {
        return 0L;
    }

    @Override  // com.bumptech.glide.load.engine.cache.MemoryCache
    public Resource put(Key key0, Resource resource0) {
        if(resource0 != null) {
            this.listener.onResourceRemoved(resource0);
        }
        return null;
    }

    @Override  // com.bumptech.glide.load.engine.cache.MemoryCache
    public Resource remove(Key key0) {
        return null;
    }

    @Override  // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(ResourceRemovedListener memoryCache$ResourceRemovedListener0) {
        this.listener = memoryCache$ResourceRemovedListener0;
    }

    @Override  // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setSizeMultiplier(float f) {
    }

    @Override  // com.bumptech.glide.load.engine.cache.MemoryCache
    public void trimMemory(int v) {
    }
}

