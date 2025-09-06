package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdz extends zzeq {
    final zzco zza;
    final zzfb zzb;

    public zzdz(zzfb zzfb0, zzco zzco0) {
        this.zza = zzco0;
        Objects.requireNonNull(zzfb0);
        this.zzb = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzb.zzQ())).getCurrentScreenName(this.zza);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zzb() {
        this.zza.zzb(null);
    }
}

