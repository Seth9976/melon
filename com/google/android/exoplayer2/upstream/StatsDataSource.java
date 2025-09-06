package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.Map;

public final class StatsDataSource implements DataSource {
    private long bytesRead;
    private final DataSource dataSource;
    private Uri lastOpenedUri;
    private Map lastResponseHeaders;

    public StatsDataSource(DataSource dataSource0) {
        this.dataSource = (DataSource)Assertions.checkNotNull(dataSource0);
        this.lastOpenedUri = Uri.EMPTY;
        this.lastResponseHeaders = Collections.EMPTY_MAP;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener0) {
        this.dataSource.addTransferListener(transferListener0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.dataSource.close();
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public Uri getLastOpenedUri() {
        return this.lastOpenedUri;
    }

    public Map getLastResponseHeaders() {
        return this.lastResponseHeaders;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Map getResponseHeaders() {
        return this.dataSource.getResponseHeaders();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.dataSource.getUri();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec0) {
        this.lastOpenedUri = dataSpec0.uri;
        this.lastResponseHeaders = Collections.EMPTY_MAP;
        long v = this.dataSource.open(dataSpec0);
        this.lastOpenedUri = (Uri)Assertions.checkNotNull(this.getUri());
        this.lastResponseHeaders = this.getResponseHeaders();
        return v;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        int v2 = this.dataSource.read(arr_b, v, v1);
        if(v2 != -1) {
            this.bytesRead += (long)v2;
        }
        return v2;
    }

    public void resetBytesRead() {
        this.bytesRead = 0L;
    }
}

