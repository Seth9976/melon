package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzkk implements Runnable {
    final AtomicReference zza;
    final String zzb;
    final String zzc;
    final boolean zzd;
    final zzli zze;

    public zzkk(zzli zzli0, AtomicReference atomicReference0, String s, String s1, String s2, boolean z) {
        this.zza = atomicReference0;
        this.zzb = s1;
        this.zzc = s2;
        this.zzd = z;
        Objects.requireNonNull(zzli0);
        this.zze = zzli0;
        super();
    }

    @Override
    public final void run() {
        this.zze.zzu.zzt().zzt(this.zza, null, this.zzb, this.zzc, this.zzd);
    }
}

