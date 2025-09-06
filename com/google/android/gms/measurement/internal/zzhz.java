package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzhz implements Runnable {
    final zzjr zza;
    final zzib zzb;

    public zzhz(zzib zzib0, zzjr zzjr0) {
        this.zza = zzjr0;
        Objects.requireNonNull(zzib0);
        this.zzb = zzib0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zzK(this.zza);
        this.zzb.zza(this.zza.zzd);
    }
}

