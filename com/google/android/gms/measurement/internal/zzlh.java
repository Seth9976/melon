package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzlh implements Runnable {
    private final zzli zza;
    private final AtomicReference zzb;

    public zzlh(zzli zzli0, AtomicReference atomicReference0) {
        this.zza = zzli0;
        this.zzb = atomicReference0;
    }

    @Override
    public final void run() {
        zznk zznk0 = this.zza.zzu.zzt();
        zzon zzon0 = zzon.zza(new zzlr[]{zzlr.zzd});
        zznk0.zzx(this.zzb, zzon0);
    }
}

