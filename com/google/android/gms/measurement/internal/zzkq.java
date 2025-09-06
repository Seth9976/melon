package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzkq implements Runnable {
    final AtomicReference zza;
    final zzli zzb;

    public zzkq(zzli zzli0, AtomicReference atomicReference0) {
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
                atomicReference0.set(this.zzb.zzu.zzc().zzo(s, zzfx.zzae));
            }
            catch(Throwable throwable0) {
                this.zza.notify();
                throw throwable0;
            }
        }
        this.zza.notify();
    }
}

