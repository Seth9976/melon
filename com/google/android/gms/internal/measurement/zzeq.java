package com.google.android.gms.internal.measurement;

import java.util.Objects;

abstract class zzeq implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final zzfb zzk;

    public zzeq(zzfb zzfb0, boolean z) {
        Objects.requireNonNull(zzfb0);
        this.zzk = zzfb0;
        super();
        this.zzh = zzfb0.zza.currentTimeMillis();
        this.zzi = zzfb0.zza.elapsedRealtime();
        this.zzj = z;
    }

    @Override
    public final void run() {
        if(this.zzk.zzP()) {
            this.zzb();
            return;
        }
        try {
            this.zza();
        }
        catch(Exception exception0) {
            this.zzk.zzN(exception0, false, this.zzj);
            this.zzb();
        }
    }

    public abstract void zza();

    public void zzb() {
    }
}

