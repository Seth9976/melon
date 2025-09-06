package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzie implements Runnable {
    final zzr zza;
    final zzjc zzb;

    public zzie(zzjc zzjc0, zzr zzr0) {
        this.zza = zzr0;
        Objects.requireNonNull(zzjc0);
        this.zzb = zzjc0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zzL().zzY();
        this.zzb.zzL().zzah(this.zza);
    }
}

