package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzmz implements Runnable {
    final zzga zza;
    final zzne zzb;

    public zzmz(zzne zzne0, zzga zzga0) {
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
                zznk0.zzu.zzaV().zzj().zza("Connected to remote service");
                zznk0.zzL(this.zza);
            }
        }
        zznk zznk1 = this.zzb.zza;
        if(zznk1.zzab() != null) {
            zznk1.zzab().shutdownNow();
            zznk1.zzac(null);
        }
    }
}

