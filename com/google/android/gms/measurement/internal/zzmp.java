package com.google.android.gms.measurement.internal;

import b3.Z;
import java.util.Objects;

final class zzmp extends zzay {
    final zznk zza;

    public zzmp(zznk zznk0, zzjf zzjf0) {
        Objects.requireNonNull(zznk0);
        this.zza = zznk0;
        super(zzjf0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        Z.A(this.zza.zzu, "Tasks have been queued for a long time");
    }
}

