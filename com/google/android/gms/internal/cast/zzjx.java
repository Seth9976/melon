package com.google.android.gms.internal.cast;

enum zzjx {
    BOOLEAN,
    STRING,
    LONG,
    DOUBLE;

    public static zzjx zza(Object object0) {
        if(object0 instanceof String) {
            return zzjx.zzb;
        }
        if(object0 instanceof Boolean) {
            return zzjx.zza;
        }
        if(object0 instanceof Long) {
            return zzjx.zzc;
        }
        if(!(object0 instanceof Double)) {
            throw new AssertionError("invalid tag type: " + object0.getClass());
        }
        return zzjx.zzd;
    }
}

