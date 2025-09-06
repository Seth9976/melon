package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

public final class Ac3Util {
    public static final class SyncFrameInfo {
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface StreamType {
        }

        public static final int STREAM_TYPE_TYPE0 = 0;
        public static final int STREAM_TYPE_TYPE1 = 1;
        public static final int STREAM_TYPE_TYPE2 = 2;
        public static final int STREAM_TYPE_UNDEFINED = -1;
        public final int channelCount;
        public final int frameSize;
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;
        public final int streamType;

        private SyncFrameInfo(String s, int v, int v1, int v2, int v3, int v4) {
            this.mimeType = s;
            this.streamType = v;
            this.channelCount = v1;
            this.sampleRate = v2;
            this.frameSize = v3;
            this.sampleCount = v4;
        }

        public SyncFrameInfo(String s, int v, int v1, int v2, int v3, int v4, com.google.android.exoplayer2.audio.Ac3Util.1 ac3Util$10) {
            this(s, v, v1, v2, v3, v4);
        }
    }

    private static final int AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT = 0x600;
    private static final int AUDIO_SAMPLES_PER_AUDIO_BLOCK = 0x100;
    private static final int[] BITRATE_BY_HALF_FRMSIZECOD = null;
    private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = null;
    private static final int[] CHANNEL_COUNT_BY_ACMOD = null;
    private static final int[] SAMPLE_RATE_BY_FSCOD = null;
    private static final int[] SAMPLE_RATE_BY_FSCOD2 = null;
    private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = null;
    public static final int TRUEHD_RECHUNK_SAMPLE_COUNT = 16;
    public static final int TRUEHD_SYNCFRAME_PREFIX_LENGTH = 10;

    static {
        Ac3Util.BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = new int[]{1, 2, 3, 6};
        Ac3Util.SAMPLE_RATE_BY_FSCOD = new int[]{48000, 44100, 32000};
        Ac3Util.SAMPLE_RATE_BY_FSCOD2 = new int[]{24000, 22050, 16000};
        Ac3Util.CHANNEL_COUNT_BY_ACMOD = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
        Ac3Util.BITRATE_BY_HALF_FRMSIZECOD = new int[]{0x20, 40, 0x30, 56, 0x40, 80, 0x60, 0x70, 0x80, 0xA0, 0xC0, 0xE0, 0x100, 320, 0x180, 0x1C0, 0x200, 0x240, 640};
        Ac3Util.SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = new int[]{69, 87, 104, 0x79, 0x8B, 0xAE, 0xD0, 0xF3, 278, 348, 417, 487, 557, 696, 835, 0x3CF, 0x45A, 0x4E5, 0x571};
    }

    public static int findTrueHdSyncframeOffset(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.position();
        int v1 = byteBuffer0.limit();
        for(int v2 = v; v2 <= v1 - 10; ++v2) {
            if((byteBuffer0.getInt(v2 + 4) & 0xFEFFFFFF) == 0xBA6F72F8) {
                return v2 - v;
            }
        }
        return -1;
    }

    private static int getAc3SyncframeSize(int v, int v1) {
        if(v >= 0) {
            int[] arr_v = Ac3Util.SAMPLE_RATE_BY_FSCOD;
            if(v < arr_v.length && v1 >= 0) {
                int[] arr_v1 = Ac3Util.SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1;
                if(v1 / 2 < arr_v1.length) {
                    int v2 = arr_v[v];
                    if(v2 == 44100) {
                        return (v1 % 2 + arr_v1[v1 / 2]) * 2;
                    }
                    int v3 = Ac3Util.BITRATE_BY_HALF_FRMSIZECOD[v1 / 2];
                    return v2 == 32000 ? v3 * 6 : v3 * 4;
                }
            }
        }
        return -1;
    }

    public static Format parseAc3AnnexFFormat(ParsableByteArray parsableByteArray0, String s, String s1, DrmInitData drmInitData0) {
        int v = Ac3Util.SAMPLE_RATE_BY_FSCOD[(parsableByteArray0.readUnsignedByte() & 0xC0) >> 6];
        int v1 = parsableByteArray0.readUnsignedByte();
        int v2 = Ac3Util.CHANNEL_COUNT_BY_ACMOD[(v1 & 56) >> 3];
        if((v1 & 4) != 0) {
            ++v2;
        }
        return Format.createAudioSampleFormat(s, "audio/ac3", null, -1, -1, v2, v, null, drmInitData0, 0, s1);
    }

    public static int parseAc3SyncframeAudioSampleCount(ByteBuffer byteBuffer0) {
        int v = 3;
        if((byteBuffer0.get(byteBuffer0.position() + 5) & 0xF8) >> 3 > 10) {
            if((byteBuffer0.get(byteBuffer0.position() + 4) & 0xC0) >> 6 != 3) {
                v = (byteBuffer0.get(byteBuffer0.position() + 4) & 0x30) >> 4;
            }
            return Ac3Util.BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[v] * 0x100;
        }
        return 0x600;
    }

