package io.netty.buffer;

final class HeapByteBufUtil {
    public static byte getByte(byte[] arr_b, int v) {
        return arr_b[v];
    }

    public static int getInt(byte[] arr_b, int v) {
        return arr_b[v + 3] & 0xFF | ((arr_b[v] & 0xFF) << 24 | (arr_b[v + 1] & 0xFF) << 16 | (arr_b[v + 2] & 0xFF) << 8);
    }

    public static int getIntLE(byte[] arr_b, int v) {
        return (arr_b[v + 3] & 0xFF) << 24 | (arr_b[v] & 0xFF | (arr_b[v + 1] & 0xFF) << 8 | (arr_b[v + 2] & 0xFF) << 16);
    }

    public static long getLong(byte[] arr_b, int v) {
        return ((long)arr_b[v + 7]) & 0xFFL | ((((long)arr_b[v]) & 0xFFL) << 56 | (((long)arr_b[v + 1]) & 0xFFL) << 0x30 | (((long)arr_b[v + 2]) & 0xFFL) << 40 | (((long)arr_b[v + 3]) & 0xFFL) << 0x20 | (((long)arr_b[v + 4]) & 0xFFL) << 24 | (((long)arr_b[v + 5]) & 0xFFL) << 16 | (((long)arr_b[v + 6]) & 0xFFL) << 8);
    }

    public static long getLongLE(byte[] arr_b, int v) {
        return (((long)arr_b[v + 7]) & 0xFFL) << 56 | (((long)arr_b[v]) & 0xFFL | (((long)arr_b[v + 1]) & 0xFFL) << 8 | (((long)arr_b[v + 2]) & 0xFFL) << 16 | (((long)arr_b[v + 3]) & 0xFFL) << 24 | (((long)arr_b[v + 4]) & 0xFFL) << 0x20 | (((long)arr_b[v + 5]) & 0xFFL) << 40 | (((long)arr_b[v + 6]) & 0xFFL) << 0x30);
    }

    public static short getShort(byte[] arr_b, int v) {
        return (short)(arr_b[v + 1] & 0xFF | arr_b[v] << 8);
    }

    public static short getShortLE(byte[] arr_b, int v) {
        return (short)(arr_b[v + 1] << 8 | arr_b[v] & 0xFF);
    }

    public static int getUnsignedMedium(byte[] arr_b, int v) {
        return arr_b[v + 2] & 0xFF | ((arr_b[v] & 0xFF) << 16 | (arr_b[v + 1] & 0xFF) << 8);
    }

    public static int getUnsignedMediumLE(byte[] arr_b, int v) {
        return (arr_b[v + 2] & 0xFF) << 16 | (arr_b[v] & 0xFF | (arr_b[v + 1] & 0xFF) << 8);
    }

    public static void setByte(byte[] arr_b, int v, int v1) {
        arr_b[v] = (byte)v1;
    }

    public static void setInt(byte[] arr_b, int v, int v1) {
        arr_b[v] = (byte)(v1 >>> 24);
        arr_b[v + 1] = (byte)(v1 >>> 16);
        arr_b[v + 2] = (byte)(v1 >>> 8);
        arr_b[v + 3] = (byte)v1;
    }

    public static void setIntLE(byte[] arr_b, int v, int v1) {
        arr_b[v] = (byte)v1;
        arr_b[v + 1] = (byte)(v1 >>> 8);
        arr_b[v + 2] = (byte)(v1 >>> 16);
        arr_b[v + 3] = (byte)(v1 >>> 24);
    }

    public static void setLong(byte[] arr_b, int v, long v1) {
        arr_b[v] = (byte)(((int)(v1 >>> 56)));
        arr_b[v + 1] = (byte)(((int)(v1 >>> 0x30)));
        arr_b[v + 2] = (byte)(((int)(v1 >>> 40)));
        arr_b[v + 3] = (byte)(((int)(v1 >>> 0x20)));
        arr_b[v + 4] = (byte)(((int)(v1 >>> 24)));
        arr_b[v + 5] = (byte)(((int)(v1 >>> 16)));
        arr_b[v + 6] = (byte)(((int)(v1 >>> 8)));
        arr_b[v + 7] = (byte)(((int)v1));
    }

    public static void setLongLE(byte[] arr_b, int v, long v1) {
        arr_b[v] = (byte)(((int)v1));
        arr_b[v + 1] = (byte)(((int)(v1 >>> 8)));
        arr_b[v + 2] = (byte)(((int)(v1 >>> 16)));
        arr_b[v + 3] = (byte)(((int)(v1 >>> 24)));
        arr_b[v + 4] = (byte)(((int)(v1 >>> 0x20)));
        arr_b[v + 5] = (byte)(((int)(v1 >>> 40)));
        arr_b[v + 6] = (byte)(((int)(v1 >>> 0x30)));
        arr_b[v + 7] = (byte)(((int)(v1 >>> 56)));
    }

    public static void setMedium(byte[] arr_b, int v, int v1) {
        arr_b[v] = (byte)(v1 >>> 16);
        arr_b[v + 1] = (byte)(v1 >>> 8);
        arr_b[v + 2] = (byte)v1;
    }

    public static void setMediumLE(byte[] arr_b, int v, int v1) {
        arr_b[v] = (byte)v1;
        arr_b[v + 1] = (byte)(v1 >>> 8);
        arr_b[v + 2] = (byte)(v1 >>> 16);
    }

    public static void setShort(byte[] arr_b, int v, int v1) {
        arr_b[v] = (byte)(v1 >>> 8);
        arr_b[v + 1] = (byte)v1;
    }

    public static void setShortLE(byte[] arr_b, int v, int v1) {
        arr_b[v] = (byte)v1;
        arr_b[v + 1] = (byte)(v1 >>> 8);
    }
}

