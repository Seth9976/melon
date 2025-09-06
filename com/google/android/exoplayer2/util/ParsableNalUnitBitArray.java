package com.google.android.exoplayer2.util;

public final class ParsableNalUnitBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    private byte[] data;

    public ParsableNalUnitBitArray(byte[] arr_b, int v, int v1) {
        this.reset(arr_b, v, v1);
    }

    private void assertValidOffset() {
        Assertions.checkState(this.byteOffset >= 0 && (this.byteOffset < this.byteLimit || this.byteOffset == this.byteLimit && this.bitOffset == 0));
    }

    public boolean canReadBits(int v) {
        int v1 = this.byteOffset;
        int v2 = v1 + v / 8;
        int v3 = this.bitOffset + v - v / 8 * 8;
        if(v3 > 7) {
            ++v2;
            v3 -= 8;
        }
        while(true) {
            ++v1;
            if(v1 > v2 || v2 >= this.byteLimit) {
                break;
            }
            if(this.shouldSkipByte(v1)) {
                ++v2;
                v1 += 2;
            }
        }
        return v2 < this.byteLimit || v2 == this.byteLimit && v3 == 0;
    }

    public boolean canReadExpGolombCodedNum() {
        int v = this.byteOffset;
        int v1 = this.bitOffset;
        int v2;
        for(v2 = 0; this.byteOffset < this.byteLimit && !this.readBit(); ++v2) {
        }
        boolean z = this.byteOffset == this.byteLimit;
        this.byteOffset = v;
        this.bitOffset = v1;
        return !z && this.canReadBits(v2 * 2 + 1);
    }

    public boolean readBit() {
        boolean z = (this.data[this.byteOffset] & 0x80 >> this.bitOffset) != 0;
        this.skipBit();
        return z;
    }

    public int readBits(int v) {
        int v3;
        int v2;
        this.bitOffset += v;
        int v1 = 0;
        while(true) {
            v2 = this.bitOffset;
            v3 = 2;
            if(v2 <= 8) {
                break;
            }
            this.bitOffset = v2 - 8;
            int v4 = this.byteOffset;
            v1 |= (this.data[v4] & 0xFF) << v2 - 8;
            if(!this.shouldSkipByte(v4 + 1)) {
                v3 = 1;
            }
            this.byteOffset = v4 + v3;
        }
        int v5 = this.byteOffset;
        int v6 = -1 >>> 0x20 - v & (v1 | (this.data[v5] & 0xFF) >> 8 - v2);
        if(v2 == 8) {
            this.bitOffset = 0;
            if(!this.shouldSkipByte(v5 + 1)) {
                v3 = 1;
            }
            this.byteOffset = v5 + v3;
        }
        this.assertValidOffset();
        return v6;
    }

    private int readExpGolombCodeNum() {
        int v = 0;
        int v1;
        for(v1 = 0; !this.readBit(); ++v1) {
        }
        if(v1 > 0) {
            v = this.readBits(v1);
        }
        return (1 << v1) - 1 + v;
    }

    public int readSignedExpGolombCodedInt() {
        int v = this.readExpGolombCodeNum();
        return v % 2 == 0 ? -((v + 1) / 2) : (v + 1) / 2;
    }

    public int readUnsignedExpGolombCodedInt() {
        return this.readExpGolombCodeNum();
    }

    public void reset(byte[] arr_b, int v, int v1) {
        this.data = arr_b;
        this.byteOffset = v;
        this.byteLimit = v1;
        this.bitOffset = 0;
        this.assertValidOffset();
    }

    private boolean shouldSkipByte(int v) {
        return 2 <= v && v < this.byteLimit && (this.data[v] == 3 && this.data[v - 2] == 0 && this.data[v - 1] == 0);
    }

    public void skipBit() {
        int v = 1;
        int v1 = this.bitOffset + 1;
        this.bitOffset = v1;
        if(v1 == 8) {
            this.bitOffset = 0;
            int v2 = this.byteOffset;
            if(this.shouldSkipByte(v2 + 1)) {
                v = 2;
            }
            this.byteOffset = v2 + v;
        }
        this.assertValidOffset();
    }

    public void skipBits(int v) {
        int v1 = this.byteOffset;
        int v2 = v1 + v / 8;
        this.byteOffset = v2;
        int v3 = v - v / 8 * 8 + this.bitOffset;
        this.bitOffset = v3;
        if(v3 > 7) {
            this.byteOffset = v2 + 1;
            this.bitOffset = v3 - 8;
        }
        while(true) {
            ++v1;
            if(v1 > this.byteOffset) {
                break;
            }
            if(this.shouldSkipByte(v1)) {
                ++this.byteOffset;
                v1 += 2;
            }
        }
        this.assertValidOffset();
    }
}

