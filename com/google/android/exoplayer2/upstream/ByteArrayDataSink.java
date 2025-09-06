package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import java.io.ByteArrayOutputStream;

public final class ByteArrayDataSink implements DataSink {
    private ByteArrayOutputStream stream;

    @Override  // com.google.android.exoplayer2.upstream.DataSink
    public void close() {
        this.stream.close();
    }

    public byte[] getData() {
        return this.stream == null ? null : this.stream.toByteArray();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSink
    public void open(DataSpec dataSpec0) {
        long v = dataSpec0.length;
        if(v == -1L) {
            this.stream = new ByteArrayOutputStream();
            return;
        }
        Assertions.checkArgument(v <= 0x7FFFFFFFL);
        this.stream = new ByteArrayOutputStream(((int)dataSpec0.length));
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] arr_b, int v, int v1) {
        this.stream.write(arr_b, v, v1);
    }
}

