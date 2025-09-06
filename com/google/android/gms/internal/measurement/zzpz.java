package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzpz implements k {
    private static final zzpz zza;
    private final k zzb;

    static {
        zzpz.zza = new zzpz();
    }

    public zzpz() {
        this.zzb = new o(new zzqb());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzb();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzpz.zza.zzb().zza();
    }

    public final zzqa zzb() {
        return (zzqa)this.zzb.get();
    }
}

