package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import java.io.InputStream;

public final class DataSourceInputStream extends InputStream {
    private boolean closed;
    private final DataSource dataSource;
    private final DataSpec dataSpec;
    private boolean opened;
    private final byte[] singleByteArray;
    private long totalBytesRead;

    public DataSourceInputStream(DataSource dataSource0, DataSpec dataSpec0) {
        this.opened = false;
        this.closed = false;
        this.dataSource = dataSource0;
        this.dataSpec = dataSpec0;
        this.singleByteArray = new byte[1];
    }

    public long bytesRead() {
        return this.totalBytesRead;
    }

    private void checkOpened() {
        if(!this.opened) {
            this.dataSource.open(this.dataSpec);
            this.opened = true;
        }
    }

    @Override
    public void close() {
        if(!this.closed) {
            this.dataSource.close();
            this.closed = true;
        }
    }

    public void open() {
        this.checkOpened();
    }

    @Override
    public int read() {
        return this.read(this.singleByteArray) == -1 ? -1 : this.singleByteArray[0] & 0xFF;
    }

    @Override
    public int read(byte[] arr_b) {
        return this.read(arr_b, 0, arr_b.length);
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        Assertions.checkState(!this.closed);
        this.checkOpened();
        int v2 = this.dataSource.read(arr_b, v, v1);
        if(v2 == -1) {
            return -1;
        }
        this.totalBytesRead += (long)v2;
        return v2;
    }
}

