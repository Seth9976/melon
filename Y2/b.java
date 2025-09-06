package y2;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

public class b extends InputStream implements DataInput {
    public final DataInputStream a;
    public int b;
    public ByteOrder c;
    public byte[] d;
    public final int e;

    public b(InputStream inputStream0) {
        this(inputStream0, 0);
    }

    public b(InputStream inputStream0, int v) {
        ByteOrder byteOrder0 = ByteOrder.BIG_ENDIAN;
        super();
        DataInputStream dataInputStream0 = new DataInputStream(inputStream0);
        this.a = dataInputStream0;
        dataInputStream0.mark(0);
        this.b = 0;
        this.c = byteOrder0;
        this.e = inputStream0 instanceof b ? ((b)inputStream0).e : -1;
    }

    public b(byte[] arr_b) {
        this(new ByteArrayInputStream(arr_b), 0);
        this.e = arr_b.length;
    }

    @Override
    public final int available() {
        return this.a.available();
    }

    public final void c(int v) {
        int v1;
        for(v1 = 0; v1 < v; v1 += v3) {
            int v2 = v - v1;
            DataInputStream dataInputStream0 = this.a;
            int v3 = (int)dataInputStream0.skip(((long)v2));
            if(v3 <= 0) {
                if(this.d == null) {
                    this.d = new byte[0x2000];
                }
                v3 = dataInputStream0.read(this.d, 0, Math.min(0x2000, v2));
                if(v3 == -1) {
                    throw new EOFException("Reached EOF while skipping " + v + " bytes.");
                }
            }
        }
        this.b += v1;
    }

    @Override
    public final void mark(int v) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    @Override
    public final int read() {
        ++this.b;
        return this.a.read();
    }

    @Override
    public final int read(byte[] arr_b, int v, int v1) {
        int v2 = this.a.read(arr_b, v, v1);
        this.b += v2;
        return v2;
    }

    @Override
    public final boolean readBoolean() {
        ++this.b;
        return this.a.readBoolean();
    }

    @Override
    public final byte readByte() {
        ++this.b;
        int v = this.a.read();
        if(v < 0) {
            throw new EOFException();
        }
        return (byte)v;
    }

    @Override
    public final char readChar() {
        this.b += 2;
        return this.a.readChar();
    }

    @Override
    public final double readDouble() {
        return Double.longBitsToDouble(this.readLong());
    }

    @Override
    public final float readFloat() {
        return Float.intBitsToFloat(this.readInt());
    }

    @Override
    public final void readFully(byte[] arr_b) {
        this.b += arr_b.length;
        this.a.readFully(arr_b);
    }

    @Override
    public final void readFully(byte[] arr_b, int v, int v1) {
        this.b += v1;
        this.a.readFully(arr_b, v, v1);
    }

    @Override
    public final int readInt() {
        this.b += 4;
        int v = this.a.read();
        int v1 = this.a.read();
        int v2 = this.a.read();
        int v3 = this.a.read();
        if((v | v1 | v2 | v3) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder0 = this.c;
        if(byteOrder0 == ByteOrder.LITTLE_ENDIAN) {
            return (v3 << 24) + (v2 << 16) + (v1 << 8) + v;
        }
        if(byteOrder0 != ByteOrder.BIG_ENDIAN) {
            throw new IOException("Invalid byte order: " + this.c);
        }
        return (v << 24) + (v1 << 16) + (v2 << 8) + v3;
    }

    @Override
    public final String readLine() {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override
    public final long readLong() {
        this.b += 8;
        int v = this.a.read();
        int v1 = this.a.read();
        int v2 = this.a.read();
        int v3 = this.a.read();
        int v4 = this.a.read();
        int v5 = this.a.read();
        int v6 = this.a.read();
        int v7 = this.a.read();
        if((v | v1 | v2 | v3 | v4 | v5 | v6 | v7) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder0 = this.c;
        if(byteOrder0 == ByteOrder.LITTLE_ENDIAN) {
            return (((long)v7) << 56) + (((long)v6) << 0x30) + (((long)v5) << 40) + (((long)v4) << 0x20) + (((long)v3) << 24) + (((long)v2) << 16) + (((long)v1) << 8) + ((long)v);
        }
        if(byteOrder0 != ByteOrder.BIG_ENDIAN) {
            throw new IOException("Invalid byte order: " + this.c);
        }
        return (((long)v) << 56) + (((long)v1) << 0x30) + (((long)v2) << 40) + (((long)v3) << 0x20) + (((long)v4) << 24) + (((long)v5) << 16) + (((long)v6) << 8) + ((long)v7);
    }

    @Override
    public final short readShort() {
        this.b += 2;
        int v = this.a.read();
        int v1 = this.a.read();
        if((v | v1) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder0 = this.c;
        if(byteOrder0 == ByteOrder.LITTLE_ENDIAN) {
            return (short)((v1 << 8) + v);
        }
        if(byteOrder0 != ByteOrder.BIG_ENDIAN) {
            throw new IOException("Invalid byte order: " + this.c);
        }
        return (short)((v << 8) + v1);
    }

    @Override
    public final String readUTF() {
        this.b += 2;
        return this.a.readUTF();
    }

    @Override
    public final int readUnsignedByte() {
        ++this.b;
        return this.a.readUnsignedByte();
    }

    @Override
    public final int readUnsignedShort() {
        this.b += 2;
        int v = this.a.read();
        int v1 = this.a.read();
        if((v | v1) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder0 = this.c;
        if(byteOrder0 == ByteOrder.LITTLE_ENDIAN) {
            return (v1 << 8) + v;
        }
        if(byteOrder0 != ByteOrder.BIG_ENDIAN) {
            throw new IOException("Invalid byte order: " + this.c);
        }
        return (v << 8) + v1;
    }

    @Override
    public final void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    @Override
    public final int skipBytes(int v) {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }
}

