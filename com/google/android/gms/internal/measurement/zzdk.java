package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdk extends zzeq {
    final String zza;
    final String zzb;
    final zzco zzc;
    final zzfb zzd;

    public zzdk(zzfb zzfb0, String s, String s1, zzco zzco0) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = zzco0;
        Objects.requireNonNull(zzfb0);
        this.zzd = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzd.zzQ())).getConditionalUserProperties(this.zza, this.zzb, this.zzc);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zzb() {
        this.zzc.zzb(null);
    }
}

