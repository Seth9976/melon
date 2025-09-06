package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzrd implements k {
    private static final zzrd zza;
    private final k zzb;

    static {
        zzrd.zza = new zzrd();
    }

    public zzrd() {
        this.zzb = new o(new zzrf());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzc();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzrd.zza.zzc().zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return zzrd.zza.zzc().zzb();
    }

    public final zzre zzc() {
        return (zzre)this.zzb.get();
    }
}

