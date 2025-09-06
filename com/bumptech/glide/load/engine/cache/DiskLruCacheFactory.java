package com.bumptech.glide.load.engine.cache;

import java.io.File;

public class DiskLruCacheFactory implements Factory {
    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    private final CacheDirectoryGetter cacheDirectoryGetter;
    private final long diskCacheSize;

    public DiskLruCacheFactory(CacheDirectoryGetter diskLruCacheFactory$CacheDirectoryGetter0, long v) {
        this.diskCacheSize = v;
        this.cacheDirectoryGetter = diskLruCacheFactory$CacheDirectoryGetter0;
    }

    public DiskLruCacheFactory(String s, long v) {
        this(new CacheDirectoryGetter() {
            @Override  // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$CacheDirectoryGetter
            public File getCacheDirectory() {
                return new File(this.val$diskCacheFolder);
            }
        }, v);
    }

    public DiskLruCacheFactory(String s, String s1, long v) {
        this(new CacheDirectoryGetter() {
            @Override  // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$CacheDirectoryGetter
            public File getCacheDirectory() {
                return new File(s1, this.val$diskCacheName);
            }
        }, v);
    }

    @Override  // com.bumptech.glide.load.engine.cache.DiskCache$Factory
    public DiskCache build() {
        File file0 = this.cacheDirectoryGetter.getCacheDirectory();
        if(file0 == null) {
            return null;
        }
        return file0.isDirectory() || file0.mkdirs() ? DiskLruCacheWrapper.create(file0, this.diskCacheSize) : null;
    }
}

