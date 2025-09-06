package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzle implements Runnable {
    private final zzli zza;
    private final Bundle zzb;

    public zzle(zzli zzli0, Bundle bundle0) {
        this.zza = zzli0;
        this.zzb = bundle0;
    }

    @Override
    public final void run() {
        this.zza.zzag(this.zzb);
    }
}

