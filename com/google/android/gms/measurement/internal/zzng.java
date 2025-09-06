package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

final class zzng implements Runnable {
    private final zznk zza;
    private final AtomicReference zzb;
    private final zzr zzc;
    private final Bundle zzd;

    public zzng(zznk zznk0, AtomicReference atomicReference0, zzr zzr0, Bundle bundle0) {
        this.zza = zznk0;
        this.zzb = atomicReference0;
        this.zzc = zzr0;
        this.zzd = bundle0;
    }

    @Override
    public final void run() {
        this.zza.zzS(this.zzb, this.zzc, this.zzd);
    }
}

