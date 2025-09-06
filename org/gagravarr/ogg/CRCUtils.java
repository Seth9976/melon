package org.gagravarr.ogg;

public class CRCUtils {
    protected static final int CRC_POLYNOMIAL = 0x4C11DB7;
    private static int[] CRC_TABLE;

    static {
        CRCUtils.CRC_TABLE = new int[0x100];
        for(int v = 0; v < 0x100; ++v) {
            int v1 = v << 24;
            for(int v2 = 0; v2 < 8; ++v2) {
                v1 = (0x80000000 & v1) == 0 ? v1 << 1 : v1 << 1 ^ 0x4C11DB7;
            }
            CRCUtils.CRC_TABLE[v] = v1;
        }
    }

    public static int getCRC(byte[] arr_b) {
        return CRCUtils.getCRC(arr_b, 0);
    }

    public static int getCRC(byte[] arr_b, int v) {
        for(int v1 = 0; v1 < arr_b.length; ++v1) {
            v = CRCUtils.CRC_TABLE[v >>> 24 & 0xFF ^ arr_b[v1] & 0xFF] ^ v << 8;
        }
        return v;
    }
}

