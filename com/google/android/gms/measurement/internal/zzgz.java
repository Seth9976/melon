package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzgz implements Runnable {
    final boolean zza;
    final zzha zzb;

    public zzgz(zzha zzha0, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzha0);
        this.zzb = zzha0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zzc().zzar(this.zza);
    }
}

