package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzio implements Runnable {
    final zzr zza;
    final zzjc zzb;

    public zzio(zzjc zzjc0, zzr zzr0) {
        this.zza = zzr0;
        Objects.requireNonNull(zzjc0);
        this.zzb = zzjc0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zzL().zzY();
        zzpf zzpf0 = this.zzb.zzL();
        zzpf0.zzaW().zzg();
        zzpf0.zzu();
        Preconditions.checkNotEmpty(this.zza.zza);
        zzpf0.zzv(this.zza);
        zzpf0.zzw(this.zza);
    }
}

