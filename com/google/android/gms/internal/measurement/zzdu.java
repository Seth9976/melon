package com.google.android.gms.internal.measurement;

import java.util.Objects;

final class zzdu extends zzcw {
    final Runnable zza;

    public zzdu(zzdv zzdv0, Runnable runnable0) {
        this.zza = runnable0;
        Objects.requireNonNull(zzdv0);
        super();
    }

    @Override  // com.google.android.gms.internal.measurement.zzcx
    public final void zze() {
        this.zza.run();
    }
}

