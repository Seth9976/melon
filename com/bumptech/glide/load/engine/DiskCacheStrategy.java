package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

public abstract class DiskCacheStrategy {
    public static final DiskCacheStrategy ALL;
    public static final DiskCacheStrategy AUTOMATIC;
    public static final DiskCacheStrategy DATA;
    public static final DiskCacheStrategy NONE;
    public static final DiskCacheStrategy RESOURCE;

    static {
        DiskCacheStrategy.ALL = new DiskCacheStrategy() {
            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean decodeCachedData() {
                return true;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean decodeCachedResource() {
                return true;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean isDataCacheable(DataSource dataSource0) {
                return dataSource0 == DataSource.REMOTE;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean isResourceCacheable(boolean z, DataSource dataSource0, EncodeStrategy encodeStrategy0) {
                return dataSource0 != DataSource.RESOURCE_DISK_CACHE && dataSource0 != DataSource.MEMORY_CACHE;
            }
        };
        DiskCacheStrategy.NONE = new DiskCacheStrategy() {
            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean decodeCachedData() {
                return false;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean decodeCachedResource() {
                return false;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean isDataCacheable(DataSource dataSource0) {
                return false;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean isResourceCacheable(boolean z, DataSource dataSource0, EncodeStrategy encodeStrategy0) {
                return false;
            }
        };
        DiskCacheStrategy.DATA = new DiskCacheStrategy() {
            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean decodeCachedData() {
                return true;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean decodeCachedResource() {
                return false;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean isDataCacheable(DataSource dataSource0) {
                return dataSource0 != DataSource.DATA_DISK_CACHE && dataSource0 != DataSource.MEMORY_CACHE;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean isResourceCacheable(boolean z, DataSource dataSource0, EncodeStrategy encodeStrategy0) {
                return false;
            }
        };
        DiskCacheStrategy.RESOURCE = new DiskCacheStrategy() {
            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean decodeCachedData() {
                return false;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean decodeCachedResource() {
                return true;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean isDataCacheable(DataSource dataSource0) {
                return false;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean isResourceCacheable(boolean z, DataSource dataSource0, EncodeStrategy encodeStrategy0) {
                return dataSource0 != DataSource.RESOURCE_DISK_CACHE && dataSource0 != DataSource.MEMORY_CACHE;
            }
        };
        DiskCacheStrategy.AUTOMATIC = new DiskCacheStrategy() {
            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean decodeCachedData() {
                return true;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean decodeCachedResource() {
                return true;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean isDataCacheable(DataSource dataSource0) {
                return dataSource0 == DataSource.REMOTE;
            }

            @Override  // com.bumptech.glide.load.engine.DiskCacheStrategy
            public boolean isResourceCacheable(boolean z, DataSource dataSource0, EncodeStrategy encodeStrategy0) {
                return (z && dataSource0 == DataSource.DATA_DISK_CACHE || dataSource0 == DataSource.LOCAL) && encodeStrategy0 == EncodeStrategy.TRANSFORMED;
            }
        };
    }

    public abstract boolean decodeCachedData();

    public abstract boolean decodeCachedResource();

    public abstract boolean isDataCacheable(DataSource arg1);

    public abstract boolean isResourceCacheable(boolean arg1, DataSource arg2, EncodeStrategy arg3);
}

