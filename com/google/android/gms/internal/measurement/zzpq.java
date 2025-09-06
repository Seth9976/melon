package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzpq implements k {
    private static final zzpq zza;
    private final k zzb;

    static {
        zzpq.zza = new zzpq();
    }

    public zzpq() {
        this.zzb = new o(new zzps());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zze();
    }

    @SideEffectFree
    public static boolean zza() {
        zzpq.zza.zze().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzb() {
        return zzpq.zza.zze().zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return zzpq.zza.zze().zzc();
    }

    @SideEffectFree
    public static boolean zzd() {
        return zzpq.zza.zze().zzd();
    }

    public final zzpr zze() {
        return (zzpr)this.zzb.get();
    }
}

