package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Callable;

final class zzic implements Callable {
    final String zza;
    final zzjc zzb;

    public zzic(zzjc zzjc0, String s) {
        this.zza = s;
        Objects.requireNonNull(zzjc0);
        this.zzb = zzjc0;
        super();
    }

    @Override
    public final Object call() {
        this.zzb.zzL().zzY();
        return this.zzb.zzL().zzj().zzn(this.zza);
    }
}

