package com.google.android.gms.measurement.internal;

import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzmf implements Runnable {
    final zzr zza;
    final boolean zzb;
    final zzpk zzc;
    final zznk zzd;

    public zzmf(zznk zznk0, zzr zzr0, boolean z, zzpk zzpk0) {
        this.zza = zzr0;
        this.zzb = z;
        this.zzc = zzpk0;
        Objects.requireNonNull(zznk0);
        this.zzd = zznk0;
        super();
    }

    @Override
    public final void run() {
        zznk zznk0 = this.zzd;
        zzga zzga0 = zznk0.zzZ();
        if(zzga0 == null) {
            Z.u(zznk0.zzu, "Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zznk0.zzm(zzga0, (this.zzb ? null : this.zzc), this.zza);
        zznk0.zzV();
    }
}

