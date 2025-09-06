package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzml extends zzay {
    final zznk zza;

    public zzml(zznk zznk0, zzjf zzjf0) {
        Objects.requireNonNull(zznk0);
        this.zza = zznk0;
        super(zzjf0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        zznk zznk0 = this.zza;
        zznk0.zzg();
        if(!zznk0.zzh()) {
            return;
        }
        zznk0.zzu.zzaV().zzk().zza("Inactivity, disconnecting from the service");
        zznk0.zzM();
    }
}

