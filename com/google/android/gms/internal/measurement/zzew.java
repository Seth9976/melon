package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzew extends zzeq {
    final Activity zza;
    final zzfa zzb;

    public zzew(zzfa zzfa0, Activity activity0) {
        this.zza = activity0;
        Objects.requireNonNull(zzfa0);
        this.zzb = zzfa0;
        super(zzfa0.zza, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzb.zza.zzQ())).onActivityPausedByScionActivityInfo(zzdf.zza(this.zza), this.zzi);
    }
}

