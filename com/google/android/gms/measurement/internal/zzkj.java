package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzkj implements Runnable {
    final AtomicReference zza;
    final String zzb;
    final String zzc;
    final zzli zzd;

    public zzkj(zzli zzli0, AtomicReference atomicReference0, String s, String s1, String s2) {
        this.zza = atomicReference0;
        this.zzb = s1;
        this.zzc = s2;
        Objects.requireNonNull(zzli0);
        this.zzd = zzli0;
        super();
    }

    @Override
    public final void run() {
        this.zzd.zzu.zzt().zzq(this.zza, null, this.zzb, this.zzc);
    }
}

