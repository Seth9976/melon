package com.google.android.gms.internal.cast;

public abstract class zzgf {
    private static final ThreadLocal zza;

    static {
        zzgf.zza = new zzfz();
    }

    public abstract void zza(zzgc arg1);

    public static zzgf zzb() {
        return (zzgf)zzgf.zza.get();
    }
}

