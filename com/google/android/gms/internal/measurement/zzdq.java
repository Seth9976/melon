package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdq extends zzeq {
    final long zza;
    final zzfb zzb;

    public zzdq(zzfb zzfb0, long v) {
        this.zza = v;
        Objects.requireNonNull(zzfb0);
        this.zzb = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzb.zzQ())).setSessionTimeoutDuration(this.zza);
    }
}

