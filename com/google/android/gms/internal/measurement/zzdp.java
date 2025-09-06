package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdp extends zzeq {
    final zzfb zza;

    public zzdp(zzfb zzfb0) {
        Objects.requireNonNull(zzfb0);
        this.zza = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zza.zzQ())).resetAnalyticsData(this.zzh);
    }
}

