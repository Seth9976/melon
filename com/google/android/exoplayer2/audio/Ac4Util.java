package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;

public final class Ac4Util {
    public static final class SyncFrameInfo {
        public final int bitstreamVersion;
        public final int channelCount;
        public final int frameSize;
        public final int sampleCount;
        public final int sampleRate;

        private SyncFrameInfo(int v, int v1, int v2, int v3, int v4) {
            this.bitstreamVersion = v;
            this.channelCount = v1;
            this.sampleRate = v2;
            this.frameSize = v3;
            this.sampleCount = v4;
        }

        public SyncFrameInfo(int v, int v1, int v2, int v3, int v4, com.google.android.exoplayer2.audio.Ac4Util.1 ac4Util$10) {
            this(v, v1, v2, v3, v4);
        }
    }

    public static final int AC40_SYNCWORD = 0xAC40;
    public static final int AC41_SYNCWORD = 44097;
    private static final int CHANNEL_COUNT_2 = 2;
    public static final int HEADER_SIZE_FOR_PARSER = 16;
    private static final int[] SAMPLE_COUNT = null;
    public static final int SAMPLE_HEADER_SIZE = 7;

    static {
        Ac4Util.SAMPLE_COUNT = new int[]{2002, 2000, 0x780, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 0x800};
    }

    public static void getAc4SampleHeader(int v, ParsableByteArray parsableByteArray0) {
        parsableByteArray0.reset(7);
        byte[] arr_b = parsableByteArray0.data;
        arr_b[0] = -84;
        arr_b[1] = 0x40;
        arr_b[2] = -1;
        arr_b[3] = -1;
        arr_b[4] = (byte)(v >> 16 & 0xFF);
        arr_b[5] = (byte)(v >> 8 & 0xFF);
        arr_b[6] = (byte)(v & 0xFF);
    }

    public static Format parseAc4AnnexEFormat(ParsableByteArray parsableByteArray0, String s, String s1, DrmInitData drmInitData0) {
        parsableByteArray0.skipBytes(1);
        return (parsableByteArray0.readUnsignedByte() & 0x20) >> 5 == 1 ? Format.createAudioSampleFormat(s, "audio/ac4", null, -1, -1, 2, 48000, null, drmInitData0, 0, s1) : Format.createAudioSampleFormat(s, "audio/ac4", null, -1, -1, 2, 44100, null, drmInitData0, 0, s1);
    }

    public static int parseAc4SyncframeAudioSampleCount(ByteBuffer byteBuffer0) {
        byte[] arr_b = new byte[16];
        byteBuffer0.get(arr_b);
        byteBuffer0.position(byteBuffer0.position());
        return Ac4Util.parseAc4SyncframeInfo(new ParsableBitArray(arr_b)).sampleCount;
    }

    public static SyncFrameInfo parseAc4SyncframeInfo(ParsableBitArray parsableBitArray0) {
        int v2;
        int v = parsableBitArray0.readBits(16);
        int v1 = parsableBitArray0.readBits(16);
        if(v1 == 0xFFFF) {
            v1 = parsableBitArray0.readBits(24);
            v2 = 7;
        }
        else {
            v2 = 4;
        }
        int v3 = v == 44097 ? v1 + v2 + 2 : v1 + v2;
        int v4 = parsableBitArray0.readBits(2);
        if(v4 == 3) {
            v4 = Ac4Util.readVariableBits(parsableBitArray0, 2) + 3;
        }
        int v5 = parsableBitArray0.readBits(10);
        if(parsableBitArray0.readBit() && parsableBitArray0.readBits(3) > 0) {
            parsableBitArray0.skipBits(2);
        }
        int v6 = parsableBitArray0.readBit() ? 48000 : 44100;
        int v7 = parsableBitArray0.readBits(4);
        if(v6 == 44100 && v7 == 13) {
            return new SyncFrameInfo(v4, 2, v6, v3, Ac4Util.SAMPLE_COUNT[13], null);
        }
        if(v6 == 48000) {
            int[] arr_v = Ac4Util.SAMPLE_COUNT;
            if(v7 < arr_v.length) {
                int v8 = arr_v[v7];
                if(v5 % 5 != 1) {
                    switch(v5 % 5) {
                        case 2: {
                            return v7 != 8 && v7 != 11 ? new SyncFrameInfo(v4, 2, 48000, v3, v8, null) : new SyncFrameInfo(v4, 2, 48000, v3, v8 + 1, null);
                        }
                        case 3: {
                            break;
                        }
                        case 4: {
                            return v7 != 3 && v7 != 8 && v7 != 11 ? new SyncFrameInfo(v4, 2, 48000, v3, v8, null) : new SyncFrameInfo(v4, 2, 48000, v3, v8 + 1, null);
                        }
                        default: {
                            return new SyncFrameInfo(v4, 2, 48000, v3, v8, null);
                        }
                    }
                }
                return v7 == 3 || v7 == 8 ? new SyncFrameInfo(v4, 2, 48000, v3, v8 + 1, null) : new SyncFrameInfo(v4, 2, 48000, v3, v8, null);
            }
        }
        return new SyncFrameInfo(v4, 2, v6, v3, 0, null);
    }

    public static int parseAc4SyncframeSize(byte[] arr_b, int v) {
        int v1 = 7;
        if(arr_b.length < 7) {
            return -1;
        }
        int v2 = (arr_b[2] & 0xFF) << 8 | arr_b[3] & 0xFF;
        if(v2 == 0xFFFF) {
            v2 = (arr_b[4] & 0xFF) << 16 | (arr_b[5] & 0xFF) << 8 | arr_b[6] & 0xFF;
        }
        else {
            v1 = 4;
        }
        if(v == 44097) {
            v1 += 2;
        }
        return v2 + v1;
    }

    private static int readVariableBits(ParsableBitArray parsableBitArray0, int v) {
        int v2;
        for(int v1 = 0; true; v1 = v2 + 1 << v) {
            v2 = parsableBitArray0.readBits(v) + v1;
            if(!parsableBitArray0.readBit()) {
                break;
            }
        }
        return v2;
    }

    class com.google.android.exoplayer2.audio.Ac4Util.1 {
    }

}

