package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzkd implements Runnable {
    final AtomicReference zza;
    final zzli zzb;

    public zzkd(zzli zzli0, AtomicReference atomicReference0) {
        this.zza = atomicReference0;
        Objects.requireNonNull(zzli0);
        this.zzb = zzli0;
        super();
    }

    @Override
    public final void run() {
        AtomicReference atomicReference0 = this.zza;
        synchronized(atomicReference0) {
            try {
                String s = this.zzb.zzu.zzv().zzj();
                atomicReference0.set(Boolean.valueOf(this.zzb.zzu.zzc().zzp(s, zzfx.zzaa)));
            }
            catch(Throwable throwable0) {
                this.zza.notify();
                throw throwable0;
            }
        }
        this.zza.notify();
    }
}

