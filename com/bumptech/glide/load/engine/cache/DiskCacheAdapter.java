package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.io.File;

public class DiskCacheAdapter implements DiskCache {
    public static final class Factory implements com.bumptech.glide.load.engine.cache.DiskCache.Factory {
        @Override  // com.bumptech.glide.load.engine.cache.DiskCache$Factory
        public DiskCache build() {
            return new DiskCacheAdapter();
        }
    }

    @Override  // com.bumptech.glide.load.engine.cache.DiskCache
    public void clear() {
    }

    @Override  // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key0) {
    }

    @Override  // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key key0) {
        return null;
    }

    @Override  // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key key0, Writer diskCache$Writer0) {
    }
}

