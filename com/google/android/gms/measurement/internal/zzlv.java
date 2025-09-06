package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzlv implements Runnable {
    final zzlt zza;
    final zzlt zzb;
    final long zzc;
    final boolean zzd;
    final zzma zze;

    public zzlv(zzma zzma0, zzlt zzlt0, zzlt zzlt1, long v, boolean z) {
        this.zza = zzlt0;
        this.zzb = zzlt1;
        this.zzc = v;
        this.zzd = z;
        Objects.requireNonNull(zzma0);
        this.zze = zzma0;
        super();
    }

    @Override
    public final void run() {
        this.zze.zzu(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}