    public static SyncFrameInfo parseAc3SyncframeInfo(ParsableBitArray parsableBitArray0) {
        int v5;
        int v4;
        int v3;
        int v1;
        parsableBitArray0.skipBits(40);
        boolean z = parsableBitArray0.readBits(5) > 10;
        parsableBitArray0.setPosition(parsableBitArray0.getPosition());
        int v = -1;
        if(z) {
            parsableBitArray0.skipBits(16);
            switch(parsableBitArray0.readBits(2)) {
                case 0: {
                    v = 0;
                    break;
                }
                case 1: {
                    v = 1;
                    break;
                }
                case 2: {
                    v = 2;
                }
            }
            parsableBitArray0.skipBits(3);
            v1 = (parsableBitArray0.readBits(11) + 1) * 2;
            int v2 = parsableBitArray0.readBits(2);
            if(v2 == 3) {
                v3 = Ac3Util.SAMPLE_RATE_BY_FSCOD2[parsableBitArray0.readBits(2)];
                v4 = 6;
                v5 = 3;
            }
            else {
                v5 = parsableBitArray0.readBits(2);
                v4 = Ac3Util.BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[v5];
                v3 = Ac3Util.SAMPLE_RATE_BY_FSCOD[v2];
            }
            int v6 = parsableBitArray0.readBits(3);
            int v7 = parsableBitArray0.readBit();
            int v8 = Ac3Util.CHANNEL_COUNT_BY_ACMOD[v6] + v7;
            parsableBitArray0.skipBits(10);
            if(parsableBitArray0.readBit()) {
                parsableBitArray0.skipBits(8);
            }
            if(v6 == 0) {
                parsableBitArray0.skipBits(5);
                if(parsableBitArray0.readBit()) {
                    parsableBitArray0.skipBits(8);
                }
            }
            if(v == 1 && parsableBitArray0.readBit()) {
                parsableBitArray0.skipBits(16);
            }
            if(parsableBitArray0.readBit()) {
                if(v6 > 2) {
                    parsableBitArray0.skipBits(2);
                }
                if((v6 & 1) != 0 && v6 > 2) {
                    parsableBitArray0.skipBits(6);
                }
                if((v6 & 4) != 0) {
                    parsableBitArray0.skipBits(6);
                }
                if(v7 != 0 && parsableBitArray0.readBit()) {
                    parsableBitArray0.skipBits(5);
                }
                if(v == 0) {
                    if(parsableBitArray0.readBit()) {
                        parsableBitArray0.skipBits(6);
                    }
                    if(v6 == 0 && parsableBitArray0.readBit()) {
                        parsableBitArray0.skipBits(6);
                    }
                    if(parsableBitArray0.readBit()) {
                        parsableBitArray0.skipBits(6);
                    }
                    int v9 = parsableBitArray0.readBits(2);
                    if(v9 == 1) {
                        parsableBitArray0.skipBits(5);
                    }
                    else if(v9 == 2) {
                        parsableBitArray0.skipBits(12);
                    }
                    else if(v9 == 3) {
                        int v10 = parsableBitArray0.readBits(5);
                        if(parsableBitArray0.readBit()) {
                            parsableBitArray0.skipBits(5);
                            if(parsableBitArray0.readBit()) {
                                parsableBitArray0.skipBits(4);
                            }
                            if(parsableBitArray0.readBit()) {
                                parsableBitArray0.skipBits(4);
                            }
                            if(parsableBitArray0.readBit()) {
                                parsableBitArray0.skipBits(4);
                            }
                            if(parsableBitArray0.readBit()) {
                                parsableBitArray0.skipBits(4);
                            }
                            if(parsableBitArray0.readBit()) {
                                parsableBitArray0.skipBits(4);
                            }
                            if(parsableBitArray0.readBit()) {
                                parsableBitArray0.skipBits(4);
                            }
                            if(parsableBitArray0.readBit()) {
                                parsableBitArray0.skipBits(4);
                            }
                            if(parsableBitArray0.readBit()) {
                                if(parsableBitArray0.readBit()) {
                                    parsableBitArray0.skipBits(4);
                                }
                                if(parsableBitArray0.readBit()) {
                                    parsableBitArray0.skipBits(4);
                                }
                            }
                        }
                        if(parsableBitArray0.readBit()) {
                            parsableBitArray0.skipBits(5);
                            if(parsableBitArray0.readBit()) {
                                parsableBitArray0.skipBits(7);
                                if(parsableBitArray0.readBit()) {
                                    parsableBitArray0.skipBits(8);
                                }
                            }
                        }
                        parsableBitArray0.skipBits((v10 + 2) * 8);
                        parsableBitArray0.byteAlign();
                    }
                    if(v6 < 2) {
                        if(parsableBitArray0.readBit()) {
                            parsableBitArray0.skipBits(14);
                        }
                        if(v6 == 0 && parsableBitArray0.readBit()) {
                            parsableBitArray0.skipBits(14);
                        }
                    }
                    if(parsableBitArray0.readBit()) {
                        if(v5 == 0) {
                            parsableBitArray0.skipBits(5);
                        }
                        else {
                            for(int v11 = 0; v11 < v4; ++v11) {
                                if(parsableBitArray0.readBit()) {
                                    parsableBitArray0.skipBits(5);
                                }
                            }
                        }
                    }
                }
            }
            if(parsableBitArray0.readBit()) {
                parsableBitArray0.skipBits(5);
                if(v6 == 2) {
                    parsableBitArray0.skipBits(4);
                }
                if(v6 >= 6) {
                    parsableBitArray0.skipBits(2);
                }
                if(parsableBitArray0.readBit()) {
                    parsableBitArray0.skipBits(8);
                }
                if(v6 == 0 && parsableBitArray0.readBit()) {
                    parsableBitArray0.skipBits(8);
                }
                if(v2 < 3) {
                    parsableBitArray0.skipBit();
                }
            }
            if(v == 0 && v5 != 3) {
                parsableBitArray0.skipBit();
            }
            if(v == 2 && (v5 == 3 || parsableBitArray0.readBit())) {
                parsableBitArray0.skipBits(6);
            }
            return !parsableBitArray0.readBit() || parsableBitArray0.readBits(6) != 1 || parsableBitArray0.readBits(8) != 1 ? new SyncFrameInfo("audio/eac3", v, v8, v3, v1, v4 * 0x100, null) : new SyncFrameInfo("audio/eac3-joc", v, v8, v3, v1, v4 * 0x100, null);
        }
        parsableBitArray0.skipBits(0x20);
        int v12 = parsableBitArray0.readBits(2);
        v1 = Ac3Util.getAc3SyncframeSize(v12, parsableBitArray0.readBits(6));
        parsableBitArray0.skipBits(8);
        int v13 = parsableBitArray0.readBits(3);
        if((v13 & 1) != 0 && v13 != 1) {
            parsableBitArray0.skipBits(2);
        }
        if((v13 & 4) != 0) {
            parsableBitArray0.skipBits(2);
        }
        if(v13 == 2) {
            parsableBitArray0.skipBits(2);
        }
        v3 = v12 >= Ac3Util.SAMPLE_RATE_BY_FSCOD.length ? -1 : Ac3Util.SAMPLE_RATE_BY_FSCOD[v12];
        int v14 = parsableBitArray0.readBit();
        return new SyncFrameInfo((v12 == 3 ? null : "audio/ac3"), -1, Ac3Util.CHANNEL_COUNT_BY_ACMOD[v13] + v14, v3, v1, 0x600, null);
    }

