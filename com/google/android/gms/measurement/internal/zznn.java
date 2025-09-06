package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zznn implements Runnable {
    final zzpf zza;
    final Runnable zzb;

    public zznn(zzns zzns0, zzpf zzpf0, Runnable runnable0) {
        this.zza = zzpf0;
        this.zzb = runnable0;
        Objects.requireNonNull(zzns0);
        super();
    }

    @Override
    public final void run() {
        this.zza.zzY();
        this.zza.zzX(this.zzb);
        this.zza.zzM();
    }
}

