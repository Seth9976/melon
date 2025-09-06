package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.DummyDataSource;
import com.google.android.exoplayer2.upstream.PriorityDataSourceFactory;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSinkFactory;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheUtil;
import com.google.android.exoplayer2.util.PriorityTaskManager;

public final class DownloaderConstructorHelper {
    private final Cache cache;
    private final CacheKeyFactory cacheKeyFactory;
    private final CacheDataSourceFactory offlineCacheDataSourceFactory;
    private final CacheDataSourceFactory onlineCacheDataSourceFactory;
    private final PriorityTaskManager priorityTaskManager;

    public DownloaderConstructorHelper(Cache cache0, Factory dataSource$Factory0) {
        this(cache0, dataSource$Factory0, null, null, null);
    }

    public DownloaderConstructorHelper(Cache cache0, Factory dataSource$Factory0, Factory dataSource$Factory1, com.google.android.exoplayer2.upstream.DataSink.Factory dataSink$Factory0, PriorityTaskManager priorityTaskManager0) {
        this(cache0, dataSource$Factory0, dataSource$Factory1, dataSink$Factory0, priorityTaskManager0, null);
    }

    public DownloaderConstructorHelper(Cache cache0, Factory dataSource$Factory0, Factory dataSource$Factory1, com.google.android.exoplayer2.upstream.DataSink.Factory dataSink$Factory0, PriorityTaskManager priorityTaskManager0, CacheKeyFactory cacheKeyFactory0) {
        Factory dataSource$Factory2 = priorityTaskManager0 == null ? dataSource$Factory0 : new PriorityDataSourceFactory(dataSource$Factory0, priorityTaskManager0, -1000);
        Factory dataSource$Factory3 = dataSource$Factory1 == null ? new com.google.android.exoplayer2.upstream.FileDataSource.Factory() : dataSource$Factory1;
        com.google.android.exoplayer2.upstream.DataSink.Factory dataSink$Factory1 = dataSink$Factory0 == null ? new CacheDataSinkFactory(cache0, 0x500000L) : dataSink$Factory0;
        this.onlineCacheDataSourceFactory = new CacheDataSourceFactory(cache0, dataSource$Factory2, dataSource$Factory3, dataSink$Factory1, 1, null, cacheKeyFactory0);
        this.offlineCacheDataSourceFactory = new CacheDataSourceFactory(cache0, DummyDataSource.FACTORY, dataSource$Factory3, null, 1, null, cacheKeyFactory0);
        this.cache = cache0;
        this.priorityTaskManager = priorityTaskManager0;
        this.cacheKeyFactory = cacheKeyFactory0;
    }

    public CacheDataSource createCacheDataSource() {
        return this.onlineCacheDataSourceFactory.createDataSource();
    }

    public CacheDataSource createOfflineCacheDataSource() {
        return this.offlineCacheDataSourceFactory.createDataSource();
    }

    public Cache getCache() {
        return this.cache;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.cacheKeyFactory == null ? CacheUtil.DEFAULT_CACHE_KEY_FACTORY : this.cacheKeyFactory;
    }

    public PriorityTaskManager getPriorityTaskManager() {
        return this.priorityTaskManager == null ? new PriorityTaskManager() : this.priorityTaskManager;
    }
}

