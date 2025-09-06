package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class RawResourceDataSource extends BaseDataSource {
    public static class RawResourceDataSourceException extends IOException {
        public RawResourceDataSourceException(IOException iOException0) {
            super(iOException0);
        }

        public RawResourceDataSourceException(String s) {
            super(s);
        }
    }

    public static final String RAW_RESOURCE_SCHEME = "rawresource";
    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private InputStream inputStream;
    private boolean opened;
    private final Resources resources;
    private Uri uri;

    public RawResourceDataSource(Context context0) {
        super(false);
        this.resources = context0.getResources();
    }

    public static Uri buildRawResourceUri(int v) {
        return Uri.parse(("rawresource:///" + v));
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        try {
            try {
                this.uri = null;
                InputStream inputStream0 = this.inputStream;
                if(inputStream0 != null) {
                    inputStream0.close();
                }
                goto label_24;
            }
            catch(IOException iOException0) {
            }
            throw new RawResourceDataSourceException(iOException0);
        }
        catch(Throwable throwable0) {
            try {
                this.inputStream = null;
                AssetFileDescriptor assetFileDescriptor0 = this.assetFileDescriptor;
                if(assetFileDescriptor0 != null) {
                    assetFileDescriptor0.close();
                }
            }
            catch(IOException iOException1) {
                throw new RawResourceDataSourceException(iOException1);
            }
            finally {
                this.assetFileDescriptor = null;
                if(this.opened) {
                    this.opened = false;
                    this.transferEnded();
                }
            }
            throw throwable0;
        }
        try {
        label_24:
            this.inputStream = null;
            AssetFileDescriptor assetFileDescriptor1 = this.assetFileDescriptor;
            if(assetFileDescriptor1 != null) {
                assetFileDescriptor1.close();
            }
        }
        catch(IOException iOException2) {
            throw new RawResourceDataSourceException(iOException2);
        }
        finally {
            this.assetFileDescriptor = null;
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
        int v;
        try {
            Uri uri0 = dataSpec0.uri;
            this.uri = uri0;
            if(!TextUtils.equals("rawresource", uri0.getScheme())) {
                throw new RawResourceDataSourceException("URI must use scheme rawresource");
            }
            try {
                v = Integer.parseInt(((String)Assertions.checkNotNull(uri0.getLastPathSegment())));
            }
            catch(NumberFormatException unused_ex) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.");
            }
            this.transferInitializing(dataSpec0);
            AssetFileDescriptor assetFileDescriptor0 = this.resources.openRawResourceFd(v);
            this.assetFileDescriptor = assetFileDescriptor0;
            if(assetFileDescriptor0 == null) {
                throw new RawResourceDataSourceException("Resource is compressed: " + uri0);
            }
            FileInputStream fileInputStream0 = new FileInputStream(assetFileDescriptor0.getFileDescriptor());
            this.inputStream = fileInputStream0;
            fileInputStream0.skip(assetFileDescriptor0.getStartOffset());
            if(fileInputStream0.skip(dataSpec0.position) < dataSpec0.position) {
                throw new EOFException();
            }
            long v1 = dataSpec0.length;
            long v2 = -1L;
            if(v1 == -1L) {
                long v3 = assetFileDescriptor0.getLength();
                if(v3 != -1L) {
                    v2 = v3 - dataSpec0.position;
                }
                this.bytesRemaining = v2;
            }
            else {
                this.bytesRemaining = v1;
            }
        }
        catch(IOException iOException0) {
            throw new RawResourceDataSourceException(iOException0);
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
            throw new RawResourceDataSourceException(iOException0);
        }
        if(v3 == -1) {
            if(this.bytesRemaining != -1L) {
                throw new RawResourceDataSourceException(new EOFException());
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

