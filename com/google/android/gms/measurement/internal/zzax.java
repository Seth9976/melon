package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzax implements Runnable {
    final zzjf zza;
    final zzay zzb;

    public zzax(zzay zzay0, zzjf zzjf0) {
        this.zza = zzjf0;
        Objects.requireNonNull(zzay0);
        this.zzb = zzay0;
        super();
    }

    @Override
    public final void run() {
        zzjf zzjf0 = this.zza;
        zzjf0.zzaU();
        if(zzae.zza()) {
            zzjf0.zzaW().zzj(this);
            return;
        }
        zzay zzay0 = this.zzb;
        boolean z = zzay0.zzc();
        zzay0.zze(0L);
        if(z) {
            zzay0.zza();
        }
    }
}

