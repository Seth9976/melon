package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzir implements Runnable {
    final zzbg zza;
    final String zzb;
    final zzjc zzc;

    public zzir(zzjc zzjc0, zzbg zzbg0, String s) {
        this.zza = zzbg0;
        this.zzb = s;
        Objects.requireNonNull(zzjc0);
        this.zzc = zzjc0;
        super();
    }

    @Override
    public final void run() {
        this.zzc.zzL().zzY();
        this.zzc.zzL().zzD(this.zza, this.zzb);
    }
}

