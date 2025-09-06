package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzl implements Runnable {
    final zzp zza;
    final AppMeasurementDynamiteService zzb;

    public zzl(AppMeasurementDynamiteService appMeasurementDynamiteService0, zzp zzp0) {
        this.zza = zzp0;
        Objects.requireNonNull(appMeasurementDynamiteService0);
        this.zzb = appMeasurementDynamiteService0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zza.zzj().zzV(this.zza);
    }
}

