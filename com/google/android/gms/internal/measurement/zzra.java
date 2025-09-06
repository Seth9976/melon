package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzra implements k {
    private static final zzra zza;
    private final k zzb;

    static {
        zzra.zza = new zzra();
    }

    public zzra() {
        this.zzb = new o(new zzrc());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzb();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzra.zza.zzb().zza();
    }

    public final zzrb zzb() {
        return (zzrb)this.zzb.get();
    }
}

