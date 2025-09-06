package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class HevcConfig {
    public final List initializationData;
    public final int nalUnitLengthFieldLength;

    private HevcConfig(List list0, int v) {
        this.initializationData = list0;
        this.nalUnitLengthFieldLength = v;
    }

    public static HevcConfig parse(ParsableByteArray parsableByteArray0) {
        try {
            parsableByteArray0.skipBytes(21);
            int v = parsableByteArray0.readUnsignedByte();
            int v1 = parsableByteArray0.readUnsignedByte();
            int v2 = parsableByteArray0.getPosition();
            int v4 = 0;
            for(int v3 = 0; v3 < v1; ++v3) {
                parsableByteArray0.skipBytes(1);
                int v5 = parsableByteArray0.readUnsignedShort();
                for(int v6 = 0; v6 < v5; ++v6) {
                    int v7 = parsableByteArray0.readUnsignedShort();
                    v4 += v7 + 4;
                    parsableByteArray0.skipBytes(v7);
                }
            }
            parsableByteArray0.setPosition(v2);
            byte[] arr_b = new byte[v4];
            int v9 = 0;
            for(int v8 = 0; v8 < v1; ++v8) {
                parsableByteArray0.skipBytes(1);
                int v10 = parsableByteArray0.readUnsignedShort();
                for(int v11 = 0; v11 < v10; ++v11) {
                    int v12 = parsableByteArray0.readUnsignedShort();
                    System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, arr_b, v9, NalUnitUtil.NAL_START_CODE.length);
                    System.arraycopy(parsableByteArray0.data, parsableByteArray0.getPosition(), arr_b, v9 + NalUnitUtil.NAL_START_CODE.length, v12);
                    v9 = v9 + NalUnitUtil.NAL_START_CODE.length + v12;
                    parsableByteArray0.skipBytes(v12);
                }
            }
            return new HevcConfig((v4 == 0 ? null : Collections.singletonList(arr_b)), (v & 3) + 1);
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            throw new ParserException("Error parsing HEVC config", arrayIndexOutOfBoundsException0);
        }
    }
}

