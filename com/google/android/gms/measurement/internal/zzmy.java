package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import java.util.Objects;

final class zzmy implements Runnable {
    final ComponentName zza;
    final zzne zzb;

    public zzmy(zzne zzne0, ComponentName componentName0) {
        this.zza = componentName0;
        Objects.requireNonNull(zzne0);
        this.zzb = zzne0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zza.zzW(this.zza);
    }
}

