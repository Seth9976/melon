package com.google.android.exoplayer2.upstream;

import A7.d;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource extends BaseDataSource {
    public static final class Factory implements com.google.android.exoplayer2.upstream.DataSource.Factory {
        private TransferListener listener;

        @Override  // com.google.android.exoplayer2.upstream.DataSource$Factory
        public DataSource createDataSource() {
            return this.createDataSource();
        }

        public FileDataSource createDataSource() {
            FileDataSource fileDataSource0 = new FileDataSource();
            TransferListener transferListener0 = this.listener;
            if(transferListener0 != null) {
                fileDataSource0.addTransferListener(transferListener0);
            }
            return fileDataSource0;
        }

        public Factory setListener(TransferListener transferListener0) {
            this.listener = transferListener0;
            return this;
        }
    }

    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException0) {
            super(iOException0);
        }

        public FileDataSourceException(String s, IOException iOException0) {
            super(s, iOException0);
        }
    }

    private long bytesRemaining;
    private RandomAccessFile file;
    private boolean opened;
    private Uri uri;

    public FileDataSource() {
        super(false);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        try {
            this.uri = null;
            RandomAccessFile randomAccessFile0 = this.file;
            if(randomAccessFile0 != null) {
                randomAccessFile0.close();
            }
        }
        catch(IOException iOException0) {
            throw new FileDataSourceException(iOException0);
        }
        finally {
            this.file = null;
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
            this.transferInitializing(dataSpec0);
            RandomAccessFile randomAccessFile0 = FileDataSource.openLocalFile(dataSpec0.uri);
            this.file = randomAccessFile0;
            randomAccessFile0.seek(dataSpec0.position);
            long v = dataSpec0.length == -1L ? this.file.length() - dataSpec0.position : dataSpec0.length;
            this.bytesRemaining = v;
            if(v < 0L) {
                throw new EOFException();
            }
        }
        catch(IOException iOException0) {
            throw new FileDataSourceException(iOException0);
        }
        this.opened = true;
        this.transferStarted(dataSpec0);
        return this.bytesRemaining;
    }

    private static RandomAccessFile openLocalFile(Uri uri0) {
        try {
            return new RandomAccessFile(((String)Assertions.checkNotNull(uri0.getPath())), "r");
        }
        catch(FileNotFoundException fileNotFoundException0) {
            if(TextUtils.isEmpty(uri0.getQuery()) && TextUtils.isEmpty(uri0.getFragment())) {
                throw new FileDataSourceException(fileNotFoundException0);
            }
            String s = uri0.getPath();
            String s1 = uri0.getQuery();
            String s2 = uri0.getFragment();
            StringBuilder stringBuilder0 = d.o("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing \'?\' or \'#\'? Use Uri.fromFile(new File(path)) to avoid this. path=", s, ",query=", s1, ",fragment=");
            stringBuilder0.append(s2);
            throw new FileDataSourceException(stringBuilder0.toString(), fileNotFoundException0);
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        int v2;
        if(v1 == 0) {
            return 0;
        }
        if(this.bytesRemaining == 0L) {
            return -1;
        }
        try {
            v2 = this.file.read(arr_b, v, ((int)Math.min(this.bytesRemaining, v1)));
        }
        catch(IOException iOException0) {
            throw new FileDataSourceException(iOException0);
        }
        if(v2 > 0) {
            this.bytesRemaining -= (long)v2;
            this.bytesTransferred(v2);
        }
        return v2;
    }
}

