package com.google.android.exoplayer2.upstream.crypto;

import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;

public final class AesCipherDataSink implements DataSink {
    private AesFlushingCipher cipher;
    private final byte[] scratch;
    private final byte[] secretKey;
    private final DataSink wrappedDataSink;

    public AesCipherDataSink(byte[] arr_b, DataSink dataSink0) {
        this(arr_b, dataSink0, null);
    }

    public AesCipherDataSink(byte[] arr_b, DataSink dataSink0, byte[] arr_b1) {
        this.wrappedDataSink = dataSink0;
        this.secretKey = arr_b;
        this.scratch = arr_b1;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSink
    public void close() {
        this.cipher = null;
        this.wrappedDataSink.close();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSink
    public void open(DataSpec dataSpec0) {
        this.wrappedDataSink.open(dataSpec0);
        this.cipher = new AesFlushingCipher(1, this.secretKey, CryptoUtil.getFNV64Hash(dataSpec0.key), dataSpec0.absoluteStreamPosition);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] arr_b, int v, int v1) {
        if(this.scratch == null) {
            this.cipher.updateInPlace(arr_b, v, v1);
            this.wrappedDataSink.write(arr_b, v, v1);
            return;
        }
        for(int v2 = 0; v2 < v1; v2 += v3) {
            int v3 = Math.min(v1 - v2, this.scratch.length);
            this.cipher.update(arr_b, v + v2, v3, this.scratch, 0);
            this.wrappedDataSink.write(this.scratch, 0, v3);
        }
    }
}

