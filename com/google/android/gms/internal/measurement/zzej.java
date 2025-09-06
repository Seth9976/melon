package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzej extends zzeq {
    final boolean zza;
    final zzfb zzb;

    public zzej(zzfb zzfb0, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzfb0);
        this.zzb = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzb.zzQ())).setDataCollectionEnabled(this.zza);
    }
}

