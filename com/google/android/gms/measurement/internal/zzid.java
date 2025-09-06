package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzid implements Runnable {
    final zzr zza;
    final zzjc zzb;

    public zzid(zzjc zzjc0, zzr zzr0) {
        this.zza = zzr0;
        Objects.requireNonNull(zzjc0);
        this.zzb = zzjc0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zzL().zzY();
        this.zzb.zzL().zzag(this.zza);
    }
}

