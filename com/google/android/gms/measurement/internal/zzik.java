package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Callable;

final class zzik implements Callable {
    final String zza;
    final String zzb;
    final String zzc;
    final zzjc zzd;

    public zzik(zzjc zzjc0, String s, String s1, String s2) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = s2;
        Objects.requireNonNull(zzjc0);
        this.zzd = zzjc0;
        super();
    }

    @Override
    public final Object call() {
        this.zzd.zzL().zzY();
        return this.zzd.zzL().zzj().zzs(this.zza, this.zzb, this.zzc);
    }
}

