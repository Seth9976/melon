package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzpb implements k {
    private static final zzpb zza;
    private final k zzb;

    static {
        zzpb.zza = new zzpb();
    }

    public zzpb() {
        this.zzb = new o(new zzpd());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzb();
    }

    @SideEffectFree
    public static long zza() {
        return zzpb.zza.zzb().zza();
    }

    public final zzpc zzb() {
        return (zzpc)this.zzb.get();
    }
}

