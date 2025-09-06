package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzee extends zzeq {
    final Bundle zza;
    final zzco zzb;
    final zzfb zzc;

    public zzee(zzfb zzfb0, Bundle bundle0, zzco zzco0) {
        this.zza = bundle0;
        this.zzb = zzco0;
        Objects.requireNonNull(zzfb0);
        this.zzc = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzc.zzQ())).performAction(this.zza, this.zzb, this.zzh);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zzb() {
        this.zzb.zzb(null);
    }
}

