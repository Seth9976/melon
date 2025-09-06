package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzly implements Runnable {
    final zzlt zza;
    final long zzb;
    final zzma zzc;

    public zzly(zzma zzma0, zzlt zzlt0, long v) {
        this.zza = zzlt0;
        this.zzb = v;
        Objects.requireNonNull(zzma0);
        this.zzc = zzma0;
        super();
    }

    @Override
    public final void run() {
        this.zzc.zzv(this.zza, false, this.zzb);
        this.zzc.zza = null;
        this.zzc.zzu.zzt().zzG(null);
    }
}

