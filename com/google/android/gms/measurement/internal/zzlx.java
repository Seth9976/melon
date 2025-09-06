package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzlx implements Runnable {
    final long zza;
    final zzma zzb;

    public zzlx(zzma zzma0, long v) {
        this.zza = v;
        Objects.requireNonNull(zzma0);
        this.zzb = zzma0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zzu.zzw().zzc(this.zza);
        this.zzb.zza = null;
    }
}

