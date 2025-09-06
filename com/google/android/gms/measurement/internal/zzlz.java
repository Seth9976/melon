package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzlz implements Runnable {
    final zzma zza;

    public zzlz(zzma zzma0) {
        Objects.requireNonNull(zzma0);
        this.zza = zzma0;
        super();
    }

    @Override
    public final void run() {
        this.zza.zzx(null);
    }
}

