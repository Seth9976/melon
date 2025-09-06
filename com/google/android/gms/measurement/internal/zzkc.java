package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzkc implements Runnable {
    final String zza;
    final String zzb;
    final Object zzc;
    final long zzd;
    final zzli zze;

    public zzkc(zzli zzli0, String s, String s1, Object object0, long v) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = object0;
        this.zzd = v;
        Objects.requireNonNull(zzli0);
        this.zze = zzli0;
        super();
    }

    @Override
    public final void run() {
        this.zze.zzN(this.zza, this.zzb, this.zzc, this.zzd);
    }
}

