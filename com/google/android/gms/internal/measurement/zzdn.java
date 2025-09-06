package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdn extends zzeq {
    final Boolean zza;
    final zzfb zzb;

    public zzdn(zzfb zzfb0, Boolean boolean0) {
        this.zza = boolean0;
        Objects.requireNonNull(zzfb0);
        this.zzb = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzb.zzQ())).setMeasurementEnabled(this.zza.booleanValue(), this.zzh);
    }
}

