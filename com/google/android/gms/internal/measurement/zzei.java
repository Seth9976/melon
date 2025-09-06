package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzei extends zzeq {
    final zzco zza;
    final int zzb;
    final zzfb zzc;

    public zzei(zzfb zzfb0, zzco zzco0, int v) {
        this.zza = zzco0;
        this.zzb = v;
        Objects.requireNonNull(zzfb0);
        this.zzc = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzc.zzQ())).getTestFlag(this.zza, this.zzb);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zzb() {
        this.zza.zzb(null);
    }
}

