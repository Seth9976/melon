package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzqc implements k {
    private static final zzqc zza;
    private final k zzb;

    static {
        zzqc.zza = new zzqc();
    }

    public zzqc() {
        this.zzb = new o(new zzqe());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzb();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzqc.zza.zzb().zza();
    }

    public final zzqd zzb() {
        return (zzqd)this.zzb.get();
    }
}

