package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzit implements Runnable {
    final zzpk zza;
    final zzr zzb;
    final zzjc zzc;

    public zzit(zzjc zzjc0, zzpk zzpk0, zzr zzr0) {
        this.zza = zzpk0;
        this.zzb = zzr0;
        Objects.requireNonNull(zzjc0);
        this.zzc = zzjc0;
        super();
    }

    @Override
    public final void run() {
        zzjc zzjc0 = this.zzc;
        zzjc0.zzL().zzY();
        zzpk zzpk0 = this.zza;
        if(zzpk0.zza() == null) {
            zzjc0.zzL().zzac(zzpk0.zzb, this.zzb);
            return;
        }
        zzjc0.zzL().zzab(zzpk0, this.zzb);
    }
}

