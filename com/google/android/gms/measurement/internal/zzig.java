package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzig implements Runnable {
    final zzah zza;
    final zzr zzb;
    final zzjc zzc;

    public zzig(zzjc zzjc0, zzah zzah0, zzr zzr0) {
        this.zza = zzah0;
        this.zzb = zzr0;
        Objects.requireNonNull(zzjc0);
        this.zzc = zzjc0;
        super();
    }

    @Override
    public final void run() {
        zzjc zzjc0 = this.zzc;
        zzjc0.zzL().zzY();
        zzah zzah0 = this.zza;
        if(zzah0.zzc.zza() == null) {
            zzjc0.zzL().zzal(zzah0, this.zzb);
            return;
        }
        zzjc0.zzL().zzaj(zzah0, this.zzb);
    }
}

