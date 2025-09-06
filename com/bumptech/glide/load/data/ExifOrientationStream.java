package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class ExifOrientationStream extends FilterInputStream {
    private static final byte[] EXIF_SEGMENT = null;
    private static final int ORIENTATION_POSITION = 0;
    private static final int SEGMENT_LENGTH = 0;
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;

    static {
        ExifOrientationStream.EXIF_SEGMENT = new byte[]{-1, (byte)0xE1, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        ExifOrientationStream.SEGMENT_LENGTH = 29;
        ExifOrientationStream.ORIENTATION_POSITION = 0x1F;
    }

    public ExifOrientationStream(InputStream inputStream0, int v) {
        super(inputStream0);
        if(v < -1 || v > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + v);
        }
        this.orientation = (byte)v;
    }

    @Override
    public void mark(int v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public int read() {
        int v2;
        int v = this.position;
        if(v >= 2) {
            int v1 = ExifOrientationStream.ORIENTATION_POSITION;
            if(v > v1) {
                v2 = super.read();
            }
            else if(v == v1) {
                v2 = this.orientation;
            }
            else {
                v2 = ExifOrientationStream.EXIF_SEGMENT[v - 2] & 0xFF;
            }
        }
        else {
            v2 = super.read();
        }
        if(v2 != -1) {
            ++this.position;
        }
        return v2;
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        int v4;
        int v2 = this.position;
        int v3 = ExifOrientationStream.ORIENTATION_POSITION;
        if(v2 > v3) {
            v4 = super.read(arr_b, v, v1);
        }
        else if(v2 == v3) {
            arr_b[v] = this.orientation;
            v4 = 1;
        }
        else if(v2 < 2) {
            v4 = super.read(arr_b, v, 2 - v2);
        }
        else {
            int v5 = Math.min(v3 - v2, v1);
            System.arraycopy(ExifOrientationStream.EXIF_SEGMENT, this.position - 2, arr_b, v, v5);
            v4 = v5;
        }
        if(v4 > 0) {
            this.position += v4;
        }
        return v4;
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override
    public long skip(long v) {
        long v1 = super.skip(v);
        if(v1 > 0L) {
            this.position = (int)(((long)this.position) + v1);
        }
        return v1;
    }
}

