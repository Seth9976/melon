package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcu;
import java.util.Objects;

final class zzj implements Runnable {
    final zzcu zza;
    final zzbg zzb;
    final String zzc;
    final AppMeasurementDynamiteService zzd;

    public zzj(AppMeasurementDynamiteService appMeasurementDynamiteService0, zzcu zzcu0, zzbg zzbg0, String s) {
        this.zza = zzcu0;
        this.zzb = zzbg0;
        this.zzc = s;
        Objects.requireNonNull(appMeasurementDynamiteService0);
        this.zzd = appMeasurementDynamiteService0;
        super();
    }

    @Override
    public final void run() {
        this.zzd.zza.zzt().zzN(this.zza, this.zzb, this.zzc);
    }
}

