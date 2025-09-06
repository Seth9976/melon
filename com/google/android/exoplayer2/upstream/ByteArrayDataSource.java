package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class ByteArrayDataSource extends BaseDataSource {
    private int bytesRemaining;
    private final byte[] data;
    private boolean opened;
    private int readPosition;
    private Uri uri;

    public ByteArrayDataSource(byte[] arr_b) {
        boolean z = false;
        super(false);
        Assertions.checkNotNull(arr_b);
        if(arr_b.length > 0) {
            z = true;
        }
        Assertions.checkArgument(z);
        this.data = arr_b;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if(this.opened) {
            this.opened = false;
            this.transferEnded();
        }
        this.uri = null;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.uri;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec0) {
        this.uri = dataSpec0.uri;
        this.transferInitializing(dataSpec0);
        this.readPosition = (int)dataSpec0.position;
        long v = dataSpec0.length == -1L ? ((long)this.data.length) - dataSpec0.position : dataSpec0.length;
        this.bytesRemaining = (int)v;
        if(((int)v) <= 0 || ((int)dataSpec0.position) + ((int)v) > this.data.length) {
            throw new IOException("Unsatisfiable range: [" + this.readPosition + ", " + dataSpec0.length + "], length: " + this.data.length);
        }
        this.opened = true;
        this.transferStarted(dataSpec0);
        return (long)this.bytesRemaining;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return 0;
        }
        int v2 = this.bytesRemaining;
        if(v2 == 0) {
            return -1;
        }
        int v3 = Math.min(v1, v2);
        System.arraycopy(this.data, this.readPosition, arr_b, v, v3);
        this.readPosition += v3;
        this.bytesRemaining -= v3;
        this.bytesTransferred(v3);
        return v3;
    }
}

