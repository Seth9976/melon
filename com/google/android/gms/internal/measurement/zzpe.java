package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzpe implements k {
    private static final zzpe zza;
    private final k zzb;

    static {
        zzpe.zza = new zzpe();
    }

    public zzpe() {
        this.zzb = new o(new zzpg());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzc();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzpe.zza.zzc().zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return zzpe.zza.zzc().zzb();
    }

    public final zzpf zzc() {
        return (zzpf)this.zzb.get();
    }
}

