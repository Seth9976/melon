package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzov implements k {
    private static final zzov zza;
    private final k zzb;

    static {
        zzov.zza = new zzov();
    }

    public zzov() {
        this.zzb = new o(new zzox());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzb();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzov.zza.zzb().zza();
    }

    public final zzow zzb() {
        return (zzow)this.zzb.get();
    }
}

