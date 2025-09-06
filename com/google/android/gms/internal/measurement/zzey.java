package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzey extends zzeq {
    final Activity zza;
    final zzco zzb;
    final zzfa zzc;

    public zzey(zzfa zzfa0, Activity activity0, zzco zzco0) {
        this.zza = activity0;
        this.zzb = zzco0;
        Objects.requireNonNull(zzfa0);
        this.zzc = zzfa0;
        super(zzfa0.zza, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzc.zza.zzQ())).onActivitySaveInstanceStateByScionActivityInfo(zzdf.zza(this.zza), this.zzb, this.zzi);
    }
}

