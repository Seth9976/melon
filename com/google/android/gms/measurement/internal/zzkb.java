package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;

final class zzkb implements Runnable {
    final String zza;
    final String zzb;
    final long zzc;
    final Bundle zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final String zzh;
    final zzli zzi;

    public zzkb(zzli zzli0, String s, String s1, long v, Bundle bundle0, boolean z, boolean z1, boolean z2, String s2) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = v;
        this.zzd = bundle0;
        this.zze = z;
        this.zzf = z1;
        this.zzg = z2;
        this.zzh = s2;
        Objects.requireNonNull(zzli0);
        this.zzi = zzli0;
        super();
    }

    @Override
    public final void run() {
        this.zzi.zzH(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh);
    }
}

