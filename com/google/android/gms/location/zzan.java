package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

public final class zzan {
    public static int zza(int v) {
        boolean z = true;
        switch(v) {
            case 100: 
            case 102: 
            case 104: {
                break;
            }
            case 105: {
                v = 105;
                break;
            }
            default: {
                z = false;
            }
        }
        Preconditions.checkArgument(z, "priority %d must be a Priority.PRIORITY_* constant", new Object[]{v});
        return v;
    }

    public static String zzb(int v) {
        switch(v) {
            case 100: {
                return "HIGH_ACCURACY";
            }
            case 102: {
                return "BALANCED_POWER_ACCURACY";
            }
            case 104: {
                return "LOW_POWER";
            }
            case 105: {
                return "PASSIVE";
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
}

