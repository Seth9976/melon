package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzef extends zzeq {
    final String zza;
    final zzco zzb;
    final zzfb zzc;

    public zzef(zzfb zzfb0, String s, zzco zzco0) {
        this.zza = s;
        this.zzb = zzco0;
        Objects.requireNonNull(zzfb0);
        this.zzc = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzc.zzQ())).getMaxUserProperties(this.zza, this.zzb);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zzb() {
        this.zzb.zzb(null);
    }
}

