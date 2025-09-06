package com.google.android.gms.internal.cast;

import java.util.concurrent.Executor;

final class zzux.zzd {
    zzux.zzd next;
    static final zzux.zzd zza;
    final Runnable zzb;
    final Executor zzc;

    static {
        zzux.zzd.zza = new zzux.zzd();
    }

    public zzux.zzd() {
        this.zzb = null;
        this.zzc = null;
    }

    public zzux.zzd(Runnable runnable0, Executor executor0) {
        this.zzb = runnable0;
        this.zzc = executor0;
    }
}

