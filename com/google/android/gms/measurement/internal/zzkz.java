package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

final class zzkz implements Runnable {
    private final zzli zza;
    private final AtomicReference zzb;

    public zzkz(zzli zzli0, AtomicReference atomicReference0) {
        this.zza = zzli0;
        this.zzb = atomicReference0;
    }

    @Override
    public final void run() {
        Bundle bundle0 = this.zza.zzu.zzd().zzi.zza();
        this.zza.zzu.zzt().zzw(this.zzb, bundle0);
    }
}

