package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.util.Map;

public final class ResolvingDataSource implements DataSource {
    public static final class Factory implements com.google.android.exoplayer2.upstream.DataSource.Factory {
        private final Resolver resolver;
        private final com.google.android.exoplayer2.upstream.DataSource.Factory upstreamFactory;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, Resolver resolvingDataSource$Resolver0) {
            this.upstreamFactory = dataSource$Factory0;
            this.resolver = resolvingDataSource$Resolver0;
        }

        @Override  // com.google.android.exoplayer2.upstream.DataSource$Factory
        public DataSource createDataSource() {
            return this.createDataSource();
        }

        public ResolvingDataSource createDataSource() {
            return new ResolvingDataSource(this.upstreamFactory.createDataSource(), this.resolver);
        }
    }

    public interface Resolver {
        DataSpec resolveDataSpec(DataSpec arg1);

        default Uri resolveReportedUri(Uri uri0) [...] // Inlined contents
    }

    private final Resolver resolver;
    private final DataSource upstreamDataSource;
    private boolean upstreamOpened;

    public ResolvingDataSource(DataSource dataSource0, Resolver resolvingDataSource$Resolver0) {
        this.upstreamDataSource = dataSource0;
        this.resolver = resolvingDataSource$Resolver0;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener0) {
        this.upstreamDataSource.addTransferListener(transferListener0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if(this.upstreamOpened) {
            this.upstreamOpened = false;
            this.upstreamDataSource.close();
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Map getResponseHeaders() {
        return this.upstreamDataSource.getResponseHeaders();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        Uri uri0 = this.upstreamDataSource.getUri();
        return uri0 == null ? null : uri0;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec0) {
        DataSpec dataSpec1 = this.resolver.resolveDataSpec(dataSpec0);
        this.upstreamOpened = true;
        return this.upstreamDataSource.open(dataSpec1);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        return this.upstreamDataSource.read(arr_b, v, v1);
    }
}