    public static int parseAc3SyncframeSize(byte[] arr_b) {
        if(arr_b.length < 6) {
            return -1;
        }
        return (arr_b[5] & 0xF8) >> 3 <= 10 ? Ac3Util.getAc3SyncframeSize((arr_b[4] & 0xC0) >> 6, arr_b[4] & 0x3F) : ((arr_b[3] & 0xFF | (arr_b[2] & 7) << 8) + 1) * 2;
    }

    public static Format parseEAc3AnnexFFormat(ParsableByteArray parsableByteArray0, String s, String s1, DrmInitData drmInitData0) {
        parsableByteArray0.skipBytes(2);
        int v = Ac3Util.SAMPLE_RATE_BY_FSCOD[(parsableByteArray0.readUnsignedByte() & 0xC0) >> 6];
        int v1 = parsableByteArray0.readUnsignedByte();
        int v2 = Ac3Util.CHANNEL_COUNT_BY_ACMOD[(v1 & 14) >> 1];
        if((v1 & 1) != 0) {
            ++v2;
        }
        if((parsableByteArray0.readUnsignedByte() & 30) >> 1 > 0 && (2 & parsableByteArray0.readUnsignedByte()) != 0) {
            v2 += 2;
        }
        return parsableByteArray0.bytesLeft() <= 0 || (parsableByteArray0.readUnsignedByte() & 1) == 0 ? Format.createAudioSampleFormat(s, "audio/eac3", null, -1, -1, v2, v, null, drmInitData0, 0, s1) : Format.createAudioSampleFormat(s, "audio/eac3-joc", null, -1, -1, v2, v, null, drmInitData0, 0, s1);
    }

    public static int parseTrueHdSyncframeAudioSampleCount(ByteBuffer byteBuffer0, int v) {
        int v1 = byteBuffer0.position();
        return (byteBuffer0.get(byteBuffer0.position() + v + 7) & 0xFF) == 0xBB ? 40 << (byteBuffer0.get(v1 + v + 8) >> 4 & 7) : 40 << (byteBuffer0.get(v1 + v + 9) >> 4 & 7);
    }

    public static int parseTrueHdSyncframeAudioSampleCount(byte[] arr_b) {
        if(arr_b[4] == -8 && arr_b[5] == 0x72 && arr_b[6] == 0x6F) {
            int v = arr_b[7];
            if((v & 0xFE) == 0xBA) {
                return (v & 0xFF) == 0xBB ? 40 << (arr_b[9] >> 4 & 7) : 40 << (arr_b[8] >> 4 & 7);
            }
        }
        return 0;
    }

    class com.google.android.exoplayer2.audio.Ac3Util.1 {
    }

}

