package com.google.android.exoplayer2.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class ParsableByteArray {
    public byte[] data;
    private int limit;
    private int position;

    public ParsableByteArray() {
        this.data = Util.EMPTY_BYTE_ARRAY;
    }

    public ParsableByteArray(int v) {
        this.data = new byte[v];
        this.limit = v;
    }

    public ParsableByteArray(byte[] arr_b) {
        this.data = arr_b;
        this.limit = arr_b.length;
    }

    public ParsableByteArray(byte[] arr_b, int v) {
        this.data = arr_b;
        this.limit = v;
    }

    public int bytesLeft() {
        return this.limit - this.position;
    }

    public int capacity() {
        return this.data.length;
    }

    public int getPosition() {
        return this.position;
    }

    public int limit() {
        return this.limit;
    }

    public char peekChar() {
        return (char)(this.data[this.position + 1] & 0xFF | (this.data[this.position] & 0xFF) << 8);
    }

    public int peekUnsignedByte() {
        return this.data[this.position] & 0xFF;
    }

    public void readBytes(ParsableBitArray parsableBitArray0, int v) {
        this.readBytes(parsableBitArray0.data, 0, v);
        parsableBitArray0.setPosition(0);
    }

    public void readBytes(ByteBuffer byteBuffer0, int v) {
        byteBuffer0.put(this.data, this.position, v);
        this.position += v;
    }

    public void readBytes(byte[] arr_b, int v, int v1) {
        System.arraycopy(this.data, this.position, arr_b, v, v1);
        this.position += v1;
    }

    public double readDouble() {
        return Double.longBitsToDouble(this.readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(this.readInt());
    }

    public int readInt() {
        int v = this.position;
        this.position = v + 4;
        return this.data[v + 3] & 0xFF | ((this.data[v + 1] & 0xFF) << 16 | (this.data[v] & 0xFF) << 24 | (this.data[v + 2] & 0xFF) << 8);
    }

    public int readInt24() {
        int v = this.position;
        this.position = v + 3;
        return this.data[v + 2] & 0xFF | ((this.data[v + 1] & 0xFF) << 8 | (this.data[v] & 0xFF) << 24 >> 8);
    }

    public String readLine() {
        if(this.bytesLeft() == 0) {
            return null;
        }
        int v;
        for(v = this.position; v < this.limit && !Util.isLinebreak(this.data[v]); ++v) {
        }
        int v1 = this.position;
        if(v - v1 >= 3 && (this.data[v1] == -17 && this.data[v1 + 1] == -69 && this.data[v1 + 2] == -65)) {
            this.position = v1 + 3;
        }
        String s = Util.fromUtf8Bytes(this.data, this.position, v - this.position);
        this.position = v;
        int v2 = this.limit;
        if(v != v2) {
            byte[] arr_b = this.data;
            if(arr_b[v] == 13) {
                this.position = v + 1;
                if(v + 1 != v2) {
                    goto label_17;
                }
            }
            else {
            label_17:
                int v3 = this.position;
                if(arr_b[v3] == 10) {
                    this.position = v3 + 1;
                }
            }
        }
        return s;
    }

    public int readLittleEndianInt() {
        int v = this.position;
        this.position = v + 4;
        return (this.data[v + 3] & 0xFF) << 24 | ((this.data[v + 1] & 0xFF) << 8 | this.data[v] & 0xFF | (this.data[v + 2] & 0xFF) << 16);
    }

    public int readLittleEndianInt24() {
        int v = this.position;
        this.position = v + 3;
        return (this.data[v + 2] & 0xFF) << 16 | ((this.data[v + 1] & 0xFF) << 8 | this.data[v] & 0xFF);
    }

    public long readLittleEndianLong() {
        int v = this.position;
        this.position = v + 8;
        return (((long)this.data[v + 7]) & 0xFFL) << 56 | (((long)this.data[v]) & 0xFFL | (((long)this.data[v + 1]) & 0xFFL) << 8 | (((long)this.data[v + 2]) & 0xFFL) << 16 | (((long)this.data[v + 3]) & 0xFFL) << 24 | (((long)this.data[v + 4]) & 0xFFL) << 0x20 | (((long)this.data[v + 5]) & 0xFFL) << 40 | (((long)this.data[v + 6]) & 0xFFL) << 0x30);
    }

    public short readLittleEndianShort() {
        int v = this.position;
        this.position = v + 2;
        return (short)((this.data[v + 1] & 0xFF) << 8 | this.data[v] & 0xFF);
    }

    public long readLittleEndianUnsignedInt() {
        int v = this.position;
        this.position = v + 4;
        return (((long)this.data[v + 3]) & 0xFFL) << 24 | (((long)this.data[v]) & 0xFFL | (((long)this.data[v + 1]) & 0xFFL) << 8 | (((long)this.data[v + 2]) & 0xFFL) << 16);
    }

    public int readLittleEndianUnsignedInt24() {
        int v = this.position;
        this.position = v + 3;
        return (this.data[v + 2] & 0xFF) << 16 | ((this.data[v + 1] & 0xFF) << 8 | this.data[v] & 0xFF);
    }

    public int readLittleEndianUnsignedIntToInt() {
        int v = this.readLittleEndianInt();
        if(v < 0) {
            throw new IllegalStateException("Top bit not zero: " + v);
        }
        return v;
    }

    public int readLittleEndianUnsignedShort() {
        int v = this.position;
        this.position = v + 2;
        return (this.data[v + 1] & 0xFF) << 8 | this.data[v] & 0xFF;
    }

    public long readLong() {
        int v = this.position;
        this.position = v + 8;
        return ((long)this.data[v + 7]) & 0xFFL | ((((long)this.data[v]) & 0xFFL) << 56 | (((long)this.data[v + 1]) & 0xFFL) << 0x30 | (((long)this.data[v + 2]) & 0xFFL) << 40 | (((long)this.data[v + 3]) & 0xFFL) << 0x20 | (((long)this.data[v + 4]) & 0xFFL) << 24 | (((long)this.data[v + 5]) & 0xFFL) << 16 | (((long)this.data[v + 6]) & 0xFFL) << 8);
    }

    public String readNullTerminatedString() {
        if(this.bytesLeft() == 0) {
            return null;
        }
        int v;
        for(v = this.position; v < this.limit && this.data[v] != 0; ++v) {
        }
        String s = Util.fromUtf8Bytes(this.data, this.position, v - this.position);
        this.position = v;
        if(v < this.limit) {
            this.position = v + 1;
        }
        return s;
    }

    public String readNullTerminatedString(int v) {
        if(v == 0) {
            return "";
        }
        int v1 = this.position + v - 1;
        String s = Util.fromUtf8Bytes(this.data, this.position, (v1 >= this.limit || this.data[v1] != 0 ? v : v - 1));
        this.position += v;
        return s;
    }

    public short readShort() {
        int v = this.position;
        this.position = v + 2;
        return (short)(this.data[v + 1] & 0xFF | (this.data[v] & 0xFF) << 8);
    }

    public String readString(int v) {
        return this.readString(v, Charset.forName("UTF-8"));
    }

    public String readString(int v, Charset charset0) {
        String s = new String(this.data, this.position, v, charset0);
        this.position += v;
        return s;
    }

    public int readSynchSafeInt() {
        return this.readUnsignedByte() << 21 | this.readUnsignedByte() << 14 | this.readUnsignedByte() << 7 | this.readUnsignedByte();
    }

    public int readUnsignedByte() {
        int v = this.position;
        this.position = v + 1;
        return this.data[v] & 0xFF;
    }

    public int readUnsignedFixedPoint1616() {
        int v = this.position;
        this.position = v + 4;
        return this.data[v + 1] & 0xFF | (this.data[v] & 0xFF) << 8;
    }

    public long readUnsignedInt() {
        int v = this.position;
        this.position = v + 4;
        return ((long)this.data[v + 3]) & 0xFFL | ((((long)this.data[v]) & 0xFFL) << 24 | (((long)this.data[v + 1]) & 0xFFL) << 16 | (((long)this.data[v + 2]) & 0xFFL) << 8);
    }

    public int readUnsignedInt24() {
        int v = this.position;
        this.position = v + 3;
        return this.data[v + 2] & 0xFF | ((this.data[v + 1] & 0xFF) << 8 | (this.data[v] & 0xFF) << 16);
    }

    public int readUnsignedIntToInt() {
        int v = this.readInt();
        if(v < 0) {
            throw new IllegalStateException("Top bit not zero: " + v);
        }
        return v;
    }

    public long readUnsignedLongToLong() {
        long v = this.readLong();
        if(v < 0L) {
            throw new IllegalStateException("Top bit not zero: " + v);
        }
        return v;
    }

    public int readUnsignedShort() {
        int v = this.position;
        this.position = v + 2;
        return this.data[v + 1] & 0xFF | (this.data[v] & 0xFF) << 8;
    }

    public long readUtf8EncodedLong() {
        int v3;
        int v2;
        long v = (long)this.data[this.position];
        int v1 = 7;
        while(true) {
            v2 = 1;
            if(v1 >= 0) {
                if((((long)(1 << v1)) & v) == 0L) {
                    if(v1 < 6) {
                        v &= (long)((1 << v1) - 1);
                        v3 = 7 - v1;
                        break;
                    }
                    if(v1 == 7) {
                        v3 = 1;
                        break;
                    }
                }
                else {
                    --v1;
                    continue;
                }
            }
            v3 = 0;
            break;
        }
        if(v3 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + v);
        }
        while(v2 < v3) {
            int v4 = this.data[this.position + v2];
            if((v4 & 0xC0) != 0x80) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + v);
            }
            v = v << 6 | ((long)(v4 & 0x3F));
            ++v2;
        }
        this.position += v3;
        return v;
    }

    public void reset() {
        this.position = 0;
        this.limit = 0;
    }

    public void reset(int v) {
        this.reset((this.capacity() >= v ? this.data : new byte[v]), v);
    }

    public void reset(byte[] arr_b) {
        this.reset(arr_b, arr_b.length);
    }

    public void reset(byte[] arr_b, int v) {
        this.data = arr_b;
        this.limit = v;
        this.position = 0;
    }

    public void setLimit(int v) {
        Assertions.checkArgument(v >= 0 && v <= this.data.length);
        this.limit = v;
    }

    public void setPosition(int v) {
        Assertions.checkArgument(v >= 0 && v <= this.limit);
        this.position = v;
    }

    public void skipBytes(int v) {
        this.setPosition(this.position + v);
    }
}

