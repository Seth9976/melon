package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzjz implements Runnable {
    final long zza;
    final zzli zzb;

    public zzjz(zzli zzli0, long v) {
        this.zza = v;
        Objects.requireNonNull(zzli0);
        this.zzb = zzli0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zzu.zzd().zzf.zzb(this.zza);
        this.zzb.zzu.zzaV().zzj().zzb("Session timeout duration set", this.zza);
    }
}

