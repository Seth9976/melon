package com.google.android.gms.measurement.internal;

import android.util.Log;
import java.util.Objects;

final class zzjq implements zzgl {
    final zzib zza;

    public zzjq(zzjr zzjr0, zzib zzib0) {
        this.zza = zzib0;
        Objects.requireNonNull(zzjr0);
        super();
    }

    @Override  // com.google.android.gms.measurement.internal.zzgl
    public final boolean zza() {
        return Log.isLoggable(this.zza.zzaV().zzn(), 3);
    }
}

