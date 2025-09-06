package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Executor;

final class zzju implements Executor {
    final zzli zza;

    public zzju(zzli zzli0) {
        Objects.requireNonNull(zzli0);
        this.zza = zzli0;
        super();
    }

    @Override
    public final void execute(Runnable runnable0) {
        this.zza.zzu.zzaW().zzj(runnable0);
    }
}

