package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzqu implements k {
    private static final zzqu zza;
    private final k zzb;

    static {
        zzqu.zza = new zzqu();
    }

    public zzqu() {
        this.zzb = new o(new zzqw());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzc();
    }

    @SideEffectFree
    public static boolean zza() {
        zzqu.zza.zzc().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzb() {
        return zzqu.zza.zzc().zzb();
    }

    public final zzqv zzc() {
        return (zzqv)this.zzb.get();
    }
}

