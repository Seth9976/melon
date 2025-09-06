package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.DataSource;

public final class DefaultHlsDataSourceFactory implements HlsDataSourceFactory {
    private final Factory dataSourceFactory;

    public DefaultHlsDataSourceFactory(Factory dataSource$Factory0) {
        this.dataSourceFactory = dataSource$Factory0;
    }

    @Override  // com.google.android.exoplayer2.source.hls.HlsDataSourceFactory
    public DataSource createDataSource(int v) {
        return this.dataSourceFactory.createDataSource();
    }
}

