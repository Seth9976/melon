package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil.SpsData;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class AvcConfig {
    public final int height;
    public final List initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthAspectRatio;
    public final int width;

    private AvcConfig(List list0, int v, int v1, int v2, float f) {
        this.initializationData = list0;
        this.nalUnitLengthFieldLength = v;
        this.width = v1;
        this.height = v2;
        this.pixelWidthAspectRatio = f;
    }

    private static byte[] buildNalUnitForChild(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.readUnsignedShort();
        parsableByteArray0.skipBytes(v);
        return CodecSpecificDataUtil.buildNalUnit(parsableByteArray0.data, parsableByteArray0.getPosition(), v);
    }

    public static AvcConfig parse(ParsableByteArray parsableByteArray0) {
        int v6;
        int v5;
        float f;
        try {
            parsableByteArray0.skipBytes(4);
            int v = (parsableByteArray0.readUnsignedByte() & 3) + 1;
            if(v == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList0 = new ArrayList();
            int v1 = parsableByteArray0.readUnsignedByte();
            for(int v2 = 0; v2 < (v1 & 0x1F); ++v2) {
                arrayList0.add(AvcConfig.buildNalUnitForChild(parsableByteArray0));
            }
            int v3 = parsableByteArray0.readUnsignedByte();
            for(int v4 = 0; v4 < v3; ++v4) {
                arrayList0.add(AvcConfig.buildNalUnitForChild(parsableByteArray0));
            }
            if((v1 & 0x1F) > 0) {
                byte[] arr_b = (byte[])arrayList0.get(0);
                SpsData nalUnitUtil$SpsData0 = NalUnitUtil.parseSpsNalUnit(((byte[])arrayList0.get(0)), v, arr_b.length);
                f = nalUnitUtil$SpsData0.pixelWidthAspectRatio;
                v5 = nalUnitUtil$SpsData0.width;
                v6 = nalUnitUtil$SpsData0.height;
            }
            else {
                f = 1.0f;
                v5 = -1;
                v6 = -1;
            }
            return new AvcConfig(arrayList0, v, v5, v6, f);
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            throw new ParserException("Error parsing AVC config", arrayIndexOutOfBoundsException0);
        }
    }
}

