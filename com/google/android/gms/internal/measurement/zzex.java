package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzex extends zzeq {
    final Activity zza;
    final zzfa zzb;

    public zzex(zzfa zzfa0, Activity activity0) {
        this.zza = activity0;
        Objects.requireNonNull(zzfa0);
        this.zzb = zzfa0;
        super(zzfa0.zza, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzb.zza.zzQ())).onActivityStoppedByScionActivityInfo(zzdf.zza(this.zza), this.zzi);
    }
}

