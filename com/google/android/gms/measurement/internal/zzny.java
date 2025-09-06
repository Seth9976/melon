package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzny extends zzay {
    final zznz zza;

    public zzny(zznz zznz0, zzjf zzjf0) {
        Objects.requireNonNull(zznz0);
        this.zza = zznz0;
        super(zzjf0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        this.zza.zzc.zzg();
        long v = this.zza.zzc.zzu.zzaZ().elapsedRealtime();
        this.zza.zzd(false, false, v);
        this.zza.zzc.zzu.zzw().zzc(this.zza.zzc.zzu.zzaZ().elapsedRealtime());
    }
}

