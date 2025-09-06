package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.ParsableByteArray;

public final class TsUtil {
    public static int findSyncBytePosition(byte[] arr_b, int v, int v1) {
        while(v < v1 && arr_b[v] != 71) {
            ++v;
        }
        return v;
    }

    public static long readPcrFromPacket(ParsableByteArray parsableByteArray0, int v, int v1) {
        parsableByteArray0.setPosition(v);
        if(parsableByteArray0.bytesLeft() < 5) {
            return 0x8000000000000001L;
        }
        int v2 = parsableByteArray0.readInt();
        if((0x800000 & v2) != 0) {
            return 0x8000000000000001L;
        }
        if((0x1FFF00 & v2) >> 8 != v1) {
            return 0x8000000000000001L;
        }
        if((v2 & 0x20) != 0 && parsableByteArray0.readUnsignedByte() >= 7 && parsableByteArray0.bytesLeft() >= 7 && (parsableByteArray0.readUnsignedByte() & 16) == 16) {
            byte[] arr_b = new byte[6];
            parsableByteArray0.readBytes(arr_b, 0, 6);
            return TsUtil.readPcrValueFromPcrBytes(arr_b);
        }
        return 0x8000000000000001L;
    }

    private static long readPcrValueFromPcrBytes(byte[] arr_b) {
        return (((long)arr_b[0]) & 0xFFL) << 25 | (((long)arr_b[1]) & 0xFFL) << 17 | (((long)arr_b[2]) & 0xFFL) << 9 | (((long)arr_b[3]) & 0xFFL) << 1 | (0xFFL & ((long)arr_b[4])) >> 7;
    }
}

