package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzpn implements k {
    private static final zzpn zza;
    private final k zzb;

    static {
        zzpn.zza = new zzpn();
    }

    public zzpn() {
        this.zzb = new o(new zzpp());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzd();
    }

    @SideEffectFree
    public static boolean zza() {
        zzpn.zza.zzd().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzb() {
        return zzpn.zza.zzd().zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return zzpn.zza.zzd().zzc();
    }

    public final zzpo zzd() {
        return (zzpo)this.zzb.get();
    }
}

