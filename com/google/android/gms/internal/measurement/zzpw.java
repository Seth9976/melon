package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzpw implements k {
    private static final zzpw zza;
    private final k zzb;

    static {
        zzpw.zza = new zzpw();
    }

    public zzpw() {
        this.zzb = new o(new zzpy());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzb();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzpw.zza.zzb().zza();
    }

    public final zzpx zzb() {
        return (zzpx)this.zzb.get();
    }
}

