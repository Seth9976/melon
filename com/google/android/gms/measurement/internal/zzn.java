package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcu;
import java.util.Objects;

final class zzn implements Runnable {
    final zzcu zza;
    final AppMeasurementDynamiteService zzb;

    public zzn(AppMeasurementDynamiteService appMeasurementDynamiteService0, zzcu zzcu0) {
        this.zza = zzcu0;
        Objects.requireNonNull(appMeasurementDynamiteService0);
        this.zzb = appMeasurementDynamiteService0;
        super();
    }

    @Override
    public final void run() {
        zzpo zzpo0 = this.zzb.zza.zzk();
        boolean z = this.zzb.zza.zzA();
        zzpo0.zzap(this.zza, z);
    }
}

