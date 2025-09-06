package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzrg implements k {
    private static final zzrg zza;
    private final k zzb;

    static {
        zzrg.zza = new zzrg();
    }

    public zzrg() {
        this.zzb = new o(new zzri());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzc();
    }

    @SideEffectFree
    public static boolean zza() {
        zzrg.zza.zzc().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzb() {
        return zzrg.zza.zzc().zzb();
    }

    public final zzrh zzc() {
        return (zzrh)this.zzb.get();
    }
}

