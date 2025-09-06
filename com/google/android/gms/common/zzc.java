package com.google.android.gms.common;

import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zzc {
    public static int zza(int v) {
        for(int v1 = 0; v1 < 3; ++v1) {
            int v2 = new int[]{1, 2, 3}[v1];
            if(v2 == 0) {
                throw null;
            }
            if(v2 - 1 == v) {
                return v2;
            }
        }
        return 1;
    }
}

