package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.util.Arrays;

public final class DefaultExtractorInput implements ExtractorInput {
    private static final int PEEK_MAX_FREE_SPACE = 0x80000;
    private static final int PEEK_MIN_FREE_SPACE_AFTER_RESIZE = 0x10000;
    private static final int SCRATCH_SPACE_SIZE = 0x1000;
    private final DataSource dataSource;
    private byte[] peekBuffer;
    private int peekBufferLength;
    private int peekBufferPosition;
    private long position;
    private final byte[] scratchSpace;
    private final long streamLength;

    public DefaultExtractorInput(DataSource dataSource0, long v, long v1) {
        this.dataSource = dataSource0;
        this.position = v;
        this.streamLength = v1;
        this.peekBuffer = new byte[0x10000];
        this.scratchSpace = new byte[0x1000];
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int v) {
        this.advancePeekPosition(v, false);
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int v, boolean z) {
        this.ensureSpaceForPeek(v);
        int v1 = this.peekBufferLength - this.peekBufferPosition;
        while(v1 < v) {
            v1 = this.readFromDataSource(this.peekBuffer, this.peekBufferPosition, v, v1, z);
            if(v1 == -1) {
                return false;
            }
            this.peekBufferLength = this.peekBufferPosition + v1;
        }
        this.peekBufferPosition += v;
        return true;
    }

    private void commitBytesRead(int v) {
        if(v != -1) {
            this.position += (long)v;
        }
    }

    private void ensureSpaceForPeek(int v) {
        int v1 = this.peekBufferPosition + v;
        byte[] arr_b = this.peekBuffer;
        if(v1 > arr_b.length) {
            this.peekBuffer = Arrays.copyOf(this.peekBuffer, Util.constrainValue(arr_b.length * 2, v1 + 0x10000, v1 + 0x80000));
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        return this.streamLength;
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        return this.position + ((long)this.peekBufferPosition);
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        return this.position;
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public int peek(byte[] arr_b, int v, int v1) {
        int v4;
        this.ensureSpaceForPeek(v1);
        int v2 = this.peekBufferPosition;
        int v3 = this.peekBufferLength - v2;
        if(v3 == 0) {
            v4 = this.readFromDataSource(this.peekBuffer, v2, v1, 0, true);
            if(v4 == -1) {
                return -1;
            }
            this.peekBufferLength += v4;
        }
        else {
            v4 = Math.min(v1, v3);
        }
        System.arraycopy(this.peekBuffer, this.peekBufferPosition, arr_b, v, v4);
        this.peekBufferPosition += v4;
        return v4;
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] arr_b, int v, int v1) {
        this.peekFully(arr_b, v, v1, false);
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] arr_b, int v, int v1, boolean z) {
        if(!this.advancePeekPosition(v1, z)) {
            return false;
        }
        System.arraycopy(this.peekBuffer, this.peekBufferPosition - v1, arr_b, v, v1);
        return true;
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public int read(byte[] arr_b, int v, int v1) {
        int v2 = this.readFromPeekBuffer(arr_b, v, v1);
        if(v2 == 0) {
            v2 = this.readFromDataSource(arr_b, v, v1, 0, true);
        }
        this.commitBytesRead(v2);
        return v2;
    }

    private int readFromDataSource(byte[] arr_b, int v, int v1, int v2, boolean z) {
        if(Thread.interrupted()) {
            throw new InterruptedException();
        }
        int v3 = this.dataSource.read(arr_b, v + v2, v1 - v2);
        if(v3 == -1) {
            if(v2 != 0 || !z) {
                throw new EOFException();
            }
            return -1;
        }
        return v2 + v3;
    }

    private int readFromPeekBuffer(byte[] arr_b, int v, int v1) {
        int v2 = this.peekBufferLength;
        if(v2 == 0) {
            return 0;
        }
        int v3 = Math.min(v2, v1);
        System.arraycopy(this.peekBuffer, 0, arr_b, v, v3);
        this.updatePeekBuffer(v3);
        return v3;
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] arr_b, int v, int v1) {
        this.readFully(arr_b, v, v1, false);
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] arr_b, int v, int v1, boolean z) {
        int v2;
        for(v2 = this.readFromPeekBuffer(arr_b, v, v1); v2 < v1 && v2 != -1; v2 = this.readFromDataSource(arr_b, v, v1, v2, z)) {
        }
        this.commitBytesRead(v2);
        return v2 != -1;
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        this.peekBufferPosition = 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public void setRetryPosition(long v, Throwable throwable0) {
        Assertions.checkArgument(v >= 0L);
        this.position = v;
        throw throwable0;
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public int skip(int v) {
        int v1 = this.skipFromPeekBuffer(v);
        if(v1 == 0) {
            v1 = this.readFromDataSource(this.scratchSpace, 0, Math.min(v, this.scratchSpace.length), 0, true);
        }
        this.commitBytesRead(v1);
        return v1;
    }

    private int skipFromPeekBuffer(int v) {
        int v1 = Math.min(this.peekBufferLength, v);
        this.updatePeekBuffer(v1);
        return v1;
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public void skipFully(int v) {
        this.skipFully(v, false);
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int v, boolean z) {
        int v1;
        for(v1 = this.skipFromPeekBuffer(v); v1 < v && v1 != -1; v1 = this.readFromDataSource(this.scratchSpace, -v1, Math.min(v, this.scratchSpace.length + v1), v1, z)) {
        }
        this.commitBytesRead(v1);
        return v1 != -1;
    }

    private void updatePeekBuffer(int v) {
        int v1 = this.peekBufferLength - v;
        this.peekBufferLength = v1;
        this.peekBufferPosition = 0;
        byte[] arr_b = this.peekBuffer;
        byte[] arr_b1 = v1 >= arr_b.length - 0x80000 ? arr_b : new byte[v1 + 0x10000];
        System.arraycopy(arr_b, v, arr_b1, 0, v1);
        this.peekBuffer = arr_b1;
    }
}

