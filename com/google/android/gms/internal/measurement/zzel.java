package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzel extends zzeq {
    final zzer zza;
    final zzfb zzb;

    public zzel(zzfb zzfb0, zzer zzer0) {
        this.zza = zzer0;
        Objects.requireNonNull(zzfb0);
        this.zzb = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzb.zzQ())).setEventInterceptor(this.zza);
    }
}

