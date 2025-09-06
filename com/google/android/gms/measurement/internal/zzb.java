package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzb implements Runnable {
    final String zza;
    final long zzb;
    final zzd zzc;

    public zzb(zzd zzd0, String s, long v) {
        this.zza = s;
        this.zzb = v;
        Objects.requireNonNull(zzd0);
        this.zzc = zzd0;
        super();
    }

    @Override
    public final void run() {
        this.zzc.zze(this.zza, this.zzb);
    }
}

