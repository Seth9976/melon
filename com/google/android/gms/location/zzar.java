package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

public final class zzar {
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
        Preconditions.checkArgument(z, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", new Object[]{v});
        return v;
    }

    public static String zzb(int v) {
        switch(v) {
            case 0: {
                return "THROTTLE_BACKGROUND";
            }
            case 1: {
                return "THROTTLE_ALWAYS";
            }
            case 2: {
                return "THROTTLE_NEVER";
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
}

