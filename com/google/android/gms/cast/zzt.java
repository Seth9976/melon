package com.google.android.gms.cast;

import java.util.Collection;

final class zzt {
    private String zza;
    private String zzb;
    private Collection zzc;

    private zzt() {
        this.zza = "com.google.android.gms.cast.CATEGORY_CAST";
    }

    public zzt(zzv zzv0) {
        this.zza = "com.google.android.gms.cast.CATEGORY_CAST";
    }

    public static zzt zza(zzt zzt0, String s) {
        zzt0.zzb = s;
        return zzt0;
    }

    public static zzt zzb(zzt zzt0, String s) [...] // 潜在的解密器

    public static zzt zzc(zzt zzt0, Collection collection0) {
        zzt0.zzc = collection0;
        return zzt0;
    }

    public static zzu zzd(zzt zzt0) {
        return new zzu(zzt0.zza, zzt0.zzb, zzt0.zzc, false, true, null);
    }
}

