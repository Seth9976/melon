package com.google.android.exoplayer2.upstream.crypto;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.util.Map;

public final class AesCipherDataSource implements DataSource {
    private AesFlushingCipher cipher;
    private final byte[] secretKey;
    private final DataSource upstream;

    public AesCipherDataSource(byte[] arr_b, DataSource dataSource0) {
        this.upstream = dataSource0;
        this.secretKey = arr_b;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener0) {
        this.upstream.addTransferListener(transferListener0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.cipher = null;
        this.upstream.close();
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
        this.cipher = new AesFlushingCipher(2, this.secretKey, CryptoUtil.getFNV64Hash(dataSpec0.key), dataSpec0.absoluteStreamPosition);
        return v;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return 0;
        }
        int v2 = this.upstream.read(arr_b, v, v1);
        if(v2 == -1) {
            return -1;
        }
        this.cipher.updateInPlace(arr_b, v, v2);
        return v2;
    }
}

