package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class DtsUtil {
    private static final int[] CHANNELS_BY_AMODE = null;
    private static final byte FIRST_BYTE_14B_BE = 0x1F;
    private static final byte FIRST_BYTE_14B_LE = -1;
    private static final byte FIRST_BYTE_BE = 0x7F;
    private static final byte FIRST_BYTE_LE = -2;
    private static final int[] SAMPLE_RATE_BY_SFREQ = null;
    private static final int SYNC_VALUE_14B_BE = 0x1FFFE800;
    private static final int SYNC_VALUE_14B_LE = 0xFF1F00E8;
    private static final int SYNC_VALUE_BE = 0x7FFE8001;
    private static final int SYNC_VALUE_LE = 0xFE7F0180;
    private static final int[] TWICE_BITRATE_KBPS_BY_RATE;

    static {
        DtsUtil.CHANNELS_BY_AMODE = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
        DtsUtil.SAMPLE_RATE_BY_SFREQ = new int[]{-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
        DtsUtil.TWICE_BITRATE_KBPS_BY_RATE = new int[]{0x40, 0x70, 0x80, 0xC0, 0xE0, 0x100, 0x180, 0x1C0, 0x200, 640, 0x300, 0x380, 0x400, 0x480, 0x500, 0x600, 0x780, 0x800, 0x900, 0xA00, 0xA80, 0xB00, 0xB07, 0xB80, 0xC00, 0xF00, 0x1000, 0x1800, 0x1E00};
    }

    public static int getDtsFrameSize(byte[] arr_b) {
        switch(arr_b[0]) {
            case -2: {
                return ((arr_b[6] & 0xF0) >> 4 | ((arr_b[4] & 3) << 12 | (arr_b[7] & 0xFF) << 4)) + 1;
            }
            case -1: {
                return (((arr_b[9] & 60) >> 2 | ((arr_b[7] & 3) << 12 | (arr_b[6] & 0xFF) << 4)) + 1) * 16 / 14;
            }
            case 0x1F: {
                return (((arr_b[8] & 60) >> 2 | ((arr_b[6] & 3) << 12 | (arr_b[7] & 0xFF) << 4)) + 1) * 16 / 14;
            }
            default: {
                return ((arr_b[7] & 0xF0) >> 4 | ((arr_b[5] & 3) << 12 | (arr_b[6] & 0xFF) << 4)) + 1;
            }
        }
    }

    private static ParsableBitArray getNormalizedFrameHeader(byte[] arr_b) {
        if(arr_b[0] == 0x7F) {
            return new ParsableBitArray(arr_b);
        }
        byte[] arr_b1 = Arrays.copyOf(arr_b, arr_b.length);
        if(DtsUtil.isLittleEndianFrameHeader(arr_b1)) {
            for(int v = 0; v < arr_b1.length - 1; v += 2) {
                byte b = arr_b1[v];
                arr_b1[v] = arr_b1[v + 1];
                arr_b1[v + 1] = b;
            }
        }
        ParsableBitArray parsableBitArray0 = new ParsableBitArray(arr_b1);
        if(arr_b1[0] == 0x1F) {
            ParsableBitArray parsableBitArray1 = new ParsableBitArray(arr_b1);
            while(parsableBitArray1.bitsLeft() >= 16) {
                parsableBitArray1.skipBits(2);
                parsableBitArray0.putInt(parsableBitArray1.readBits(14), 14);
            }
        }
        parsableBitArray0.reset(arr_b1);
        return parsableBitArray0;
    }

    private static boolean isLittleEndianFrameHeader(byte[] arr_b) {
        switch(arr_b[0]) {
            case -2: 
            case -1: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static boolean isSyncWord(int v) {
        return v == 0xFE7F0180 || v == 0xFF1F00E8 || v == 0x1FFFE800 || v == 0x7FFE8001;
    }

    public static int parseDtsAudioSampleCount(ByteBuffer byteBuffer0) {
        int v1;
        int v = byteBuffer0.position();
        switch(byteBuffer0.get(v)) {
            case -2: {
                v1 = (byteBuffer0.get(v + 5) & 1) << 6;
                return (((byteBuffer0.get(v + 4) & 0xFC) >> 2 | v1) + 1) * 0x20;
            }
            case -1: {
                v1 = (byteBuffer0.get(v + 4) & 7) << 4;
                return (((byteBuffer0.get(v + 7) & 60) >> 2 | v1) + 1) * 0x20;
            }
            case 0x1F: {
                v1 = (byteBuffer0.get(v + 5) & 7) << 4;
                return (((byteBuffer0.get(v + 6) & 60) >> 2 | v1) + 1) * 0x20;
            }
            default: {
                v1 = (byteBuffer0.get(v + 4) & 1) << 6;
                return (((byteBuffer0.get(v + 5) & 0xFC) >> 2 | v1) + 1) * 0x20;
            }
        }
    }

    public static int parseDtsAudioSampleCount(byte[] arr_b) {
        switch(arr_b[0]) {
            case -2: {
                return (((arr_b[4] & 0xFC) >> 2 | (arr_b[5] & 1) << 6) + 1) * 0x20;
            }
            case -1: {
                return (((arr_b[7] & 60) >> 2 | (arr_b[4] & 7) << 4) + 1) * 0x20;
            }
            case 0x1F: {
                return (((arr_b[6] & 60) >> 2 | (arr_b[5] & 7) << 4) + 1) * 0x20;
            }
            default: {
                return (((arr_b[5] & 0xFC) >> 2 | (arr_b[4] & 1) << 6) + 1) * 0x20;
            }
        }
    }

    public static Format parseDtsFormat(byte[] arr_b, String s, String s1, DrmInitData drmInitData0) {
        ParsableBitArray parsableBitArray0 = DtsUtil.getNormalizedFrameHeader(arr_b);
        parsableBitArray0.skipBits(60);
        int v = DtsUtil.CHANNELS_BY_AMODE[parsableBitArray0.readBits(6)];
        int v1 = DtsUtil.SAMPLE_RATE_BY_SFREQ[parsableBitArray0.readBits(4)];
        int v2 = parsableBitArray0.readBits(5);
        int v3 = v2 < DtsUtil.TWICE_BITRATE_KBPS_BY_RATE.length ? DtsUtil.TWICE_BITRATE_KBPS_BY_RATE[v2] * 1000 / 2 : -1;
        parsableBitArray0.skipBits(10);
        return parsableBitArray0.readBits(2) <= 0 ? Format.createAudioSampleFormat(s, "audio/vnd.dts", null, v3, -1, v, v1, null, drmInitData0, 0, s1) : Format.createAudioSampleFormat(s, "audio/vnd.dts", null, v3, -1, v + 1, v1, null, drmInitData0, 0, s1);
    }
}

