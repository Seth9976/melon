package com.google.android.gms.internal.cast;

import java.util.Set;

public final class zzhu {
    public static int zza(Set set0) {
        int v = 0;
        for(Object object0: set0) {
            v += (object0 == null ? 0 : object0.hashCode());
        }
        return v;
    }
}

