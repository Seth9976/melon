package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Map;

final class IcyDataSource implements DataSource {
    public interface Listener {
        void onIcyMetadata(ParsableByteArray arg1);
    }

    private int bytesUntilMetadata;
    private final Listener listener;
    private final int metadataIntervalBytes;
    private final byte[] metadataLengthByteHolder;
    private final DataSource upstream;

    public IcyDataSource(DataSource dataSource0, int v, Listener icyDataSource$Listener0) {
        Assertions.checkArgument(v > 0);
        this.upstream = dataSource0;
        this.metadataIntervalBytes = v;
        this.listener = icyDataSource$Listener0;
        this.metadataLengthByteHolder = new byte[1];
        this.bytesUntilMetadata = v;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener0) {
        this.upstream.addTransferListener(transferListener0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        if(this.bytesUntilMetadata == 0) {
            if(this.readMetadata()) {
                this.bytesUntilMetadata = this.metadataIntervalBytes;
                goto label_5;
            }
            return -1;
        }
    label_5:
        int v2 = this.upstream.read(arr_b, v, Math.min(this.bytesUntilMetadata, v1));
        if(v2 != -1) {
            this.bytesUntilMetadata -= v2;
        }
        return v2;
    }

    private boolean readMetadata() {
        if(this.upstream.read(this.metadataLengthByteHolder, 0, 1) == -1) {
            return false;
        }
        int v = (this.metadataLengthByteHolder[0] & 0xFF) << 4;
        if(v == 0) {
            return true;
        }
        byte[] arr_b = new byte[v];
        int v1 = v;
        int v2 = 0;
        while(v1 > 0) {
            int v3 = this.upstream.read(arr_b, v2, v1);
            if(v3 == -1) {
                return false;
            }
            v2 += v3;
            v1 -= v3;
        }
        while(v > 0 && arr_b[v - 1] == 0) {
            --v;
        }
        if(v > 0) {
            ParsableByteArray parsableByteArray0 = new ParsableByteArray(arr_b, v);
            this.listener.onIcyMetadata(parsableByteArray0);
        }
        return true;
    }
}

