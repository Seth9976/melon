package com.google.android.gms.internal.common;

import com.iloen.melon.utils.a;

public final class zzak {
    public static Object[] zza(Object[] arr_object, int v) {
        for(int v1 = 0; v1 < v; ++v1) {
            if(arr_object[v1] == null) {
                throw new NullPointerException(a.k(v1, "at index ", new StringBuilder(String.valueOf(v1).length() + 9)));
            }
        }
        return arr_object;
    }
}

