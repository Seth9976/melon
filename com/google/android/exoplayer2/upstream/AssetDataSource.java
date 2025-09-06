package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class AssetDataSource extends BaseDataSource {
    public static final class AssetDataSourceException extends IOException {
        public AssetDataSourceException(IOException iOException0) {
            super(iOException0);
        }
    }

    private final AssetManager assetManager;
    private long bytesRemaining;
    private InputStream inputStream;
    private boolean opened;
    private Uri uri;

    public AssetDataSource(Context context0) {
        super(false);
        this.assetManager = context0.getAssets();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        try {
            this.uri = null;
            InputStream inputStream0 = this.inputStream;
            if(inputStream0 != null) {
                inputStream0.close();
            }
        }
        catch(IOException iOException0) {
            throw new AssetDataSourceException(iOException0);
        }
        finally {
            this.inputStream = null;
            if(this.opened) {
                this.opened = false;
                this.transferEnded();
            }
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.uri;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec0) {
        try {
            this.uri = dataSpec0.uri;
            String s = (String)Assertions.checkNotNull(dataSpec0.uri.getPath());
            if(s.startsWith("/android_asset/")) {
                s = s.substring(15);
            }
            else if(s.startsWith("/")) {
                s = s.substring(1);
            }
            this.transferInitializing(dataSpec0);
            InputStream inputStream0 = this.assetManager.open(s, 1);
            this.inputStream = inputStream0;
            if(inputStream0.skip(dataSpec0.position) < dataSpec0.position) {
                throw new EOFException();
            }
            long v = dataSpec0.length;
            if(v == -1L) {
                long v1 = (long)this.inputStream.available();
                this.bytesRemaining = v1;
                if(v1 == 0x7FFFFFFFL) {
                    this.bytesRemaining = -1L;
                }
            }
            else {
                this.bytesRemaining = v;
            }
        }
        catch(IOException iOException0) {
            throw new AssetDataSourceException(iOException0);
        }
        this.opened = true;
        this.transferStarted(dataSpec0);
        return this.bytesRemaining;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        int v3;
        if(v1 == 0) {
            return 0;
        }
        long v2 = this.bytesRemaining;
        if(Long.compare(v2, 0L) == 0) {
            return -1;
        }
        try {
            if(v2 != -1L) {
                v1 = (int)Math.min(v2, v1);
            }
            v3 = this.inputStream.read(arr_b, v, v1);
        }
        catch(IOException iOException0) {
            throw new AssetDataSourceException(iOException0);
        }
        if(v3 == -1) {
            if(this.bytesRemaining != -1L) {
                throw new AssetDataSourceException(new EOFException());
            }
            return -1;
        }
        long v4 = this.bytesRemaining;
        if(v4 != -1L) {
            this.bytesRemaining = v4 - ((long)v3);
        }
        this.bytesTransferred(v3);
        return v3;
    }
}

