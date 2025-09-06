package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzme extends zzgf {
    final AtomicReference zza;
    final zznk zzb;

    public zzme(zznk zznk0, AtomicReference atomicReference0) {
        this.zza = atomicReference0;
        Objects.requireNonNull(zznk0);
        this.zzb = zznk0;
        super();
    }

    @Override  // com.google.android.gms.measurement.internal.zzgg
    public final void zze(zzop zzop0) {
        synchronized(this.zza) {
            this.zzb.zzu.zzaV().zzk().zzb("[sgtm] Got upload batches from service. count", zzop0.zza.size());
            this.zza.set(zzop0);
            this.zza.notifyAll();
        }
    }
}

