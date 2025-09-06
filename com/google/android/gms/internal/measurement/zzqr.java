package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzqr implements k {
    private static final zzqr zza;
    private final k zzb;

    static {
        zzqr.zza = new zzqr();
    }

    public zzqr() {
        this.zzb = new o(new zzqt());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzb();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzqr.zza.zzb().zza();
    }

    public final zzqs zzb() {
        return (zzqs)this.zzb.get();
    }
}

