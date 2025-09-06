package com.google.android.exoplayer2.extractor;

public final class MpegAudioHeader {
    private static final int[] BITRATE_V1_L1 = null;
    private static final int[] BITRATE_V1_L2 = null;
    private static final int[] BITRATE_V1_L3 = null;
    private static final int[] BITRATE_V2 = null;
    private static final int[] BITRATE_V2_L1 = null;
    public static final int MAX_FRAME_SIZE_BYTES = 0x1000;
    private static final String[] MIME_TYPE_BY_LAYER = null;
    private static final int SAMPLES_PER_FRAME_L1 = 0x180;
    private static final int SAMPLES_PER_FRAME_L2 = 0x480;
    private static final int SAMPLES_PER_FRAME_L3_V1 = 0x480;
    private static final int SAMPLES_PER_FRAME_L3_V2 = 0x240;
    private static final int[] SAMPLING_RATE_V1;
    public int bitrate;
    public int channels;
    public int frameSize;
    public String mimeType;
    public int sampleRate;
    public int samplesPerFrame;
    public int version;

    static {
        MpegAudioHeader.MIME_TYPE_BY_LAYER = new String[]{"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
        MpegAudioHeader.SAMPLING_RATE_V1 = new int[]{44100, 48000, 32000};
        MpegAudioHeader.BITRATE_V1_L1 = new int[]{32000, 0xFA00, 96000, 0x1F400, 160000, 192000, 224000, 256000, 288000, 320000, 0x55F00, 384000, 416000, 448000};
        MpegAudioHeader.BITRATE_V2_L1 = new int[]{32000, 48000, 56000, 0xFA00, 80000, 96000, 112000, 0x1F400, 144000, 160000, 176000, 192000, 224000, 256000};
        MpegAudioHeader.BITRATE_V1_L2 = new int[]{32000, 48000, 56000, 0xFA00, 80000, 96000, 112000, 0x1F400, 160000, 192000, 224000, 256000, 320000, 384000};
        MpegAudioHeader.BITRATE_V1_L3 = new int[]{32000, 40000, 48000, 56000, 0xFA00, 80000, 96000, 112000, 0x1F400, 160000, 192000, 224000, 256000, 320000};
        MpegAudioHeader.BITRATE_V2 = new int[]{8000, 16000, 24000, 32000, 40000, 48000, 56000, 0xFA00, 80000, 96000, 112000, 0x1F400, 144000, 160000};
    }

    public static int getFrameSampleCount(int v) {
        if(!MpegAudioHeader.isMagicPresent(v)) {
            return -1;
        }
        int v1 = v >>> 19 & 3;
        if(v1 == 1) {
            return -1;
        }
        int v2 = v >>> 17 & 3;
        if(v2 == 0) {
            return -1;
        }
        return (v >>> 12 & 15) == 0 || (v >>> 12 & 15) == 15 || (v >>> 10 & 3) == 3 ? -1 : MpegAudioHeader.getFrameSizeInSamples(v1, v2);
    }

    public static int getFrameSize(int v) {
        int v7;
        if(!MpegAudioHeader.isMagicPresent(v)) {
            return -1;
        }
        int v1 = v >>> 19 & 3;
        if(v1 == 1) {
            return -1;
        }
        int v2 = v >>> 17 & 3;
        if(v2 == 0) {
            return -1;
        }
        int v3 = v >>> 12 & 15;
        if(v3 != 0 && v3 != 15) {
            int v4 = v >>> 10 & 3;
            if(v4 == 3) {
                return -1;
            }
            int v5 = MpegAudioHeader.SAMPLING_RATE_V1[v4];
            if(v1 == 2) {
                v5 /= 2;
            }
            else if(v1 == 0) {
                v5 /= 4;
            }
            int v6 = v >>> 9 & 1;
            if(v2 == 3) {
                return v1 == 3 ? (MpegAudioHeader.BITRATE_V1_L1[v3 - 1] * 12 / v5 + v6) * 4 : (MpegAudioHeader.BITRATE_V2_L1[v3 - 1] * 12 / v5 + v6) * 4;
            }
            if(v1 != 3) {
                v7 = MpegAudioHeader.BITRATE_V2[v3 - 1];
            }
            else if(v2 == 2) {
                v7 = MpegAudioHeader.BITRATE_V1_L2[v3 - 1];
            }
            else {
                v7 = MpegAudioHeader.BITRATE_V1_L3[v3 - 1];
            }
            int v8 = 0x90;
            if(v1 == 3) {
                return v7 * 0x90 / v5 + v6;
            }
            if(v2 == 1) {
                v8 = 72;
            }
            return v8 * v7 / v5 + v6;
        }
        return -1;
    }

    private static int getFrameSizeInSamples(int v, int v1) {
        if(v1 != 1) {
            switch(v1) {
                case 2: {
                    return 0x480;
                }
                case 3: {
                    return 0x180;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
        }
        return v == 3 ? 0x480 : 0x240;
    }

    private static boolean isMagicPresent(int v) {
        return (v & 0xFFE00000) == 0xFFE00000;
    }

    public static boolean populateHeader(int v, MpegAudioHeader mpegAudioHeader0) {
        int v12;
        int v11;
        int v10;
        int v9;
        if(!MpegAudioHeader.isMagicPresent(v)) {
            return false;
        }
        int v1 = v >>> 19 & 3;
        if(v1 == 1) {
            return false;
        }
        int v2 = v >>> 17 & 3;
        if(v2 == 0) {
            return false;
        }
        int v3 = v >>> 12 & 15;
        if(v3 != 0 && v3 != 15) {
            int v4 = v >>> 10 & 3;
            if(v4 == 3) {
                return false;
            }
            int v5 = MpegAudioHeader.SAMPLING_RATE_V1[v4];
            if(v1 == 2) {
                v5 /= 2;
            }
            else if(v1 == 0) {
                v5 /= 4;
            }
            int v6 = 0x90;
            int v7 = v >>> 9 & 1;
            int v8 = MpegAudioHeader.getFrameSizeInSamples(v1, v2);
            if(v2 == 3) {
                v9 = v1 == 3 ? MpegAudioHeader.BITRATE_V1_L1[v3 - 1] : MpegAudioHeader.BITRATE_V2_L1[v3 - 1];
                v10 = (v9 * 12 / v5 + v7) * 4;
            }
            else if(v1 == 3) {
                v9 = v2 == 2 ? MpegAudioHeader.BITRATE_V1_L2[v3 - 1] : MpegAudioHeader.BITRATE_V1_L3[v3 - 1];
                v10 = v9 * 0x90 / v5 + v7;
            }
            else {
                v9 = MpegAudioHeader.BITRATE_V2[v3 - 1];
                if(v2 == 1) {
                    v6 = 72;
                }
                v10 = v6 * v9 / v5 + v7;
            }
            String s = MpegAudioHeader.MIME_TYPE_BY_LAYER[3 - v2];
            if((v >> 6 & 3) == 3) {
                v11 = v10;
                v12 = 1;
            }
            else {
                v12 = 2;
                v11 = v10;
            }
            mpegAudioHeader0.setValues(v1, s, v11, v5, v12, v9, v8);
            return true;
        }
        return false;
    }

    private void setValues(int v, String s, int v1, int v2, int v3, int v4, int v5) {
        this.version = v;
        this.mimeType = s;
        this.frameSize = v1;
        this.sampleRate = v2;
        this.channels = v3;
        this.bitrate = v4;
        this.samplesPerFrame = v5;
    }
}

