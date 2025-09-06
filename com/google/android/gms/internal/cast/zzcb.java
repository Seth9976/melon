package com.google.android.gms.internal.cast;

import com.google.android.gms.common.util.DefaultClock;

public final class zzcb {
    final long zza;
    private final Integer zzb;
    private final Boolean zzc;
    private long zzd;
    private final int zze;

    public zzcb(zzca zzca0) {
        this.zze = zzca0.zzc;
        this.zzb = zzca0.zza;
        this.zzc = zzca0.zzb;
        this.zza = DefaultClock.getInstance().currentTimeMillis();
    }

    public final zzqk zza() {
        zzqj zzqj0 = zzqk.zza();
        zzqj0.zze(this.zze);
        int v = (int)(this.zza - this.zzd);
        zzqj0.zzc(((long)v));
        zzqj0.zzd(v);
        Integer integer0 = this.zzb;
        if(integer0 != null) {
            zzqj0.zzb(((int)integer0));
        }
        Boolean boolean0 = this.zzc;
        if(boolean0 != null) {
            zzqj0.zza(boolean0.booleanValue());
        }
        return (zzqk)zzqj0.zzr();
    }

    public final void zzb(long v) {
        this.zzd = v;
    }

    public final int zzc() {
        return this.zze;
    }
}

