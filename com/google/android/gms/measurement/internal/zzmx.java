package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzmx implements Runnable {
    final zzga zza;
    final zzne zzb;

    public zzmx(zzne zzne0, zzga zzga0) {
        this.zza = zzga0;
        Objects.requireNonNull(zzne0);
        this.zzb = zzne0;
        super();
    }

    @Override
    public final void run() {
        zzne zzne0 = this.zzb;
        synchronized(zzne0) {
            zzne0.zzd(false);
            zznk zznk0 = zzne0.zza;
            if(!zznk0.zzh()) {
                zznk0.zzu.zzaV().zzk().zza("Connected to service");
                zznk0.zzL(this.zza);
            }
        }
    }
}

