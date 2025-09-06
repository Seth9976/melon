package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class Sniffer {
    private static final int[] COMPATIBLE_BRANDS = null;
    private static final int SEARCH_LENGTH = 0x1000;

    static {
        Sniffer.COMPATIBLE_BRANDS = new int[]{0x69736F6D, 0x69736F32, 0x69736F33, 0x69736F34, 0x69736F35, 0x69736F36, 0x61766331, 1752589105, 0x68657631, 0x61763031, 0x6D703431, 0x6D703432, 862401121, 862401122, 0x33677236, 0x33677336, 0x33676536, 0x33676736, 0x4D345620, 0x4D344120, 0x66347620, 1801741417, 1295275600, 0x71742020, 1297305174, 0x64627931};
    }

    private static boolean isCompatibleBrand(int v) {
        if(v >>> 8 == 0x336770) {
            return true;
        }
        int[] arr_v = Sniffer.COMPATIBLE_BRANDS;
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            if(arr_v[v1] == v) {
                return true;
            }
        }
        return false;
    }

    public static boolean sniffFragmented(ExtractorInput extractorInput0) {
        return Sniffer.sniffInternal(extractorInput0, true);
    }

    private static boolean sniffInternal(ExtractorInput extractorInput0, boolean z) {
        int v7;
        int v6;
        long v = extractorInput0.getLength();
        int v1 = Long.compare(v, -1L);
        int v2 = (int)(v1 == 0 || v > 0x1000L ? 0x1000L : v);
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(0x40);
        int v3 = 0;
        boolean z1 = false;
        while(v3 < v2) {
            parsableByteArray0.reset(8);
            extractorInput0.peekFully(parsableByteArray0.data, 0, 8);
            long v4 = parsableByteArray0.readUnsignedInt();
            int v5 = parsableByteArray0.readInt();
            if(v4 == 1L) {
                extractorInput0.peekFully(parsableByteArray0.data, 8, 8);
                parsableByteArray0.setLimit(16);
                v6 = v3;
                v7 = 16;
                v4 = parsableByteArray0.readLong();
            }
            else {
                if(v4 == 0L) {
                    long v8 = extractorInput0.getLength();
                    if(v8 != -1L) {
                        v4 = v8 - extractorInput0.getPeekPosition() + 8L;
                    }
                }
                v6 = v3;
                v7 = 8;
            }
            if(v4 < ((long)v7)) {
                return 0;
            }
            int v9 = v6 + v7;
            if(v5 == 0x6D6F6F76) {
                v2 += (int)v4;
                v2 = v1 == 0 || ((long)v2) <= v ? v2 + ((int)v4) : ((int)v);
                v3 = v9;
                continue;
            }
            if(v5 != 0x6D6F6F66 && v5 != 0x6D766578) {
                if(((long)v9) + v4 - ((long)v7) >= ((long)v2)) {
                    break;
                }
                int v10 = (int)(v4 - ((long)v7));
                v3 = v9 + v10;
                if(v5 == 0x66747970) {
                    if(v10 < 8) {
                        return 0;
                    }
                    parsableByteArray0.reset(v10);
                    extractorInput0.peekFully(parsableByteArray0.data, 0, v10);
                    int v11 = v10 / 4;
                    for(int v12 = 0; v12 < v11; ++v12) {
                        if(v12 == 1) {
                            parsableByteArray0.skipBytes(4);
                        }
                        else if(Sniffer.isCompatibleBrand(parsableByteArray0.readInt())) {
                            z1 = true;
                            break;
                        }
                    }
                    if(z1) {
                        continue;
                    }
                    return false;
                }
                if(v10 == 0) {
                    continue;
                }
                extractorInput0.advancePeekPosition(v10);
                continue;
            }
            return z1 && z;
        }
        return z1 && !z;
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput0) {
        return Sniffer.sniffInternal(extractorInput0, false);
    }
}

