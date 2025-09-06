package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zznw implements Runnable {
    final long zza;
    final long zzb;
    final zznx zzc;

    public zznw(zznx zznx0, long v, long v1) {
        Objects.requireNonNull(zznx0);
        this.zzc = zznx0;
        super();
        this.zza = v;
        this.zzb = v1;
    }

    @Override
    public final void run() {
        this.zzc.zza.zzu.zzaW().zzj(new zznv(this));
    }
}

