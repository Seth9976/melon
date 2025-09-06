package com.google.android.gms.internal.cast;

public final class zzf implements Runnable {
    public final zzh zza;
    public final zzqe zzb;
    public final int zzc;

    public zzf(zzh zzh0, zzqe zzqe0, int v) {
        this.zza = zzh0;
        this.zzb = zzqe0;
        this.zzc = v;
    }

    @Override
    public final void run() {
        zzh.zzd(this.zza, this.zzb, this.zzc);
    }
}

