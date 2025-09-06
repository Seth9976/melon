package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzph implements k {
    private static final zzph zza;
    private final k zzb;

    static {
        zzph.zza = new zzph();
    }

    public zzph() {
        this.zzb = new o(new zzpj());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzc();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzph.zza.zzc().zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return zzph.zza.zzc().zzb();
    }

    public final zzpi zzc() {
        return (zzpi)this.zzb.get();
    }
}

