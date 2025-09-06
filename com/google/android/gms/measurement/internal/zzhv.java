package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzhv implements Thread.UncaughtExceptionHandler {
    final zzhy zza;
    private final String zzb;

    public zzhv(zzhy zzhy0, String s) {
        Objects.requireNonNull(zzhy0);
        this.zza = zzhy0;
        super();
        Preconditions.checkNotNull(s);
        this.zzb = s;
    }

    @Override
    public final void uncaughtException(Thread thread0, Throwable throwable0) {
        synchronized(this) {
            this.zza.zzu.zzaV().zzb().zzb(this.zzb, throwable0);
        }
    }
}

