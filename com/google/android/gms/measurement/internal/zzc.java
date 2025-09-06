package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzc implements Runnable {
    final long zza;
    final zzd zzb;

    public zzc(zzd zzd0, long v) {
        this.zza = v;
        Objects.requireNonNull(zzd0);
        this.zzb = zzd0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zzf(this.zza);
    }
}

