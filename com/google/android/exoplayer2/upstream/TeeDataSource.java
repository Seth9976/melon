package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;

public final class TeeDataSource implements DataSource {
    private long bytesRemaining;
    private final DataSink dataSink;
    private boolean dataSinkNeedsClosing;
    private final DataSource upstream;

    public TeeDataSource(DataSource dataSource0, DataSink dataSink0) {
        this.upstream = (DataSource)Assertions.checkNotNull(dataSource0);
        this.dataSink = (DataSink)Assertions.checkNotNull(dataSink0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener0) {
        this.upstream.addTransferListener(transferListener0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        try {
            this.upstream.close();
        }
        catch(Throwable throwable0) {
            if(this.dataSinkNeedsClosing) {
                this.dataSinkNeedsClosing = false;
                this.dataSink.close();
            }
            throw throwable0;
        }
        if(this.dataSinkNeedsClosing) {
            this.dataSinkNeedsClosing = false;
            this.dataSink.close();
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Map getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.upstream.getUri();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec0) {
        long v = this.upstream.open(dataSpec0);
        this.bytesRemaining = v;
        if(v == 0L) {
            return 0L;
        }
        if(dataSpec0.length == -1L && v != -1L) {
            dataSpec0 = dataSpec0.subrange(0L, v);
        }
        this.dataSinkNeedsClosing = true;
        this.dataSink.open(dataSpec0);
        return this.bytesRemaining;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        if(this.bytesRemaining == 0L) {
            return -1;
        }
        int v2 = this.upstream.read(arr_b, v, v1);
        if(v2 > 0) {
            this.dataSink.write(arr_b, v, v2);
            long v3 = this.bytesRemaining;
            if(v3 != -1L) {
                this.bytesRemaining = v3 - ((long)v2);
            }
        }
        return v2;
    }
}

