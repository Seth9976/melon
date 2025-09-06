package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzqf implements k {
    private static final zzqf zza;
    private final k zzb;

    static {
        zzqf.zza = new zzqf();
    }

    public zzqf() {
        this.zzb = new o(new zzqh());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzb();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzqf.zza.zzb().zza();
    }

    public final zzqg zzb() {
        return (zzqg)this.zzb.get();
    }
}

