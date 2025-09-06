package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class ContentDataSource extends BaseDataSource {
    public static class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException0) {
            super(iOException0);
        }
    }

    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private FileInputStream inputStream;
    private boolean opened;
    private final ContentResolver resolver;
    private Uri uri;

    public ContentDataSource(Context context0) {
        super(false);
        this.resolver = context0.getContentResolver();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        try {
            try {
                this.uri = null;
                FileInputStream fileInputStream0 = this.inputStream;
                if(fileInputStream0 != null) {
                    fileInputStream0.close();
                }
                goto label_24;
            }
            catch(IOException iOException0) {
            }
            throw new ContentDataSourceException(iOException0);
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
                throw new ContentDataSourceException(iOException1);
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
            throw new ContentDataSourceException(iOException2);
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
        try {
            Uri uri0 = dataSpec0.uri;
            this.uri = uri0;
            this.transferInitializing(dataSpec0);
            AssetFileDescriptor assetFileDescriptor0 = this.resolver.openAssetFileDescriptor(uri0, "r");
            this.assetFileDescriptor = assetFileDescriptor0;
            if(assetFileDescriptor0 == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + uri0);
            }
            FileInputStream fileInputStream0 = new FileInputStream(assetFileDescriptor0.getFileDescriptor());
            this.inputStream = fileInputStream0;
            long v = assetFileDescriptor0.getStartOffset();
            long v1 = fileInputStream0.skip(dataSpec0.position + v) - v;
            if(v1 != dataSpec0.position) {
                throw new EOFException();
            }
            long v2 = dataSpec0.length;
            long v3 = -1L;
            if(v2 == -1L) {
                long v4 = assetFileDescriptor0.getLength();
                if(v4 == -1L) {
                    FileChannel fileChannel0 = fileInputStream0.getChannel();
                    long v5 = fileChannel0.size();
                    if(v5 != 0L) {
                        v3 = v5 - fileChannel0.position();
                    }
                    this.bytesRemaining = v3;
                }
                else {
                    this.bytesRemaining = v4 - v1;
                }
            }
            else {
                this.bytesRemaining = v2;
            }
        }
        catch(IOException iOException0) {
            throw new ContentDataSourceException(iOException0);
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
            throw new ContentDataSourceException(iOException0);
        }
        if(v3 == -1) {
            if(this.bytesRemaining != -1L) {
                throw new ContentDataSourceException(new EOFException());
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

