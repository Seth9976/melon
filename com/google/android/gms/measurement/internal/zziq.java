package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zziq implements Runnable {
    final zzbg zza;
    final zzr zzb;
    final zzjc zzc;

    public zziq(zzjc zzjc0, zzbg zzbg0, zzr zzr0) {
        this.zza = zzbg0;
        this.zzb = zzr0;
        Objects.requireNonNull(zzjc0);
        this.zzc = zzjc0;
        super();
    }

    @Override
    public final void run() {
        zzbg zzbg0 = this.zzc.zzc(this.zza, this.zzb);
        this.zzc.zzb(zzbg0, this.zzb);
    }
}

