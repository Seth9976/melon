package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Util;
import java.net.URLDecoder;

public final class DataSchemeDataSource extends BaseDataSource {
    public static final String SCHEME_DATA = "data";
    private byte[] data;
    private DataSpec dataSpec;
    private int endPosition;
    private int readPosition;

    public DataSchemeDataSource() {
        super(false);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if(this.data != null) {
            this.data = null;
            this.transferEnded();
        }
        this.dataSpec = null;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.dataSpec == null ? null : this.dataSpec.uri;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec0) {
        this.transferInitializing(dataSpec0);
        this.dataSpec = dataSpec0;
        this.readPosition = (int)dataSpec0.position;
        Uri uri0 = dataSpec0.uri;
        String s = uri0.getScheme();
        if(!"data".equals(s)) {
            String s1 = String.valueOf(s);
            throw new ParserException((s1.length() == 0 ? new String("Unsupported scheme: ") : "Unsupported scheme: " + s1));
        }
        String[] arr_s = Util.split(uri0.getSchemeSpecificPart(), ",");
        if(arr_s.length != 2) {
            throw new ParserException("Unexpected URI format: " + uri0);
        }
        String s2 = arr_s[1];
        if(arr_s[0].contains(";base64")) {
            try {
                this.data = Base64.decode(s2, 0);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                String s3 = String.valueOf(s2);
                throw new ParserException((s3.length() == 0 ? new String("Error while parsing Base64 encoded string: ") : "Error while parsing Base64 encoded string: " + s3), illegalArgumentException0);
            }
        }
        else {
            this.data = Util.getUtf8Bytes(URLDecoder.decode(s2, "US-ASCII"));
        }
        int v = dataSpec0.length == -1L ? this.data.length : ((int)dataSpec0.length) + this.readPosition;
        this.endPosition = v;
        if(v <= this.data.length && this.readPosition <= v) {
            this.transferStarted(dataSpec0);
            return ((long)this.endPosition) - ((long)this.readPosition);
        }
        this.data = null;
        throw new DataSourceException(0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return 0;
        }
        int v2 = this.endPosition - this.readPosition;
        if(v2 == 0) {
            return -1;
        }
        int v3 = Math.min(v1, v2);
        System.arraycopy(this.data, this.readPosition, arr_b, v, v3);
        this.readPosition += v3;
        this.bytesTransferred(v3);
        return v3;
    }
}

