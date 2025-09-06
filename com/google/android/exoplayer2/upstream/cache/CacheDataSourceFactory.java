package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.DataSource;

public final class CacheDataSourceFactory implements Factory {
    private final Cache cache;
    private final CacheKeyFactory cacheKeyFactory;
    private final Factory cacheReadDataSourceFactory;
    private final com.google.android.exoplayer2.upstream.DataSink.Factory cacheWriteDataSinkFactory;
    private final EventListener eventListener;
    private final int flags;
    private final Factory upstreamFactory;

    public CacheDataSourceFactory(Cache cache0, Factory dataSource$Factory0) {
        this(cache0, dataSource$Factory0, 0);
    }

    public CacheDataSourceFactory(Cache cache0, Factory dataSource$Factory0, int v) {
        this(cache0, dataSource$Factory0, new com.google.android.exoplayer2.upstream.FileDataSource.Factory(), new CacheDataSinkFactory(cache0, 0x500000L), v, null);
    }

    public CacheDataSourceFactory(Cache cache0, Factory dataSource$Factory0, Factory dataSource$Factory1, com.google.android.exoplayer2.upstream.DataSink.Factory dataSink$Factory0, int v, EventListener cacheDataSource$EventListener0) {
        this(cache0, dataSource$Factory0, dataSource$Factory1, dataSink$Factory0, v, cacheDataSource$EventListener0, null);
    }

    public CacheDataSourceFactory(Cache cache0, Factory dataSource$Factory0, Factory dataSource$Factory1, com.google.android.exoplayer2.upstream.DataSink.Factory dataSink$Factory0, int v, EventListener cacheDataSource$EventListener0, CacheKeyFactory cacheKeyFactory0) {
        this.cache = cache0;
        this.upstreamFactory = dataSource$Factory0;
        this.cacheReadDataSourceFactory = dataSource$Factory1;
        this.cacheWriteDataSinkFactory = dataSink$Factory0;
        this.flags = v;
        this.eventListener = cacheDataSource$EventListener0;
        this.cacheKeyFactory = cacheKeyFactory0;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource$Factory
    public DataSource createDataSource() {
        return this.createDataSource();
    }

    public CacheDataSource createDataSource() {
        DataSource dataSource0 = this.upstreamFactory.createDataSource();
        DataSource dataSource1 = this.cacheReadDataSourceFactory.createDataSource();
        return this.cacheWriteDataSinkFactory == null ? new CacheDataSource(this.cache, dataSource0, dataSource1, null, this.flags, this.eventListener, this.cacheKeyFactory) : new CacheDataSource(this.cache, dataSource0, dataSource1, this.cacheWriteDataSinkFactory.createDataSink(), this.flags, this.eventListener, this.cacheKeyFactory);
    }
}

