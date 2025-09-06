package com.google.android.gms.internal.auth;

abstract class zzfl {
    private static final zzfl zza;
    private static final zzfl zzb;

    static {
        zzfl.zza = new zzfh(null);
        zzfl.zzb = new zzfj(null);
    }

    public zzfl(zzfk zzfk0) {
    }

    public abstract void zza(Object arg1, long arg2);

    public abstract void zzb(Object arg1, Object arg2, long arg3);

    public static zzfl zzc() {
        return zzfl.zza;
    }

    public static zzfl zzd() {
        return zzfl.zzb;
    }
}

