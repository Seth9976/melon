package io.netty.buffer;

import U4.x;
import io.netty.util.internal.ObjectUtil;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.InputStream;

public class ByteBufInputStream extends InputStream implements DataInput {
    private final ByteBuf buffer;
    private boolean closed;
    private final int endIndex;
    private StringBuilder lineBuf;
    private final boolean releaseOnClose;
    private final int startIndex;

    public ByteBufInputStream(ByteBuf byteBuf0) {
        this(byteBuf0, byteBuf0.readableBytes());
    }

    public ByteBufInputStream(ByteBuf byteBuf0, int v) {
        this(byteBuf0, v, false);
    }

    public ByteBufInputStream(ByteBuf byteBuf0, int v, boolean z) {
        ObjectUtil.checkNotNull(byteBuf0, "buffer");
        if(v < 0) {
            if(z) {
                byteBuf0.release();
            }
            ObjectUtil.checkPositiveOrZero(v, "length");
        }
        if(v > byteBuf0.readableBytes()) {
            if(z) {
                byteBuf0.release();
            }
            StringBuilder stringBuilder0 = x.n(v, "Too many bytes to be read - Needs ", ", maximum is ");
            stringBuilder0.append(byteBuf0.readableBytes());
            throw new IndexOutOfBoundsException(stringBuilder0.toString());
        }
        this.releaseOnClose = z;
        this.buffer = byteBuf0;
        int v1 = byteBuf0.readerIndex();
        this.startIndex = v1;
        this.endIndex = v1 + v;
        byteBuf0.markReaderIndex();
    }

    public ByteBufInputStream(ByteBuf byteBuf0, boolean z) {
        this(byteBuf0, byteBuf0.readableBytes(), z);
    }

    @Override
    public int available() {
        int v = this.buffer.readerIndex();
        return this.endIndex - v;
    }

    private void checkAvailable(int v) {
        if(v < 0) {
            throw new IndexOutOfBoundsException("fieldSize cannot be a negative number");
        }
        if(v <= this.available()) {
            return;
        }
        StringBuilder stringBuilder0 = x.n(v, "fieldSize is too long! Length is ", ", but maximum is ");
        stringBuilder0.append(this.available());
        throw new EOFException(stringBuilder0.toString());
    }

    @Override
    public void close() {
        try {
            super.close();
        }
        catch(Throwable throwable0) {
            if(this.releaseOnClose && !this.closed) {
                this.closed = true;
                this.buffer.release();
            }
            throw throwable0;
        }
        if(this.releaseOnClose && !this.closed) {
            this.closed = true;
            this.buffer.release();
        }
    }

    @Override
    public void mark(int v) {
        this.buffer.markReaderIndex();
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public int read() {
        return this.available() == 0 ? -1 : this.buffer.readByte() & 0xFF;
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        int v2 = this.available();
        if(v2 == 0) {
            return -1;
        }
        int v3 = Math.min(v2, v1);
        this.buffer.readBytes(arr_b, v, v3);
        return v3;
    }

    @Override
    public boolean readBoolean() {
        this.checkAvailable(1);
        return this.read() != 0;
    }

    @Override
    public byte readByte() {
        if(this.available() == 0) {
            throw new EOFException();
        }
        return this.buffer.readByte();
    }

    public int readBytes() {
        return this.buffer.readerIndex() - this.startIndex;
    }

    @Override
    public char readChar() {
        return (char)this.readShort();
    }

    @Override
    public double readDouble() {
        return Double.longBitsToDouble(this.readLong());
    }

    @Override
    public float readFloat() {
        return Float.intBitsToFloat(this.readInt());
    }

    @Override
    public void readFully(byte[] arr_b) {
        this.readFully(arr_b, 0, arr_b.length);
    }

    @Override
    public void readFully(byte[] arr_b, int v, int v1) {
        this.checkAvailable(v1);
        this.buffer.readBytes(arr_b, v, v1);
    }

    @Override
    public int readInt() {
        this.checkAvailable(4);
        return this.buffer.readInt();
    }

    @Override
    public String readLine() {
        int v = this.available();
        if(v == 0) {
            return null;
        }
        StringBuilder stringBuilder0 = this.lineBuf;
        if(stringBuilder0 != null) {
            stringBuilder0.setLength(0);
        }
        do {
            int v1 = this.buffer.readUnsignedByte();
            --v;
            if(v1 == 10) {
                return this.lineBuf == null || this.lineBuf.length() <= 0 ? "" : this.lineBuf.toString();
            }
            if(v1 == 13) {
                goto label_15;
            }
            if(this.lineBuf == null) {
                this.lineBuf = new StringBuilder();
            }
            this.lineBuf.append(((char)v1));
        }
        while(v > 0);
        return this.lineBuf == null || this.lineBuf.length() <= 0 ? "" : this.lineBuf.toString();
    label_15:
        if(v > 0) {
            int v2 = this.buffer.readerIndex();
            if(((char)this.buffer.getUnsignedByte(v2)) == 10) {
                this.buffer.skipBytes(1);
            }
        }
        return this.lineBuf == null || this.lineBuf.length() <= 0 ? "" : this.lineBuf.toString();
    }

    @Override
    public long readLong() {
        this.checkAvailable(8);
        return this.buffer.readLong();
    }

    @Override
    public short readShort() {
        this.checkAvailable(2);
        return this.buffer.readShort();
    }

    @Override
    public String readUTF() {
        return DataInputStream.readUTF(this);
    }

    @Override
    public int readUnsignedByte() {
        return this.readByte() & 0xFF;
    }

    @Override
    public int readUnsignedShort() {
        return this.readShort() & 0xFFFF;
    }

    @Override
    public void reset() {
        this.buffer.resetReaderIndex();
    }

    @Override
    public long skip(long v) {
        return v <= 0x7FFFFFFFL ? ((long)this.skipBytes(((int)v))) : ((long)this.skipBytes(0x7FFFFFFF));
    }

    @Override
    public int skipBytes(int v) {
        int v1 = Math.min(this.available(), v);
        this.buffer.skipBytes(v1);
        return v1;
    }
}

