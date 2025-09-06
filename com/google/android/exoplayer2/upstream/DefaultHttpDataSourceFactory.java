package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;

public final class DefaultHttpDataSourceFactory extends BaseFactory {
    private final boolean allowCrossProtocolRedirects;
    private final int connectTimeoutMillis;
    private final TransferListener listener;
    private final int readTimeoutMillis;
    private final String userAgent;

    public DefaultHttpDataSourceFactory(String s) {
        this(s, null);
    }

    public DefaultHttpDataSourceFactory(String s, int v, int v1, boolean z) {
        this(s, null, v, v1, z);
    }

    public DefaultHttpDataSourceFactory(String s, TransferListener transferListener0) {
        this(s, transferListener0, 8000, 8000, false);
    }

    public DefaultHttpDataSourceFactory(String s, TransferListener transferListener0, int v, int v1, boolean z) {
        this.userAgent = Assertions.checkNotEmpty(s);
        this.listener = transferListener0;
        this.connectTimeoutMillis = v;
        this.readTimeoutMillis = v1;
        this.allowCrossProtocolRedirects = z;
    }

    public DefaultHttpDataSource createDataSourceInternal(RequestProperties httpDataSource$RequestProperties0) {
        DefaultHttpDataSource defaultHttpDataSource0 = new DefaultHttpDataSource(this.userAgent, this.connectTimeoutMillis, this.readTimeoutMillis, this.allowCrossProtocolRedirects, httpDataSource$RequestProperties0);
        TransferListener transferListener0 = this.listener;
        if(transferListener0 != null) {
            defaultHttpDataSource0.addTransferListener(transferListener0);
        }
        return defaultHttpDataSource0;
    }

    @Override  // com.google.android.exoplayer2.upstream.HttpDataSource$BaseFactory
    public HttpDataSource createDataSourceInternal(RequestProperties httpDataSource$RequestProperties0) {
        return this.createDataSourceInternal(httpDataSource$RequestProperties0);
    }
}

