package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcu;
import java.util.Objects;

final class zzm implements Runnable {
    final zzcu zza;
    final String zzb;
    final String zzc;
    final AppMeasurementDynamiteService zzd;

    public zzm(AppMeasurementDynamiteService appMeasurementDynamiteService0, zzcu zzcu0, String s, String s1) {
        this.zza = zzcu0;
        this.zzb = s;
        this.zzc = s1;
        Objects.requireNonNull(appMeasurementDynamiteService0);
        this.zzd = appMeasurementDynamiteService0;
        super();
    }

    @Override
    public final void run() {
        this.zzd.zza.zzt().zzs(this.zza, this.zzb, this.zzc);
    }
}

