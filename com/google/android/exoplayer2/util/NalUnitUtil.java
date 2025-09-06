package com.google.android.exoplayer2.util;

import b3.Z;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class NalUnitUtil {
    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int v, int v1, boolean z) {
            this.picParameterSetId = v;
            this.seqParameterSetId = v1;
            this.bottomFieldPicOrderInFramePresentFlag = z;
        }
    }

    public static final class SpsData {
        public final int constraintsFlagsAndReservedZero2Bits;
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int levelIdc;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthAspectRatio;
        public final int profileIdc;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int v, int v1, int v2, int v3, int v4, int v5, float f, boolean z, boolean z1, int v6, int v7, int v8, boolean z2) {
            this.profileIdc = v;
            this.constraintsFlagsAndReservedZero2Bits = v1;
            this.levelIdc = v2;
            this.seqParameterSetId = v3;
            this.width = v4;
            this.height = v5;
            this.pixelWidthAspectRatio = f;
            this.separateColorPlaneFlag = z;
            this.frameMbsOnlyFlag = z1;
            this.frameNumLength = v6;
            this.picOrderCountType = v7;
            this.picOrderCntLsbLength = v8;
            this.deltaPicOrderAlwaysZeroFlag = z2;
        }
    }

    public static final float[] ASPECT_RATIO_IDC_VALUES = null;
    public static final int EXTENDED_SAR = 0xFF;
    private static final int H264_NAL_UNIT_TYPE_SEI = 6;
    private static final int H264_NAL_UNIT_TYPE_SPS = 7;
    private static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
    public static final byte[] NAL_START_CODE = null;
    private static final String TAG = "NalUnitUtil";
    private static int[] scratchEscapePositions;
    private static final Object scratchEscapePositionsLock;

    static {
        NalUnitUtil.NAL_START_CODE = new byte[]{0, 0, 0, 1};
        NalUnitUtil.ASPECT_RATIO_IDC_VALUES = new float[]{1.0f, 1.0f, 1.090909f, 0.909091f, 1.454545f, 1.212121f, 2.181818f, 1.818182f, 2.909091f, 2.424242f, 1.636364f, 1.363636f, 1.939394f, 1.616162f, 1.333333f, 1.5f, 2.0f};
        NalUnitUtil.scratchEscapePositionsLock = new Object();
        NalUnitUtil.scratchEscapePositions = new int[10];
    }

    public static void clearPrefixFlags(boolean[] arr_z) {
        arr_z[0] = false;
        arr_z[1] = false;
        arr_z[2] = false;
    }

    public static void discardToSps(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.position();
        int v2 = 0;
        for(int v1 = 0; v1 + 1 < v; ++v1) {
            int v3 = byteBuffer0.get(v1) & 0xFF;
            if(v2 == 3) {
                if(v3 == 1 && (byteBuffer0.get(v1 + 1) & 0x1F) == 7) {
                    ByteBuffer byteBuffer1 = byteBuffer0.duplicate();
                    byteBuffer1.position(v1 - 3);
                    byteBuffer1.limit(v);
                    byteBuffer0.position(0);
                    byteBuffer0.put(byteBuffer1);
                    return;
                }
            }
            else if(v3 == 0) {
                ++v2;
            }
            if(v3 != 0) {
                v2 = 0;
            }
        }
        byteBuffer0.clear();
    }

    public static int findNalUnit(byte[] arr_b, int v, int v1, boolean[] arr_z) {
        boolean z2;
        boolean z1;
        int v2 = v1 - v;
        boolean z = false;
        Assertions.checkState(v2 >= 0);
        if(v2 != 0) {
            if(arr_z != null) {
                if(arr_z[0]) {
                    NalUnitUtil.clearPrefixFlags(arr_z);
                    return v - 3;
                }
                if(v2 > 1 && arr_z[1] && arr_b[v] == 1) {
                    NalUnitUtil.clearPrefixFlags(arr_z);
                    return v - 2;
                }
                if(v2 > 2 && arr_z[2] && arr_b[v] == 0 && arr_b[v + 1] == 1) {
                    NalUnitUtil.clearPrefixFlags(arr_z);
                    return v - 1;
                }
            }
            for(int v3 = v + 2; v3 < v1 - 1; v3 += 3) {
                int v4 = arr_b[v3];
                if((v4 & 0xFE) == 0) {
                    if(arr_b[v3 - 2] == 0 && arr_b[v3 - 1] == 0 && v4 == 1) {
                        if(arr_z != null) {
                            NalUnitUtil.clearPrefixFlags(arr_z);
                        }
                        return v3 - 2;
                    }
                    v3 -= 2;
                }
            }
            if(arr_z != null) {
                if(v2 <= 2) {
                    if(v2 != 2) {
                        z1 = arr_z[1] && arr_b[v1 - 1] == 1;
                    }
                    else if(arr_z[2] && arr_b[v1 - 2] == 0 && arr_b[v1 - 1] == 1) {
                        z1 = true;
                    }
                    else {
                        z1 = false;
                    }
                }
                else if(arr_b[v1 - 3] == 0 && arr_b[v1 - 2] == 0 && arr_b[v1 - 1] == 1) {
                    z1 = true;
                }
                else {
                    z1 = false;
                }
                arr_z[0] = z1;
                if(v2 <= 1) {
                    z2 = arr_z[2] && arr_b[v1 - 1] == 0;
                }
                else if(arr_b[v1 - 2] == 0 && arr_b[v1 - 1] == 0) {
                    z2 = true;
                }
                else {
                    z2 = false;
                }
                arr_z[1] = z2;
                if(arr_b[v1 - 1] == 0) {
                    z = true;
                }
                arr_z[2] = z;
            }
        }
        return v1;
    }

    private static int findNextUnescapeIndex(byte[] arr_b, int v, int v1) {
        while(v < v1 - 2) {
            if(arr_b[v] == 0 && arr_b[v + 1] == 0 && arr_b[v + 2] == 3) {
                return v;
            }
            ++v;
        }
        return v1;
    }

    public static int getH265NalUnitType(byte[] arr_b, int v) {
        return (arr_b[v + 3] & 0x7E) >> 1;
    }

    public static int getNalUnitType(byte[] arr_b, int v) {
        return arr_b[v + 3] & 0x1F;
    }

    // 去混淆评级： 低(20)
    public static boolean isNalUnitSei(String s, byte b) {
        return "video/avc".equals(s) && (b & 0x1F) == 6 || "video/hevc".equals(s) && (b & 0x7E) >> 1 == 39;
    }

    public static PpsData parsePpsNalUnit(byte[] arr_b, int v, int v1) {
        ParsableNalUnitBitArray parsableNalUnitBitArray0 = new ParsableNalUnitBitArray(arr_b, v, v1);
        parsableNalUnitBitArray0.skipBits(8);
        int v2 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        int v3 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray0.skipBit();
        return new PpsData(v2, v3, parsableNalUnitBitArray0.readBit());
    }

    public static SpsData parseSpsNalUnit(byte[] arr_b, int v, int v1) {
        int v24;
        boolean z2;
        boolean z1;
        int v11;
        int v10;
        boolean z;
        int v6;
        ParsableNalUnitBitArray parsableNalUnitBitArray0 = new ParsableNalUnitBitArray(arr_b, v, v1);
        parsableNalUnitBitArray0.skipBits(8);
        int v2 = parsableNalUnitBitArray0.readBits(8);
        int v3 = parsableNalUnitBitArray0.readBits(8);
        int v4 = parsableNalUnitBitArray0.readBits(8);
        int v5 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        switch(v2) {
            case 44: 
            case 83: 
            case 86: 
            case 100: 
            case 110: 
            case 0x76: 
            case 0x7A: 
            case 0x80: 
            case 0x8A: 
            case 0xF4: {
                v6 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
                z = v6 == 3 ? parsableNalUnitBitArray0.readBit() : false;
                parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray0.skipBit();
                if(parsableNalUnitBitArray0.readBit()) {
                    for(int v7 = 0; true; ++v7) {
                        if(v7 >= (v6 == 3 ? 12 : 8)) {
                            break;
                        }
                        if(parsableNalUnitBitArray0.readBit()) {
                            NalUnitUtil.skipScalingList(parsableNalUnitBitArray0, (v7 >= 6 ? 0x40 : 16));
                        }
                    }
                }
                break;
            }
            default: {
                v6 = 1;
                z = false;
            }
        }
        int v8 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        int v9 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        if(v9 == 0) {
            v10 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt() + 4;
            v11 = 1;
            z1 = z;
            z2 = false;
        }
        else if(v9 == 1) {
            boolean z3 = parsableNalUnitBitArray0.readBit();
            parsableNalUnitBitArray0.readSignedExpGolombCodedInt();
            parsableNalUnitBitArray0.readSignedExpGolombCodedInt();
            z1 = z;
            long v12 = (long)parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
            v11 = 1;
            for(int v13 = 0; ((long)v13) < v12; ++v13) {
                parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
            }
            z2 = z3;
            v10 = 0;
        }
        else {
            v11 = 1;
            z1 = z;
            v10 = 0;
            z2 = false;
        }
        parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray0.skipBit();
        int v14 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        int v15 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        int v16 = parsableNalUnitBitArray0.readBit();
        if(v16 == 0) {
            parsableNalUnitBitArray0.skipBit();
        }
        parsableNalUnitBitArray0.skipBit();
        int v17 = (v14 + 1) * 16;
        int v18 = (2 - v16) * (v15 + 1) * 16;
        if(parsableNalUnitBitArray0.readBit()) {
            int v19 = 2;
            int v20 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
            int v21 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
            int v22 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
            int v23 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
            if(v6 == 0) {
                v24 = 2 - v16;
            }
            else {
                if(v6 != 3) {
                    v11 = 2;
                }
                if(v6 != 1) {
                    v19 = 1;
                }
                v24 = (2 - v16) * v19;
            }
            v17 -= (v20 + v21) * v11;
            v18 -= (v22 + v23) * v24;
        }
        if(parsableNalUnitBitArray0.readBit() && parsableNalUnitBitArray0.readBit()) {
            int v25 = parsableNalUnitBitArray0.readBits(8);
            if(v25 == 0xFF) {
                int v26 = parsableNalUnitBitArray0.readBits(16);
                int v27 = parsableNalUnitBitArray0.readBits(16);
                return v26 == 0 || v27 == 0 ? new SpsData(v2, v3, v4, v5, v17, v18, 1.0f, z1, ((boolean)v16), v8 + 4, v9, v10, z2) : new SpsData(v2, v3, v4, v5, v17, v18, ((float)v26) / ((float)v27), z1, ((boolean)v16), v8 + 4, v9, v10, z2);
            }
            float[] arr_f = NalUnitUtil.ASPECT_RATIO_IDC_VALUES;
            if(v25 < arr_f.length) {
                return new SpsData(v2, v3, v4, v5, v17, v18, arr_f[v25], z1, ((boolean)v16), v8 + 4, v9, v10, z2);
            }
            Z.q(46, v25, "Unexpected aspect_ratio_idc value: ", "NalUnitUtil");
        }
        return new SpsData(v2, v3, v4, v5, v17, v18, 1.0f, z1, ((boolean)v16), v8 + 4, v9, v10, z2);
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray0, int v) {
        int v1 = 8;
        int v3 = 8;
        for(int v2 = 0; v2 < v; ++v2) {
            if(v1 != 0) {
                v1 = (parsableNalUnitBitArray0.readSignedExpGolombCodedInt() + v3 + 0x100) % 0x100;
            }
            if(v1 != 0) {
                v3 = v1;
            }
        }
    }

    public static int unescapeStream(byte[] arr_b, int v) {
        Object object0 = NalUnitUtil.scratchEscapePositionsLock;
        __monitor_enter(object0);
        int v1 = 0;
        int v2 = 0;
        try {
            while(v1 < v) {
                v1 = NalUnitUtil.findNextUnescapeIndex(arr_b, v1, v);
                if(v1 < v) {
                    int[] arr_v = NalUnitUtil.scratchEscapePositions;
                    if(arr_v.length <= v2) {
                        NalUnitUtil.scratchEscapePositions = Arrays.copyOf(arr_v, arr_v.length * 2);
                    }
                    NalUnitUtil.scratchEscapePositions[v2] = v1;
                    v1 += 3;
                    ++v2;
                }
            }
            int v4 = v - v2;
            int v6 = 0;
            int v7 = 0;
            for(int v5 = 0; v5 < v2; ++v5) {
                int v8 = NalUnitUtil.scratchEscapePositions[v5] - v7;
                System.arraycopy(arr_b, v7, arr_b, v6, v8);
                int v9 = v6 + v8;
                arr_b[v9] = 0;
                v6 = v9 + 2;
                arr_b[v9 + 1] = 0;
                v7 += v8 + 3;
            }
            System.arraycopy(arr_b, v7, arr_b, v6, v4 - v6);
            return v4;
        }
        finally {
            __monitor_exit(object0);
        }
    }
}

