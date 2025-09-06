package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zznu implements Runnable {
    final long zza;
    final zzob zzb;

    public zznu(zzob zzob0, long v) {
        this.zza = v;
        Objects.requireNonNull(zzob0);
        this.zzb = zzob0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zzl(this.zza);
    }
}

