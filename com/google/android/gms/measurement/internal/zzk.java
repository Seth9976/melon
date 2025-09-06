package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcu;
import java.util.Objects;

final class zzk implements Runnable {
    final zzcu zza;
    final String zzb;
    final String zzc;
    final boolean zzd;
    final AppMeasurementDynamiteService zze;

    public zzk(AppMeasurementDynamiteService appMeasurementDynamiteService0, zzcu zzcu0, String s, String s1, boolean z) {
        this.zza = zzcu0;
        this.zzb = s;
        this.zzc = s1;
        this.zzd = z;
        Objects.requireNonNull(appMeasurementDynamiteService0);
        this.zze = appMeasurementDynamiteService0;
        super();
    }

    @Override
    public final void run() {
        this.zze.zza.zzt().zzu(this.zza, this.zzb, this.zzc, this.zzd);
    }
}

