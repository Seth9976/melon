package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzlw implements Runnable {
    final zzma zza;

    public zzlw(zzma zzma0) {
        Objects.requireNonNull(zzma0);
        this.zza = zzma0;
        super();
    }

    @Override
    public final void run() {
        this.zza.zza = this.zza.zzw();
    }
}

