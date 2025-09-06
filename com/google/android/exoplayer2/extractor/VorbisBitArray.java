package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;

public final class VorbisBitArray {
    private int bitOffset;
    private final int byteLimit;
    private int byteOffset;
    private final byte[] data;

    public VorbisBitArray(byte[] arr_b) {
        this.data = arr_b;
        this.byteLimit = arr_b.length;
    }

    private void assertValidOffset() {
        Assertions.checkState(this.byteOffset >= 0 && (this.byteOffset < this.byteLimit || this.byteOffset == this.byteLimit && this.bitOffset == 0));
    }

    public int bitsLeft() {
        return (this.byteLimit - this.byteOffset) * 8 - this.bitOffset;
    }

    public int getPosition() {
        return this.byteOffset * 8 + this.bitOffset;
    }

    public boolean readBit() {
        boolean z = ((this.data[this.byteOffset] & 0xFF) >> this.bitOffset & 1) == 1;
        this.skipBits(1);
        return z;
    }

    public int readBits(int v) {
        int v1 = Math.min(v, 8 - this.bitOffset);
        int v2 = this.byteOffset + 1;
        int v3 = (this.data[this.byteOffset] & 0xFF) >> this.bitOffset & 0xFF >> 8 - v1;
        while(v1 < v) {
            v3 |= (this.data[v2] & 0xFF) << v1;
            v1 += 8;
            ++v2;
        }
        this.skipBits(v);
        return v3 & -1 >>> 0x20 - v;
    }

    public void reset() {
        this.byteOffset = 0;
        this.bitOffset = 0;
    }

    public void setPosition(int v) {
        this.byteOffset = v / 8;
        this.bitOffset = v - v / 8 * 8;
        this.assertValidOffset();
    }

    public void skipBits(int v) {
        int v1 = this.byteOffset + v / 8;
        this.byteOffset = v1;
        int v2 = v - v / 8 * 8 + this.bitOffset;
        this.bitOffset = v2;
        if(v2 > 7) {
            this.byteOffset = v1 + 1;
            this.bitOffset = v2 - 8;
        }
        this.assertValidOffset();
    }
}

