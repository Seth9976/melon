package com.google.android.gms.internal.cast;

public final class zzhm {
    public static Object zza(Object object0, int v) {
        if(object0 == null) {
            throw new NullPointerException("at index " + v);
        }
        return object0;
    }

    public static Object[] zzb(Object[] arr_object, int v) {
        for(int v1 = 0; v1 < v; ++v1) {
            zzhm.zza(arr_object[v1], v1);
        }
        return arr_object;
    }
}

