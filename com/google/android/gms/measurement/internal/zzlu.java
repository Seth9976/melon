package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;

final class zzlu implements Runnable {
    final Bundle zza;
    final zzlt zzb;
    final zzlt zzc;
    final long zzd;
    final zzma zze;

    public zzlu(zzma zzma0, Bundle bundle0, zzlt zzlt0, zzlt zzlt1, long v) {
        this.zza = bundle0;
        this.zzb = zzlt0;
        this.zzc = zzlt1;
        this.zzd = v;
        Objects.requireNonNull(zzma0);
        this.zze = zzma0;
        super();
    }

    @Override
    public final void run() {
        this.zze.zzt(this.zza, this.zzb, this.zzc, this.zzd);
    }
}

