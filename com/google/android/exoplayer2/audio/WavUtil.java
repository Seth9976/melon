package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;

public final class WavUtil {
    public static final int DATA_FOURCC = 1684108385;
    public static final int FMT_FOURCC = 0x666D7420;
    public static final int RIFF_FOURCC = 1380533830;
    public static final int TYPE_ALAW = 6;
    public static final int TYPE_FLOAT = 3;
    public static final int TYPE_IMA_ADPCM = 17;
    public static final int TYPE_MLAW = 7;
    public static final int TYPE_PCM = 1;
    public static final int TYPE_WAVE_FORMAT_EXTENSIBLE = 0xFFFE;
    public static final int WAVE_FOURCC = 0x57415645;

    public static int getPcmEncodingForType(int v, int v1) {
        switch(v) {
            case 3: {
                return v1 == 0x20 ? 4 : 0;
            }
            case 1: 
            case 0xFFFE: {
                return Util.getPcmEncoding(v1);
            }
            default: {
                return 0;
            }
        }
    }

    public static int getTypeForPcmEncoding(int v) {
        switch(v) {
            case 4: {
                return 3;
            }
            case 2: 
            case 3: 
            case 0x20000000: 
            case 0x30000000: {
                return 1;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
}

