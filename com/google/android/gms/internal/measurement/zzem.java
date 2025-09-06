package com.google.android.gms.internal.measurement;

import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzem extends zzeq {
    final Intent zza;
    final zzfb zzb;

    public zzem(zzfb zzfb0, Intent intent0) {
        this.zza = intent0;
        Objects.requireNonNull(zzfb0);
        this.zzb = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzb.zzQ())).setSgtmDebugInfo(this.zza);
    }
}

