package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzpt implements k {
    private static final zzpt zza;
    private final k zzb;

    static {
        zzpt.zza = new zzpt();
    }

    public zzpt() {
        this.zzb = new o(new zzpv());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzb();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzpt.zza.zzb().zza();
    }

    public final zzpu zzb() {
        return (zzpu)this.zzb.get();
    }
}

