package com.google.android.exoplayer2.util;

public final class ParsableBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    public byte[] data;

    public ParsableBitArray() {
        this.data = Util.EMPTY_BYTE_ARRAY;
    }

    public ParsableBitArray(byte[] arr_b) {
        this(arr_b, arr_b.length);
    }

    public ParsableBitArray(byte[] arr_b, int v) {
        this.data = arr_b;
        this.byteLimit = v;
    }

    private void assertValidOffset() {
        Assertions.checkState(this.byteOffset >= 0 && (this.byteOffset < this.byteLimit || this.byteOffset == this.byteLimit && this.bitOffset == 0));
    }

    public int bitsLeft() {
        return (this.byteLimit - this.byteOffset) * 8 - this.bitOffset;
    }

    public void byteAlign() {
        if(this.bitOffset == 0) {
            return;
        }
        this.bitOffset = 0;
        ++this.byteOffset;
        this.assertValidOffset();
    }

    public int getBytePosition() {
        Assertions.checkState(this.bitOffset == 0);
        return this.byteOffset;
    }

    public int getPosition() {
        return this.byteOffset * 8 + this.bitOffset;
    }

    public void putInt(int v, int v1) {
        if(v1 < 0x20) {
            v &= (1 << v1) - 1;
        }
        int v2 = Math.min(8 - this.bitOffset, v1);
        int v3 = 8 - this.bitOffset - v2;
        byte[] arr_b = this.data;
        int v4 = this.byteOffset;
        byte b = (byte)((0xFF00 >> this.bitOffset | (1 << v3) - 1) & arr_b[v4]);
        arr_b[v4] = b;
        int v5 = v1 - v2;
        arr_b[v4] = (byte)(b | v >>> v5 << v3);
        int v6;
        for(v6 = v4 + 1; v5 > 8; ++v6) {
            this.data[v6] = (byte)(v >>> v5 - 8);
            v5 -= 8;
        }
        byte[] arr_b1 = this.data;
        byte b1 = (byte)(arr_b1[v6] & (1 << 8 - v5) - 1);
        arr_b1[v6] = b1;
        arr_b1[v6] = (byte)((v & (1 << v5) - 1) << 8 - v5 | b1);
        this.skipBits(v1);
        this.assertValidOffset();
    }

    public boolean readBit() {
        boolean z = (this.data[this.byteOffset] & 0x80 >> this.bitOffset) != 0;
        this.skipBit();
        return z;
    }

    public int readBits(int v) {
        if(v == 0) {
            return 0;
        }
        this.bitOffset += v;
        int v1 = 0;
        int v2;
        while((v2 = this.bitOffset) > 8) {
            this.bitOffset = v2 - 8;
            int v3 = this.byteOffset;
            this.byteOffset = v3 + 1;
            v1 |= (this.data[v3] & 0xFF) << v2 - 8;
        }
        int v4 = this.byteOffset;
        int v5 = -1 >>> 0x20 - v & (v1 | (this.data[v4] & 0xFF) >> 8 - v2);
        if(v2 == 8) {
            this.bitOffset = 0;
            this.byteOffset = v4 + 1;
        }
        this.assertValidOffset();
        return v5;
    }

    public void readBits(byte[] arr_b, int v, int v1) {
        int v2 = (v1 >> 3) + v;
        while(v < v2) {
            byte[] arr_b1 = this.data;
            int v3 = this.byteOffset;
            this.byteOffset = v3 + 1;
            int v4 = this.bitOffset;
            byte b = (byte)(arr_b1[v3] << v4);
            arr_b[v] = b;
            arr_b[v] = (byte)((0xFF & arr_b1[v3 + 1]) >> 8 - v4 | b);
            ++v;
        }
        if((v1 & 7) == 0) {
            return;
        }
        byte b1 = (byte)(arr_b[v2] & 0xFF >> (v1 & 7));
        arr_b[v2] = b1;
        int v5 = this.bitOffset;
        if(v5 + (v1 & 7) > 8) {
            int v6 = this.byteOffset;
            this.byteOffset = v6 + 1;
            arr_b[v2] = (byte)(b1 | (this.data[v6] & 0xFF) << v5);
            this.bitOffset = v5 - 8;
        }
        int v7 = this.bitOffset + (v1 & 7);
        this.bitOffset = v7;
        int v8 = this.byteOffset;
        arr_b[v2] = (byte)(((byte)((0xFF & this.data[v8]) >> 8 - v7 << 8 - (v1 & 7))) | arr_b[v2]);
        if(v7 == 8) {
            this.bitOffset = 0;
            this.byteOffset = v8 + 1;
        }
        this.assertValidOffset();
    }

    public long readBitsToLong(int v) {
        return v > 0x20 ? Util.toLong(this.readBits(v - 0x20), this.readBits(0x20)) : Util.toUnsignedLong(this.readBits(v));
    }

    public void readBytes(byte[] arr_b, int v, int v1) {
        Assertions.checkState(this.bitOffset == 0);
        System.arraycopy(this.data, this.byteOffset, arr_b, v, v1);
        this.byteOffset += v1;
        this.assertValidOffset();
    }

    public void reset(ParsableByteArray parsableByteArray0) {
        this.reset(parsableByteArray0.data, parsableByteArray0.limit());
        this.setPosition(parsableByteArray0.getPosition() * 8);
    }

    public void reset(byte[] arr_b) {
        this.reset(arr_b, arr_b.length);
    }

    public void reset(byte[] arr_b, int v) {
        this.data = arr_b;
        this.byteOffset = 0;
        this.bitOffset = 0;
        this.byteLimit = v;
    }

    public void setPosition(int v) {
        this.byteOffset = v / 8;
        this.bitOffset = v - v / 8 * 8;
        this.assertValidOffset();
    }

    public void skipBit() {
        int v = this.bitOffset + 1;
        this.bitOffset = v;
        if(v == 8) {
            this.bitOffset = 0;
            ++this.byteOffset;
        }
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

    public void skipBytes(int v) {
        Assertions.checkState(this.bitOffset == 0);
        this.byteOffset += v;
        this.assertValidOffset();
    }
}

