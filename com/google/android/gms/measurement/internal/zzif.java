package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzif implements Runnable {
    final String zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final zzjc zze;

    public zzif(zzjc zzjc0, String s, String s1, String s2, long v) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = s2;
        this.zzd = v;
        Objects.requireNonNull(zzjc0);
        this.zze = zzjc0;
        super();
    }

    @Override
    public final void run() {
        String s = this.zza;
        if(s == null) {
            this.zze.zzL().zzas(this.zzb, null);
            return;
        }
        zzlt zzlt0 = new zzlt(this.zzc, s, this.zzd);
        this.zze.zzL().zzas(this.zzb, zzlt0);
    }
}

