package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzqi implements k {
    private static final zzqi zza;
    private final k zzb;

    static {
        zzqi.zza = new zzqi();
    }

    public zzqi() {
        this.zzb = new o(new zzqk());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzg();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzqi.zza.zzg().zza();
    }

    @SideEffectFree
    public static long zzb() {
        return zzqi.zza.zzg().zzb();
    }

    @SideEffectFree
    public static double zzc() {
        return zzqi.zza.zzg().zzc();
    }

    @SideEffectFree
    public static long zzd() {
        return zzqi.zza.zzg().zzd();
    }

    @SideEffectFree
    public static long zze() {
        return zzqi.zza.zzg().zze();
    }

    @SideEffectFree
    public static String zzf() {
        return zzqi.zza.zzg().zzf();
    }

    public final zzqj zzg() {
        return (zzqj)this.zzb.get();
    }
}

