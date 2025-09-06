package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;
import java.util.concurrent.Callable;

final class zziu implements Callable {
    final zzr zza;
    final Bundle zzb;
    final zzjc zzc;

    public zziu(zzjc zzjc0, zzr zzr0, Bundle bundle0) {
        this.zza = zzr0;
        this.zzb = bundle0;
        Objects.requireNonNull(zzjc0);
        this.zzc = zzjc0;
        super();
    }

    @Override
    public final Object call() {
        this.zzc.zzL().zzY();
        return this.zzc.zzL().zzap(this.zza, this.zzb);
    }
}

