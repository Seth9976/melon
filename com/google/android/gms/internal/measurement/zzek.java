package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzek extends zzeq {
    final Bundle zza;
    final zzfb zzb;

    public zzek(zzfb zzfb0, Bundle bundle0) {
        this.zza = bundle0;
        Objects.requireNonNull(zzfb0);
        this.zzb = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzb.zzQ())).setDefaultEventParameters(this.zza);
    }
}

