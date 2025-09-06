package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.util.ParsableByteArray;

public final class DolbyVisionConfig {
    public final String codecs;
    public final int level;
    public final int profile;

    private DolbyVisionConfig(int v, int v1, String s) {
        this.profile = v;
        this.level = v1;
        this.codecs = s;
    }

    public static DolbyVisionConfig parse(ParsableByteArray parsableByteArray0) {
        parsableByteArray0.skipBytes(2);
        int v = parsableByteArray0.readUnsignedByte();
        int v1 = parsableByteArray0.readUnsignedByte() >> 3 & 0x1F | (v & 1) << 5;
        if(v >> 1 != 4 && v >> 1 != 5) {
            switch(v >> 1) {
                case 7: {
                    break;
                }
                case 8: {
                    return new DolbyVisionConfig(v >> 1, v1, "hev1.0" + (v >> 1) + ".0" + v1);
                }
                case 9: {
                    return new DolbyVisionConfig(v >> 1, v1, "avc3.0" + (v >> 1) + ".0" + v1);
                }
                default: {
                    return null;
                }
            }
        }
        return new DolbyVisionConfig(v >> 1, v1, "dvhe.0" + (v >> 1) + ".0" + v1);
    }
}

