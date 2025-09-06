package com.google.android.gms.measurement.internal;

public enum zzlr {
    GOOGLE_ANALYTICS(0),
    GOOGLE_SIGNAL(1),
    SGTM(2),
    SGTM_CLIENT(3),
    GOOGLE_SIGNAL_PENDING(4),
    UNKNOWN(99);

    private final int zzg;

    private zzlr(int v1) {
        this.zzg = v1;
    }

    public final int zza() {
        return this.zzg;
    }

    public static zzlr zzb(int v) {
        zzlr[] arr_zzlr = zzlr.values();
        for(int v1 = 0; v1 < arr_zzlr.length; ++v1) {
            zzlr zzlr0 = arr_zzlr[v1];
            if(zzlr0.zzg == v) {
                return zzlr0;
            }
        }
        return zzlr.zzf;
    }
}

