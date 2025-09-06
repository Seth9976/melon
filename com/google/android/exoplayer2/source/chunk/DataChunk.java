package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public abstract class DataChunk extends Chunk {
    private static final int READ_GRANULARITY = 0x4000;
    private byte[] data;
    private volatile boolean loadCanceled;

    public DataChunk(DataSource dataSource0, DataSpec dataSpec0, int v, Format format0, int v1, Object object0, byte[] arr_b) {
        super(dataSource0, dataSpec0, v, format0, v1, object0, 0x8000000000000001L, 0x8000000000000001L);
        this.data = arr_b;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    public abstract void consume(byte[] arg1, int arg2);

    public byte[] getDataHolder() {
        return this.data;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
    public final void load() {
        try {
            this.dataSource.open(this.dataSpec);
            int v1 = 0;
            int v2 = 0;
            while(v1 != -1 && !this.loadCanceled) {
                this.maybeExpandData(v2);
                v1 = this.dataSource.read(this.data, v2, 0x4000);
                if(v1 != -1) {
                    v2 += v1;
                }
            }
            if(!this.loadCanceled) {
                this.consume(this.data, v2);
            }
        }
        finally {
            Util.closeQuietly(this.dataSource);
        }
    }

    private void maybeExpandData(int v) {
        byte[] arr_b = this.data;
        if(arr_b == null) {
            this.data = new byte[0x4000];
            return;
        }
        if(arr_b.length < v + 0x4000) {
            this.data = Arrays.copyOf(arr_b, arr_b.length + 0x4000);
        }
    }
}

