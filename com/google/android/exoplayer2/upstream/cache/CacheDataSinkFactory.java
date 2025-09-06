package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSink.Factory;
import com.google.android.exoplayer2.upstream.DataSink;

public final class CacheDataSinkFactory implements Factory {
    private final int bufferSize;
    private final Cache cache;
    private final long fragmentSize;

    public CacheDataSinkFactory(Cache cache0, long v) {
        this(cache0, v, 0x5000);
    }

    public CacheDataSinkFactory(Cache cache0, long v, int v1) {
        this.cache = cache0;
        this.fragmentSize = v;
        this.bufferSize = v1;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSink$Factory
    public DataSink createDataSink() {
        return new CacheDataSink(this.cache, this.fragmentSize, this.bufferSize);
    }
}

