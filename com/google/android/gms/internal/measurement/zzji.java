package com.google.android.gms.internal.measurement;

public final class zzji {
    private static zzjh zza;

    public static void zza(zzjh zzjh0) {
        synchronized(zzji.class) {
            if(zzji.zza == null) {
                zzji.zza = zzjh0;
                return;
            }
        }
        throw new IllegalStateException("init() already called");
    }

    public static zzjh zzb() {
        synchronized(zzji.class) {
            if(zzji.zza == null) {
                zzji.zza(new zzjl());
            }
            return zzji.zza;
        }
    }
}

