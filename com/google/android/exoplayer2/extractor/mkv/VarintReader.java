package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;

final class VarintReader {
    private static final int STATE_BEGIN_READING = 0;
    private static final int STATE_READ_CONTENTS = 1;
    private static final long[] VARINT_LENGTH_MASKS;
    private int length;
    private final byte[] scratch;
    private int state;

    static {
        VarintReader.VARINT_LENGTH_MASKS = new long[]{0x80L, 0x40L, 0x20L, 16L, 8L, 4L, 2L, 1L};
    }

    public VarintReader() {
        this.scratch = new byte[8];
    }

    public static long assembleVarint(byte[] arr_b, int v, boolean z) {
        long v1 = ((long)arr_b[0]) & 0xFFL;
        if(z) {
            v1 &= ~VarintReader.VARINT_LENGTH_MASKS[v - 1];
        }
        for(int v2 = 1; v2 < v; ++v2) {
            v1 = v1 << 8 | ((long)arr_b[v2]) & 0xFFL;
        }
        return v1;
    }

    public int getLastLength() {
        return this.length;
    }

    public static int parseUnsignedVarintLength(int v) {
        for(int v1 = 0; true; ++v1) {
            long[] arr_v = VarintReader.VARINT_LENGTH_MASKS;
            if(v1 >= arr_v.length) {
                break;
            }
            if((arr_v[v1] & ((long)v)) != 0L) {
                return v1 + 1;
            }
        }
        return -1;
    }

    public long readUnsignedVarint(ExtractorInput extractorInput0, boolean z, boolean z1, int v) {
        if(this.state == 0) {
            if(!extractorInput0.readFully(this.scratch, 0, 1, z)) {
                return -1L;
            }
            int v1 = VarintReader.parseUnsignedVarintLength(this.scratch[0] & 0xFF);
            this.length = v1;
            if(v1 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.state = 1;
        }
        int v2 = this.length;
        if(v2 > v) {
            this.state = 0;
            return -2L;
        }
        if(v2 != 1) {
            extractorInput0.readFully(this.scratch, 1, v2 - 1);
        }
        this.state = 0;
        return VarintReader.assembleVarint(this.scratch, this.length, z1);
    }

    public void reset() {
        this.state = 0;
        this.length = 0;
    }
}

