package com.google.android.gms.internal.play_billing;

abstract class zzdq {
    private static final zzdq zza;
    private static final zzdq zzb;

    static {
        zzdq.zza = new zzdm(null);
        zzdq.zzb = new zzdo(null);
    }

    public zzdq(zzdp zzdp0) {
    }

    public abstract void zza(Object arg1, long arg2);

    public abstract void zzb(Object arg1, Object arg2, long arg3);

    public static zzdq zzc() {
        return zzdq.zza;
    }

    public static zzdq zzd() {
        return zzdq.zzb;
    }
}

