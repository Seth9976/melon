package com.google.android.exoplayer2.util;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import java.util.ArrayList;

public final class CodecSpecificDataUtil {
    private static final int AUDIO_OBJECT_TYPE_AAC_LC = 2;
    private static final int AUDIO_OBJECT_TYPE_ER_BSAC = 22;
    private static final int AUDIO_OBJECT_TYPE_ESCAPE = 0x1F;
    private static final int AUDIO_OBJECT_TYPE_PS = 29;
    private static final int AUDIO_OBJECT_TYPE_SBR = 5;
    private static final int AUDIO_SPECIFIC_CONFIG_CHANNEL_CONFIGURATION_INVALID = -1;
    private static final int[] AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = null;
    private static final int AUDIO_SPECIFIC_CONFIG_FREQUENCY_INDEX_ARBITRARY = 15;
    private static final int[] AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
    private static final byte[] NAL_START_CODE;

    static {
        CodecSpecificDataUtil.NAL_START_CODE = new byte[]{0, 0, 0, 1};
        CodecSpecificDataUtil.AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE = new int[]{96000, 88200, 0xFA00, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
        CodecSpecificDataUtil.AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
    }

    public static byte[] buildAacAudioSpecificConfig(int v, int v1, int v2) {
        return new byte[]{((byte)(v << 3 & 0xF8 | v1 >> 1 & 7)), ((byte)(v1 << 7 & 0x80 | v2 << 3 & 120))};
    }

    public static byte[] buildAacLcAudioSpecificConfig(int v, int v1) {
        int v3 = -1;
        for(int v4 = 0; true; ++v4) {
            int[] arr_v = CodecSpecificDataUtil.AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
            if(v4 >= arr_v.length) {
                break;
            }
            if(v == arr_v[v4]) {
                v3 = v4;
            }
        }
        int v5 = -1;
        for(int v2 = 0; true; ++v2) {
            int[] arr_v1 = CodecSpecificDataUtil.AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE;
            if(v2 >= arr_v1.length) {
                break;
            }
            if(v1 == arr_v1[v2]) {
                v5 = v2;
            }
        }
        if(v == -1 || v5 == -1) {
            throw new IllegalArgumentException("Invalid sample rate or number of channels: " + v + ", " + v1);
        }
        return CodecSpecificDataUtil.buildAacAudioSpecificConfig(2, v3, v5);
    }

    public static String buildAvcCodecString(int v, int v1, int v2) {
        return String.format("avc1.%02X%02X%02X", v, v1, v2);
    }

    public static byte[] buildNalUnit(byte[] arr_b, int v, int v1) {
        byte[] arr_b1 = new byte[CodecSpecificDataUtil.NAL_START_CODE.length + v1];
        System.arraycopy(CodecSpecificDataUtil.NAL_START_CODE, 0, arr_b1, 0, CodecSpecificDataUtil.NAL_START_CODE.length);
        System.arraycopy(arr_b, v, arr_b1, CodecSpecificDataUtil.NAL_START_CODE.length, v1);
        return arr_b1;
    }

    private static int findNalStartCode(byte[] arr_b, int v) {
        int v1 = arr_b.length - CodecSpecificDataUtil.NAL_START_CODE.length;
        while(v <= v1) {
            if(CodecSpecificDataUtil.isNalStartCode(arr_b, v)) {
                return v;
            }
            ++v;
        }
        return -1;
    }

    private static int getAacAudioObjectType(ParsableBitArray parsableBitArray0) {
        int v = parsableBitArray0.readBits(5);
        return v == 0x1F ? parsableBitArray0.readBits(6) + 0x20 : v;
    }

    private static int getAacSamplingFrequency(ParsableBitArray parsableBitArray0) {
        int v = parsableBitArray0.readBits(4);
        if(v == 15) {
            return parsableBitArray0.readBits(24);
        }
        Assertions.checkArgument(v < 13);
        return CodecSpecificDataUtil.AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[v];
    }

    private static boolean isNalStartCode(byte[] arr_b, int v) {
        if(arr_b.length - v <= CodecSpecificDataUtil.NAL_START_CODE.length) {
            return false;
        }
        for(int v1 = 0; true; ++v1) {
            byte[] arr_b1 = CodecSpecificDataUtil.NAL_START_CODE;
            if(v1 >= arr_b1.length) {
                break;
            }
            if(arr_b[v + v1] != arr_b1[v1]) {
                return false;
            }
        }
        return true;
    }

    public static Pair parseAacAudioSpecificConfig(ParsableBitArray parsableBitArray0, boolean z) {
        int v = CodecSpecificDataUtil.getAacAudioObjectType(parsableBitArray0);
        int v1 = CodecSpecificDataUtil.getAacSamplingFrequency(parsableBitArray0);
        int v2 = parsableBitArray0.readBits(4);
        if(v == 5 || v == 29) {
            v1 = CodecSpecificDataUtil.getAacSamplingFrequency(parsableBitArray0);
            v = CodecSpecificDataUtil.getAacAudioObjectType(parsableBitArray0);
            if(v == 22) {
                v2 = parsableBitArray0.readBits(4);
            }
        }
        boolean z1 = true;
        if(z) {
            if(v != 1 && v != 2 && v != 3 && v != 4 && (v != 6 && v != 7 && v != 17) && (v != 19 && v != 20 && v != 21 && v != 22 && v != 23)) {
                throw new ParserException("Unsupported audio object type: " + v);
            }
            CodecSpecificDataUtil.parseGaSpecificConfig(parsableBitArray0, v, v2);
            switch(v) {
                case 17: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: {
                    int v3 = parsableBitArray0.readBits(2);
                    if(v3 == 2 || v3 == 3) {
                        throw new ParserException("Unsupported epConfig: " + v3);
                    }
                }
            }
        }
        int v4 = CodecSpecificDataUtil.AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[v2];
        if(v4 == -1) {
            z1 = false;
        }
        Assertions.checkArgument(z1);
        return Pair.create(v1, v4);
    }

    public static Pair parseAacAudioSpecificConfig(byte[] arr_b) {
        return CodecSpecificDataUtil.parseAacAudioSpecificConfig(new ParsableBitArray(arr_b), false);
    }

    public static Pair parseAlacAudioSpecificConfig(byte[] arr_b) {
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(arr_b);
        parsableByteArray0.setPosition(9);
        int v = parsableByteArray0.readUnsignedByte();
        parsableByteArray0.setPosition(20);
        return Pair.create(parsableByteArray0.readUnsignedIntToInt(), v);
    }

    private static void parseGaSpecificConfig(ParsableBitArray parsableBitArray0, int v, int v1) {
        parsableBitArray0.skipBits(1);
        if(parsableBitArray0.readBit()) {
            parsableBitArray0.skipBits(14);
        }
        boolean z = parsableBitArray0.readBit();
        if(v1 == 0) {
            throw new UnsupportedOperationException();
        }
        if(v == 6 || v == 20) {
            parsableBitArray0.skipBits(3);
        }
        if(z) {
            if(v == 22) {
                parsableBitArray0.skipBits(16);
            }
            if(v == 17 || (v == 19 || v == 20) || v == 23) {
                parsableBitArray0.skipBits(3);
            }
            parsableBitArray0.skipBits(1);
        }
    }

    public static byte[][] splitNalUnits(byte[] arr_b) {
        if(!CodecSpecificDataUtil.isNalStartCode(arr_b, 0)) {
            return null;
        }
        ArrayList arrayList0 = new ArrayList();
        int v = 0;
        do {
            arrayList0.add(v);
            v = CodecSpecificDataUtil.findNalStartCode(arr_b, v + CodecSpecificDataUtil.NAL_START_CODE.length);
        }
        while(v != -1);
        byte[][] arr2_b = new byte[arrayList0.size()][];
        for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
            int v2 = (int)(((Integer)arrayList0.get(v1)));
            int v3 = (v1 >= arrayList0.size() - 1 ? arr_b.length : ((int)(((Integer)arrayList0.get(v1 + 1))))) - v2;
            byte[] arr_b1 = new byte[v3];
            System.arraycopy(arr_b, v2, arr_b1, 0, v3);
            arr2_b[v1] = arr_b1;
        }
        return arr2_b;
    }
}

