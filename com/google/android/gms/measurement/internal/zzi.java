package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcu;
import java.util.Objects;

final class zzi implements Runnable {
    final zzcu zza;
    final AppMeasurementDynamiteService zzb;

    public zzi(AppMeasurementDynamiteService appMeasurementDynamiteService0, zzcu zzcu0) {
        this.zza = zzcu0;
        Objects.requireNonNull(appMeasurementDynamiteService0);
        this.zzb = appMeasurementDynamiteService0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zza.zzt().zzD(this.zza);
    }
}

