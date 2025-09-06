package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzoi extends zzay {
    final zzoj zza;

    public zzoi(zzoj zzoj0, zzjf zzjf0) {
        Objects.requireNonNull(zzoj0);
        this.zza = zzoj0;
        super(zzjf0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        this.zza.zzd();
        this.zza.zzu.zzaV().zzk().zza("Starting upload from DelayedRunnable");
        this.zza.zzg.zzM();
    }
}

