package com.google.android.gms.internal.cast;

import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzx {
    private final zzh zza;
    private final zzaf zzb;
    private final String zzc;
    private zzz zzd;
    private final zzt zze;

    public zzx(zzh zzh0, zzaf zzaf0, String s) {
        this.zza = zzh0;
        this.zzb = zzaf0;
        this.zzc = s;
        this.zze = new zzt(this, null);
    }

    public static zzt zza(zzx zzx0) {
        return zzx0.zze;
    }

    public static zzz zzb(zzx zzx0) {
        return zzx0.zzd;
    }

    public static zzz zzc(zzx zzx0) {
        return zzx0.zzg();
    }

    public static zzaf zzd(zzx zzx0) {
        return zzx0.zzb;
    }

    public static void zze(zzx zzx0) {
        zzx0.zzh();
    }

    public static void zzf(zzx zzx0, zzcb zzcb0) {
        if(zzcb0.zzc() == 2 && zzx0.zzd != null) {
            zzx0.zzh();
        }
        zzx0.zzd = zzcb0.zzc() == 2 ? zzz.zza(zzx0.zza, zzx0.zzc) : zzx0.zzg();
        ((zzz)Preconditions.checkNotNull(zzx0.zzd)).zzc(zzcb0);
    }

    @EnsuresNonNull({"SessionFlowSummary"})
    private final zzz zzg() {
        if(this.zzd == null) {
            zzz zzz0 = zzz.zza(this.zza, this.zzc);
            this.zzd = zzz0;
            zzz0.zzj(1);
        }
        return this.zzd;
    }

    private final void zzh() {
        zzz zzz0 = this.zzd;
        if(zzz0 != null) {
            zzz0.zzf();
            this.zzd = null;
        }
    }
}

