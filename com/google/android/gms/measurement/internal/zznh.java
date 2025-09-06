package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zznh implements Runnable {
    private final zznk zza;
    private final AtomicReference zzb;
    private final zzr zzc;
    private final zzon zzd;

    public zznh(zznk zznk0, AtomicReference atomicReference0, zzr zzr0, zzon zzon0) {
        this.zza = zznk0;
        this.zzb = atomicReference0;
        this.zzc = zzr0;
        this.zzd = zzon0;
    }

    @Override
    public final void run() {
        this.zza.zzT(this.zzb, this.zzc, this.zzd);
    }
}

