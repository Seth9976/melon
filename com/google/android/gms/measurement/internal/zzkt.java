package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzkt implements Runnable {
    final zzjk zza;
    final long zzb;
    final boolean zzc;
    final zzli zzd;

    public zzkt(zzli zzli0, zzjk zzjk0, long v, boolean z) {
        this.zza = zzjk0;
        this.zzb = v;
        this.zzc = z;
        Objects.requireNonNull(zzli0);
        this.zzd = zzli0;
        super();
    }

    @Override
    public final void run() {
        this.zzd.zzA(this.zza);
        this.zzd.zzaj(this.zza, this.zzb, true, this.zzc);
    }
}

