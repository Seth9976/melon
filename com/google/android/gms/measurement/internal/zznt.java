package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zznt implements Runnable {
    final long zza;
    final zzob zzb;

    public zznt(zzob zzob0, long v) {
        this.zza = v;
        Objects.requireNonNull(zzob0);
        this.zzb = zzob0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zzk(this.zza);
    }
}

