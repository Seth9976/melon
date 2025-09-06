package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzpk implements k {
    private static final zzpk zza;
    private final k zzb;

    static {
        zzpk.zza = new zzpk();
    }

    public zzpk() {
        this.zzb = new o(new zzpm());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzc();
    }

    @SideEffectFree
    public static boolean zza() {
        zzpk.zza.zzc().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzb() {
        return zzpk.zza.zzc().zzb();
    }

    public final zzpl zzc() {
        return (zzpl)this.zzb.get();
    }
}

