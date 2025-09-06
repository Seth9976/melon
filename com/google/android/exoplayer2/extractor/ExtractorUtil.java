package com.google.android.exoplayer2.extractor;

final class ExtractorUtil {
    public static int peekToLength(ExtractorInput extractorInput0, byte[] arr_b, int v, int v1) {
        int v2;
        for(v2 = 0; v2 < v1; v2 += v3) {
            int v3 = extractorInput0.peek(arr_b, v + v2, v1 - v2);
            if(v3 == -1) {
                break;
            }
        }
        return v2;
    }
}

