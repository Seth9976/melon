package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Util;

final class FixedSampleSizeRechunker {
    public static final class Results {
        public final long duration;
        public final int[] flags;
        public final int maximumSize;
        public final long[] offsets;
        public final int[] sizes;
        public final long[] timestamps;

        private Results(long[] arr_v, int[] arr_v1, int v, long[] arr_v2, int[] arr_v3, long v1) {
            this.offsets = arr_v;
            this.sizes = arr_v1;
            this.maximumSize = v;
            this.timestamps = arr_v2;
            this.flags = arr_v3;
            this.duration = v1;
        }

        public Results(long[] arr_v, int[] arr_v1, int v, long[] arr_v2, int[] arr_v3, long v1, com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.1 fixedSampleSizeRechunker$10) {
            this(arr_v, arr_v1, v, arr_v2, arr_v3, v1);
        }
    }

    private static final int MAX_SAMPLE_SIZE = 0x2000;

    public static Results rechunk(int v, long[] arr_v, int[] arr_v1, long v1) {
        int v4 = 0;
        for(int v3 = 0; v3 < arr_v1.length; ++v3) {
            v4 += Util.ceilDivide(arr_v1[v3], 0x2000 / v);
        }
        long[] arr_v2 = new long[v4];
        int[] arr_v3 = new int[v4];
        long[] arr_v4 = new long[v4];
        int[] arr_v5 = new int[v4];
        int v5 = 0;
        int v7 = 0;
        for(int v2 = 0; v2 < arr_v1.length; ++v2) {
            int v8 = arr_v1[v2];
            long v9 = arr_v[v2];
            for(int v6 = 0; v8 > 0; ++v6) {
                int v10 = Math.min(0x2000 / v, v8);
                arr_v2[v6] = v9;
                int v11 = v * v10;
                arr_v3[v6] = v11;
                v7 = Math.max(v7, v11);
                arr_v4[v6] = ((long)v5) * v1;
                arr_v5[v6] = 1;
                v9 += (long)arr_v3[v6];
                v5 += v10;
                v8 -= v10;
            }
        }
        return new Results(arr_v2, arr_v3, v7, arr_v4, arr_v5, v1 * ((long)v5), null);
    }

    class com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.1 {
    }

}

