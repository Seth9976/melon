package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzou implements Runnable {
    final zzpg zza;
    final zzpf zzb;

    public zzou(zzpf zzpf0, zzpg zzpg0) {
        this.zza = zzpg0;
        Objects.requireNonNull(zzpf0);
        this.zzb = zzpf0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zzat(this.zza);
        this.zzb.zzc();
    }
}

