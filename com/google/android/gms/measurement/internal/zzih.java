package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzih implements Runnable {
    final zzah zza;
    final zzjc zzb;

    public zzih(zzjc zzjc0, zzah zzah0) {
        this.zza = zzah0;
        Objects.requireNonNull(zzjc0);
        this.zzb = zzjc0;
        super();
    }

    @Override
    public final void run() {
        zzjc zzjc0 = this.zzb;
        zzjc0.zzL().zzY();
        zzah zzah0 = this.zza;
        if(zzah0.zzc.zza() == null) {
            zzjc0.zzL().zzak(zzah0);
            return;
        }
        zzjc0.zzL().zzai(zzah0);
    }
}

