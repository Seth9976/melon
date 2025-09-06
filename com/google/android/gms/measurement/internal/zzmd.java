package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzmd extends zzgc {
    final AtomicReference zza;

    public zzmd(zznk zznk0, AtomicReference atomicReference0) {
        this.zza = atomicReference0;
        Objects.requireNonNull(zznk0);
        super();
    }

    @Override  // com.google.android.gms.measurement.internal.zzgd
    public final void zze(List list0) {
        synchronized(this.zza) {
            this.zza.set(list0);
            this.zza.notifyAll();
        }
    }
}

