package org.gagravarr.ogg;

import androidx.appcompat.app.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class IOUtils {
    protected static final Charset UTF8;

    static {
        IOUtils.UTF8 = Charset.forName("UTF-8");
    }

    public static boolean byteRangeMatches(byte[] arr_b, byte[] arr_b1, int v) {
        for(int v1 = 0; v1 < arr_b.length; ++v1) {
            if(arr_b[v1] != arr_b1[v1 + v]) {
                return false;
            }
        }
        return true;
    }

    public static byte fromInt(int v) {
        if(v > 0x100) {
            throw new IllegalArgumentException("Number " + v + " too big");
        }
        return v <= 0x7F ? ((byte)v) : ((byte)(v - 0x100));
    }

    public static int getInt(int v, int v1) {
        return (v1 << 8) + v;
    }

    public static long getInt(int v, int v1, int v2) {
        return (long)((v2 << 16) + (v1 << 8) + v);
    }

    public static long getInt(int v, int v1, int v2, int v3) {
        return (long)((v3 << 24) + (v2 << 16) + (v1 << 8) + v);
    }

    public static long getInt(int v, int v1, int v2, int v3, int v4) {
        return (long)((v4 << 0x20) + (v3 << 24) + (v2 << 16) + (v1 << 8) + v);
    }

    public static long getInt(int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
        return v != 0xFF || v1 != 0xFF || v3 != 0xFF || v4 != 0xFF || v5 != 0xFF || v6 != 0xFF || v7 != 0xFF ? ((long)(v7 << 56)) + ((long)(v6 << 0x30)) + ((long)(v5 << 40)) + ((long)(v4 << 0x20)) + ((long)(v3 << 24)) + ((long)(v2 << 16)) + ((long)(v1 << 8)) + ((long)v) : -1L;
    }

    public static int getInt2(byte[] arr_b) {
        return IOUtils.getInt2(arr_b, 0);
    }

    public static int getInt2(byte[] arr_b, int v) {
        return IOUtils.getInt(arr_b[v] & 0xFF, arr_b[v + 1] & 0xFF);
    }

    public static int getInt2BE(byte[] arr_b) {
        return IOUtils.getInt2BE(arr_b, 0);
    }

    public static int getInt2BE(byte[] arr_b, int v) {
        return IOUtils.getIntBE(arr_b[v] & 0xFF, arr_b[v + 1] & 0xFF);
    }

    public static long getInt3(byte[] arr_b) {
        return IOUtils.getInt3(arr_b, 0);
    }

    public static long getInt3(byte[] arr_b, int v) {
        return IOUtils.getInt(arr_b[v] & 0xFF, arr_b[v + 1] & 0xFF, arr_b[v + 2] & 0xFF);
    }

    public static long getInt3BE(byte[] arr_b) {
        return IOUtils.getInt3BE(arr_b, 0);
    }

    public static long getInt3BE(byte[] arr_b, int v) {
        return IOUtils.getIntBE(arr_b[v] & 0xFF, arr_b[v + 1] & 0xFF, arr_b[v + 2] & 0xFF);
    }

    public static long getInt4(byte[] arr_b) {
        return IOUtils.getInt4(arr_b, 0);
    }

    public static long getInt4(byte[] arr_b, int v) {
        return IOUtils.getInt(arr_b[v] & 0xFF, arr_b[v + 1] & 0xFF, arr_b[v + 2] & 0xFF, arr_b[v + 3] & 0xFF);
    }

    public static long getInt4BE(byte[] arr_b) {
        return IOUtils.getInt4BE(arr_b, 0);
    }

    public static long getInt4BE(byte[] arr_b, int v) {
        return IOUtils.getIntBE(arr_b[v] & 0xFF, arr_b[v + 1] & 0xFF, arr_b[v + 2] & 0xFF, arr_b[v + 3] & 0xFF);
    }

    public static long getInt5(byte[] arr_b) {
        return IOUtils.getInt5(arr_b, 0);
    }

    public static long getInt5(byte[] arr_b, int v) {
        return IOUtils.getInt(arr_b[v] & 0xFF, arr_b[v + 1] & 0xFF, arr_b[v + 2] & 0xFF, arr_b[v + 3] & 0xFF, arr_b[v + 4] & 0xFF);
    }

    public static long getInt8(byte[] arr_b) {
        return IOUtils.getInt8(arr_b, 0);
    }

    public static long getInt8(byte[] arr_b, int v) {
        return IOUtils.getInt(arr_b[v] & 0xFF, arr_b[v + 1] & 0xFF, arr_b[v + 2] & 0xFF, arr_b[v + 3] & 0xFF, arr_b[v + 4] & 0xFF, arr_b[v + 5] & 0xFF, arr_b[v + 6] & 0xFF, arr_b[v + 7] & 0xFF);
    }

    public static int getIntBE(int v, int v1) {
        return (v << 8) + v1;
    }

    public static long getIntBE(int v, int v1, int v2) {
        return (long)((v << 16) + (v1 << 8) + v2);
    }

    public static long getIntBE(int v, int v1, int v2, int v3) {
        return (long)((v << 24) + (v1 << 16) + (v2 << 8) + v3);
    }

    public static String getUTF8(byte[] arr_b, int v, int v1) {
        return new String(arr_b, v, v1, IOUtils.UTF8);
    }

    public static void putInt2(byte[] arr_b, int v, int v1) {
        arr_b[v] = (byte)(v1 & 0xFF);
        arr_b[v + 1] = (byte)(v1 >>> 8 & 0xFF);
    }

    public static void putInt2BE(byte[] arr_b, int v, int v1) {
        arr_b[v + 1] = (byte)(v1 & 0xFF);
        arr_b[v] = (byte)(v1 >>> 8 & 0xFF);
    }

    public static void putInt3(byte[] arr_b, int v, long v1) {
        arr_b[v] = (byte)(((int)(v1 & 0xFFL)));
        arr_b[v + 1] = (byte)(((int)(v1 >>> 8 & 0xFFL)));
        arr_b[v + 2] = (byte)(((int)(v1 >>> 16 & 0xFFL)));
    }

    public static void putInt3BE(byte[] arr_b, int v, long v1) {
        arr_b[v + 2] = (byte)(((int)(v1 & 0xFFL)));
        arr_b[v + 1] = (byte)(((int)(v1 >>> 8 & 0xFFL)));
        arr_b[v] = (byte)(((int)(v1 >>> 16 & 0xFFL)));
    }

    public static void putInt4(byte[] arr_b, int v, long v1) {
        arr_b[v] = (byte)(((int)(v1 & 0xFFL)));
        arr_b[v + 1] = (byte)(((int)(v1 >>> 8 & 0xFFL)));
        arr_b[v + 2] = (byte)(((int)(v1 >>> 16 & 0xFFL)));
        arr_b[v + 3] = (byte)(((int)(v1 >>> 24 & 0xFFL)));
    }

    public static void putInt4BE(byte[] arr_b, int v, long v1) {
        arr_b[v + 3] = (byte)(((int)(v1 & 0xFFL)));
        arr_b[v + 2] = (byte)(((int)(v1 >>> 8 & 0xFFL)));
        arr_b[v + 1] = (byte)(((int)(v1 >>> 16 & 0xFFL)));
        arr_b[v] = (byte)(((int)(v1 >>> 24 & 0xFFL)));
    }

    public static void putInt5(byte[] arr_b, int v, long v1) {
        arr_b[v] = (byte)(((int)(v1 & 0xFFL)));
        arr_b[v + 1] = (byte)(((int)(v1 >>> 8 & 0xFFL)));
        arr_b[v + 2] = (byte)(((int)(v1 >>> 16 & 0xFFL)));
        arr_b[v + 3] = (byte)(((int)(v1 >>> 24 & 0xFFL)));
        arr_b[v + 4] = (byte)(((int)(v1 >>> 0x20 & 0xFFL)));
    }

    public static void putInt8(byte[] arr_b, int v, long v1) {
        arr_b[v] = (byte)(((int)(v1 & 0xFFL)));
        arr_b[v + 1] = (byte)(((int)(v1 >>> 8 & 0xFFL)));
        arr_b[v + 2] = (byte)(((int)(v1 >>> 16 & 0xFFL)));
        arr_b[v + 3] = (byte)(((int)(v1 >>> 24 & 0xFFL)));
        arr_b[v + 4] = (byte)(((int)(v1 >>> 0x20 & 0xFFL)));
        arr_b[v + 5] = (byte)(((int)(v1 >>> 40 & 0xFFL)));
        arr_b[v + 6] = (byte)(((int)(v1 >>> 0x30 & 0xFFL)));
        arr_b[v + 7] = (byte)(((int)(v1 >>> 56 & 0xFFL)));
    }

    public static int putUTF8(byte[] arr_b, int v, String s) {
        byte[] arr_b1 = IOUtils.toUTF8Bytes(s);
        System.arraycopy(arr_b1, 0, arr_b, v, arr_b1.length);
        return arr_b1.length;
    }

    public static void readFully(InputStream inputStream0, byte[] arr_b) {
        IOUtils.readFully(inputStream0, arr_b, 0, arr_b.length);
    }

    public static void readFully(InputStream inputStream0, byte[] arr_b, int v, int v1) {
        int v2 = 0;
        while(v2 < v1) {
            int v3 = inputStream0.read(arr_b, v + v2, v1 - v2);
            if(v3 != -1) {
                v2 += v3;
                continue;
            }
            StringBuilder stringBuilder0 = o.t(v1, v, "Asked to read ", " bytes from ", " but hit EoF at ");
            stringBuilder0.append(v2);
            throw new IOException(stringBuilder0.toString());
        }
    }

    public static String removeNullPadding(String s) {
        int v = s.indexOf(0);
        return v == -1 ? s : s.substring(0, v);
    }

    public static int toInt(byte b) {
        return b < 0 ? b & 0xFF : b;
    }

    public static byte[] toUTF8Bytes(String s) {
        return s.getBytes(IOUtils.UTF8);
    }

    public static void writeInt2(OutputStream outputStream0, int v) {
        byte[] arr_b = new byte[2];
        IOUtils.putInt2(arr_b, 0, v);
        outputStream0.write(arr_b);
    }

    public static void writeInt2BE(OutputStream outputStream0, int v) {
        byte[] arr_b = new byte[2];
        IOUtils.putInt2BE(arr_b, 0, v);
        outputStream0.write(arr_b);
    }

    public static void writeInt3(OutputStream outputStream0, long v) {
        byte[] arr_b = new byte[3];
        IOUtils.putInt3(arr_b, 0, v);
        outputStream0.write(arr_b);
    }

    public static void writeInt3BE(OutputStream outputStream0, long v) {
        byte[] arr_b = new byte[3];
        IOUtils.putInt3BE(arr_b, 0, v);
        outputStream0.write(arr_b);
    }

    public static void writeInt4(OutputStream outputStream0, long v) {
        byte[] arr_b = new byte[4];
        IOUtils.putInt4(arr_b, 0, v);
        outputStream0.write(arr_b);
    }

    public static void writeInt4BE(OutputStream outputStream0, long v) {
        byte[] arr_b = new byte[4];
        IOUtils.putInt4BE(arr_b, 0, v);
        outputStream0.write(arr_b);
    }

    public static void writeInt5(OutputStream outputStream0, long v) {
        byte[] arr_b = new byte[5];
        IOUtils.putInt5(arr_b, 0, v);
        outputStream0.write(arr_b);
    }

    public static void writeInt8(OutputStream outputStream0, long v) {
        byte[] arr_b = new byte[8];
        IOUtils.putInt8(arr_b, 0, v);
        outputStream0.write(arr_b);
    }

    public static void writeUTF8(OutputStream outputStream0, String s) {
        outputStream0.write(s.getBytes(IOUtils.UTF8));
    }

    public static void writeUTF8WithLength(OutputStream outputStream0, String s) {
        byte[] arr_b = s.getBytes(IOUtils.UTF8);
        IOUtils.writeInt4(outputStream0, ((long)arr_b.length));
        outputStream0.write(arr_b);
    }
}

