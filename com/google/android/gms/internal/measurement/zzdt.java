package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdt extends zzeq {
    final String zza;
    final zzfb zzb;

    public zzdt(zzfb zzfb0, String s) {
        this.zza = s;
        Objects.requireNonNull(zzfb0);
        this.zzb = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzb.zzQ())).endAdUnitExposure(this.zza, this.zzi);
    }
}

