package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import java.util.Objects;

final class zzna implements Runnable {
    final zzne zza;

    public zzna(zzne zzne0) {
        Objects.requireNonNull(zzne0);
        this.zza = zzne0;
        super();
    }

    @Override
    public final void run() {
        ComponentName componentName0 = new ComponentName(this.zza.zza.zzu.zzaY(), "com.google.android.gms.measurement.AppMeasurementService");
        this.zza.zza.zzW(componentName0);
    }
}

