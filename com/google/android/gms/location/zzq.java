package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

public final class zzq {
    public static int zza(int v) {
        boolean z = true;
        if(v != 0 && v != 1) {
            if(v == 2) {
                v = 2;
            }
            else {
                z = false;
            }
        }
        Preconditions.checkArgument(z, "granularity %d must be a Granularity.GRANULARITY_* constant", new Object[]{v});
        return v;
    }

    public static String zzb(int v) {
        switch(v) {
            case 0: {
                return "GRANULARITY_PERMISSION_LEVEL";
            }
            case 1: {
                return "GRANULARITY_COARSE";
            }
            case 2: {
                return "GRANULARITY_FINE";
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
}

