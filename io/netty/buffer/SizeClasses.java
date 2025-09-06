package io.netty.buffer;

import java.lang.reflect.Array;

final class SizeClasses implements SizeClassesMetric {
    static final boolean $assertionsDisabled = false;
    private static final int LOG2DELTA_IDX = 2;
    private static final int LOG2GROUP_IDX = 1;
    private static final int LOG2_DELTA_LOOKUP_IDX = 6;
    private static final int LOG2_MAX_LOOKUP_SIZE = 12;
    static final int LOG2_QUANTUM = 4;
    private static final int LOG2_SIZE_CLASS_GROUP = 2;
    private static final int NDELTA_IDX = 3;
    private static final int PAGESIZE_IDX = 4;
    private static final int SUBPAGE_IDX = 5;
    final int chunkSize;
    final int directMemoryCacheAlignment;
    final int lookupMaxSize;
    final int nPSizes;
    final int nSizes;
    final int nSubpages;
    private static final byte no = 0;
    private final int[] pageIdx2sizeTab;
    final int pageShifts;
    final int pageSize;
    private final int[] size2idxTab;
    private final int[] sizeIdx2sizeTab;
    final int smallMaxSizeIdx;
    private static final byte yes = 1;

    public SizeClasses(int v, int v1, int v2, int v3) {
        int[] arr_v = new int[2];
        arr_v[1] = 7;
        arr_v[0] = PoolThreadCache.log2(v2) - 5 << 2;
        short[][] arr2_v = (short[][])Array.newInstance(Short.TYPE, arr_v);
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        while(v7 < 4) {
            short[] arr_v1 = SizeClasses.newSizeClass(v5, 4, 4, v7, v1);
            arr2_v[v5] = arr_v1;
            v6 = SizeClasses.sizeOf(arr_v1, v3);
            ++v7;
            ++v5;
        }
        int v8 = 6;
        for(int v9 = 4; v6 < v2; ++v9) {
            int v10 = 1;
            while(v10 <= 4 && v6 < v2) {
                short[] arr_v2 = SizeClasses.newSizeClass(v5, v8, v9, v10, v1);
                arr2_v[v5] = arr_v2;
                v6 = SizeClasses.sizeOf(arr_v2, v3);
                ++v10;
                ++v5;
            }
            ++v8;
        }
        int v11 = 0;
        int v12 = 0;
        int v13 = 0;
        int v14 = 0;
        for(int v4 = 0; v4 < v5; ++v4) {
            short[] arr_v3 = arr2_v[v4];
            if(arr_v3[4] == 1) {
                ++v13;
            }
            if(arr_v3[5] == 1) {
                ++v14;
                v11 = v4;
            }
            if(arr_v3[6] != 0) {
                v12 = SizeClasses.sizeOf(arr_v3, v3);
            }
        }
        this.smallMaxSizeIdx = v11;
        this.lookupMaxSize = v12;
        this.nPSizes = v13;
        this.nSubpages = v14;
        this.nSizes = v5;
        this.pageSize = v;
        this.pageShifts = v1;
        this.chunkSize = v2;
        this.directMemoryCacheAlignment = v3;
        this.sizeIdx2sizeTab = SizeClasses.newIdx2SizeTab(arr2_v, v5, v3);
        this.pageIdx2sizeTab = SizeClasses.newPageIdx2sizeTab(arr2_v, v5, v13, v3);
        this.size2idxTab = SizeClasses.newSize2idxTab(v12, arr2_v);
    }

    private static int alignSizeIfNeeded(int v, int v1) {
        if(v1 > 0) {
            int v2 = v1 - 1 & v;
            return v2 == 0 ? v : v + v1 - v2;
        }
        return v;
    }

    private static int calculateSize(int v, int v1, int v2) [...] // Inlined contents

    private static int[] newIdx2SizeTab(short[][] arr2_v, int v, int v1) {
        int[] arr_v = new int[v];
        for(int v2 = 0; v2 < v; ++v2) {
            arr_v[v2] = SizeClasses.sizeOf(arr2_v[v2], v1);
        }
        return arr_v;
    }

    private static int[] newPageIdx2sizeTab(short[][] arr2_v, int v, int v1, int v2) {
        int[] arr_v = new int[v1];
        int v4 = 0;
        for(int v3 = 0; v3 < v; ++v3) {
            short[] arr_v1 = arr2_v[v3];
            if(arr_v1[4] == 1) {
                arr_v[v4] = SizeClasses.sizeOf(arr_v1, v2);
                ++v4;
            }
        }
        return arr_v;
    }

