package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Callable;

final class zzip implements Callable {
    final zzr zza;
    final zzjc zzb;

    public zzip(zzjc zzjc0, zzr zzr0) {
        this.zza = zzr0;
        Objects.requireNonNull(zzjc0);
        this.zzb = zzjc0;
        super();
    }

    @Override
    public final Object call() {
        this.zzb.zzL().zzY();
        return new zzao(this.zzb.zzL().zzy(this.zza.zza));
    }
}

