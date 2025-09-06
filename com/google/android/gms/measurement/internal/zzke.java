package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzke implements Runnable {
    final AtomicReference zza;
    final boolean zzb;
    final zzli zzc;

    public zzke(zzli zzli0, AtomicReference atomicReference0, boolean z) {
        this.zza = atomicReference0;
        this.zzb = z;
        Objects.requireNonNull(zzli0);
        this.zzc = zzli0;
        super();
    }

    @Override
    public final void run() {
        this.zzc.zzu.zzt().zzv(this.zza, this.zzb);
    }
}

