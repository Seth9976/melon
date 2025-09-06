package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Callable;

final class zzij implements Callable {
    final String zza;
    final String zzb;
    final String zzc;
    final zzjc zzd;

    public zzij(zzjc zzjc0, String s, String s1, String s2) {
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
        return this.zzd.zzL().zzj().zzo(this.zza, this.zzb, this.zzc);
    }
}

