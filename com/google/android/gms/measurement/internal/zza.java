package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zza implements Runnable {
    final String zza;
    final long zzb;
    final zzd zzc;

    public zza(zzd zzd0, String s, long v) {
        this.zza = s;
        this.zzb = v;
        Objects.requireNonNull(zzd0);
        this.zzc = zzd0;
        super();
    }

    @Override
    public final void run() {
        this.zzc.zzd(this.zza, this.zzb);
    }
}