    private static int[] newSize2idxTab(int v, short[][] arr2_v) {
        int[] arr_v = new int[v >> 4];
        int v1 = 0;
        int v3 = 0;
        for(int v2 = 0; v1 <= v; ++v2) {
            for(int v4 = 1 << arr2_v[v2][2] - 4; v1 <= v && v4 > 0; --v4) {
                arr_v[v3] = v2;
                int v5 = v3 + 2 << 4;
                ++v3;
                v1 = v5;
            }
        }
        return arr_v;
    }

    private static short[] newSizeClass(int v, int v1, int v2, int v3, int v4) {
        short v6;
        if(v2 < v4) {
            int v5 = (1 << v1) + (v3 << v2);
            v6 = v5 == v5 / (1 << v4) * (1 << v4) ? 1 : 0;
        }
        else {
            v6 = 1;
        }
        int v7 = v3 == 0 ? 0 : PoolThreadCache.log2(v3);
        boolean z = 1 << v7 < v3;
        int v8 = v7 + v2 == v1 ? v1 + 1 : v1;
        if(v8 == v1) {
            z = true;
        }
        short v9 = v8 >= v4 + 2 ? 0 : 1;
        return v8 < 12 || v8 == 12 && !z ? new short[]{((short)v), ((short)v1), ((short)v2), ((short)v3), v6, v9, ((short)v2)} : new short[]{((short)v), ((short)v1), ((short)v2), ((short)v3), v6, v9, 0};
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public int normalizeSize(int v) {
        if(v == 0) {
            return this.sizeIdx2sizeTab[0];
        }
        int v1 = SizeClasses.alignSizeIfNeeded(v, this.directMemoryCacheAlignment);
        return v1 > this.lookupMaxSize ? SizeClasses.normalizeSizeCompute(v1) : this.sizeIdx2sizeTab[this.size2idxTab[v1 - 1 >> 4]];
    }

    private static int normalizeSizeCompute(int v) {
        int v1 = PoolThreadCache.log2((v << 1) - 1);
        int v2 = (1 << (v1 >= 7 ? v1 - 3 : 4)) - 1;
        return v + v2 & ~v2;
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public long pageIdx2size(int v) {
        return (long)this.pageIdx2sizeTab[v];
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public long pageIdx2sizeCompute(int v) {
        int v1 = v >> 2;
        long v2 = v1 == 0 ? 0L : 1L << this.pageShifts + 1 << v1;
        if(v1 == 0) {
            v1 = 1;
        }
        return v2 + ((long)((v & 3) + 1 << v1 + this.pageShifts - 1));
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public int pages2pageIdx(int v) {
        return this.pages2pageIdxCompute(v, false);
    }

    private int pages2pageIdxCompute(int v, boolean z) {
        int v1 = v << this.pageShifts;
        if(v1 > this.chunkSize) {
            return this.nPSizes;
        }
        int v2 = PoolThreadCache.log2((v1 << 1) - 1);
        int v3 = ((v2 >= this.pageShifts + 2 ? v2 - (this.pageShifts + 2) : 0) << 2) + (v1 - 1 >> (v2 >= this.pageShifts + 3 ? v2 - 3 : this.pageShifts) & 3);
        return !z || this.pageIdx2sizeTab[v3] <= v << this.pageShifts ? v3 : v3 - 1;
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public int pages2pageIdxFloor(int v) {
        return this.pages2pageIdxCompute(v, true);
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public int size2SizeIdx(int v) {
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(v > this.chunkSize) {
            return this.nSizes;
        }
        int v2 = SizeClasses.alignSizeIfNeeded(v, this.directMemoryCacheAlignment);
        int v3 = 4;
        if(v2 <= this.lookupMaxSize) {
            return this.size2idxTab[v2 - 1 >> 4];
        }
        int v4 = PoolThreadCache.log2((v2 << 1) - 1);
        if(v4 >= 7) {
            v1 = v4 - 6;
        }
        if(v4 >= 7) {
            v3 = v4 - 3;
        }
        return (v1 << 2) + (v2 - 1 >> v3 & 3);
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public int sizeIdx2size(int v) {
        return this.sizeIdx2sizeTab[v];
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public int sizeIdx2sizeCompute(int v) {
        int v1 = v >> 2;
        int v2 = v1 == 0 ? 0 : 0x20 << v1;
        if(v1 == 0) {
            v1 = 1;
        }
        return v2 + ((v & 3) + 1 << v1 + 3);
    }

    private static int sizeOf(short[] arr_v, int v) {
        return SizeClasses.alignSizeIfNeeded(SizeClasses.calculateSize(arr_v[1], arr_v[3], arr_v[2]), v);
    }
}

