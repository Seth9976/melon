package com.google.android.gms.internal.cast;

public class zzhb {
    public static int zza(int v, int v1) {
        if(v1 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if(v1 <= v) {
            return v;
        }
        int v2 = v + (v >> 1) + 1;
        if(v2 < v1) {
            int v3 = Integer.highestOneBit(v1 - 1);
            v2 = v3 + v3;
        }
        return v2 >= 0 ? v2 : 0x7FFFFFFF;
    }
}

