package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzkr implements Runnable {
    final Boolean zza;
    final zzli zzb;

    public zzkr(zzli zzli0, Boolean boolean0) {
        this.zza = boolean0;
        Objects.requireNonNull(zzli0);
        this.zzb = zzli0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zzai(this.zza, true);
    }
}

