package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ReusableBufferedOutputStream;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class CacheDataSink implements DataSink {
    public static class CacheDataSinkException extends CacheException {
        public CacheDataSinkException(IOException iOException0) {
            super(iOException0);
        }
    }

    public static final int DEFAULT_BUFFER_SIZE = 0x5000;
    public static final long DEFAULT_FRAGMENT_SIZE = 0x500000L;
    private static final long MIN_RECOMMENDED_FRAGMENT_SIZE = 0x200000L;
    private static final String TAG = "CacheDataSink";
    private final int bufferSize;
    private ReusableBufferedOutputStream bufferedOutputStream;
    private final Cache cache;
    private DataSpec dataSpec;
    private long dataSpecBytesWritten;
    private long dataSpecFragmentSize;
    private File file;
    private final long fragmentSize;
    private OutputStream outputStream;
    private long outputStreamBytesWritten;

    public CacheDataSink(Cache cache0, long v) {
        this(cache0, v, 0x5000);
    }

    public CacheDataSink(Cache cache0, long v, int v1) {
        Assertions.checkState(Long.compare(v, 0L) > 0 || v == -1L, "fragmentSize must be positive or C.LENGTH_UNSET.");
        int v2 = Long.compare(v, -1L);
        if(v2 != 0 && v < 0x200000L) {
            Log.w("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.cache = (Cache)Assertions.checkNotNull(cache0);
        if(v2 == 0) {
            v = 0x7FFFFFFFFFFFFFFFL;
        }
        this.fragmentSize = v;
        this.bufferSize = v1;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSink
    public void close() {
        if(this.dataSpec == null) {
            return;
        }
        try {
            this.closeCurrentOutputStream();
        }
        catch(IOException iOException0) {
            throw new CacheDataSinkException(iOException0);
        }
    }

    private void closeCurrentOutputStream() {
        OutputStream outputStream0 = this.outputStream;
        if(outputStream0 == null) {
            return;
        }
        try {
            outputStream0.flush();
        }
        catch(Throwable throwable0) {
            Util.closeQuietly(this.outputStream);
            this.outputStream = null;
            File file0 = this.file;
            this.file = null;
            file0.delete();
            throw throwable0;
        }
        Util.closeQuietly(this.outputStream);
        this.outputStream = null;
        File file1 = this.file;
        this.file = null;
        this.cache.commitFile(file1, this.outputStreamBytesWritten);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSink
    public void open(DataSpec dataSpec0) {
        if(dataSpec0.length == -1L && dataSpec0.isFlagSet(2)) {
            this.dataSpec = null;
            return;
        }
        this.dataSpec = dataSpec0;
        long v = dataSpec0.isFlagSet(4) ? this.fragmentSize : 0x7FFFFFFFFFFFFFFFL;
        try {
            this.dataSpecFragmentSize = v;
            this.dataSpecBytesWritten = 0L;
            this.openNextOutputStream();
        }
        catch(IOException iOException0) {
            throw new CacheDataSinkException(iOException0);
        }
    }

    private void openNextOutputStream() {
        long v = this.dataSpec.length;
        this.file = this.cache.startFile(this.dataSpec.key, this.dataSpec.absoluteStreamPosition + this.dataSpecBytesWritten, (v == -1L ? -1L : Math.min(v - this.dataSpecBytesWritten, this.dataSpecFragmentSize)));
        FileOutputStream fileOutputStream0 = new FileOutputStream(this.file);
        if(this.bufferSize > 0) {
            ReusableBufferedOutputStream reusableBufferedOutputStream0 = this.bufferedOutputStream;
            if(reusableBufferedOutputStream0 == null) {
                this.bufferedOutputStream = new ReusableBufferedOutputStream(fileOutputStream0, this.bufferSize);
            }
            else {
                reusableBufferedOutputStream0.reset(fileOutputStream0);
            }
            this.outputStream = this.bufferedOutputStream;
        }
        else {
            this.outputStream = fileOutputStream0;
        }
        this.outputStreamBytesWritten = 0L;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] arr_b, int v, int v1) {
        if(this.dataSpec != null) {
            int v2 = 0;
            while(v2 < v1) {
                try {
                    if(this.outputStreamBytesWritten == this.dataSpecFragmentSize) {
                        this.closeCurrentOutputStream();
                        this.openNextOutputStream();
                    }
                    int v3 = (int)Math.min(v1 - v2, this.dataSpecFragmentSize - this.outputStreamBytesWritten);
                    this.outputStream.write(arr_b, v + v2, v3);
                    v2 += v3;
                    this.outputStreamBytesWritten += (long)v3;
                    this.dataSpecBytesWritten += (long)v3;
                    continue;
                }
                catch(IOException iOException0) {
                }
                throw new CacheDataSinkException(iOException0);
            }
        }
    }
}

