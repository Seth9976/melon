package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzeo extends zzeq {
    final zzes zza;
    final zzfb zzb;

    public zzeo(zzfb zzfb0, zzes zzes0) {
        this.zza = zzes0;
        Objects.requireNonNull(zzfb0);
        this.zzb = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzb.zzQ())).unregisterOnMeasurementEventListener(this.zza);
    }
}

