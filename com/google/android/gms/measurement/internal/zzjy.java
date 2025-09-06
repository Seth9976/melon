package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzjy implements Runnable {
    final zzli zza;

    public zzjy(zzli zzli0) {
        Objects.requireNonNull(zzli0);
        this.zza = zzli0;
        super();
    }

    @Override
    public final void run() {
        this.zza.zzb.zza();
    }
}

