package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcn;

abstract class zzay {
    private final zzjf zza;
    private static volatile Handler zzb;
    private final Runnable zzc;
    private volatile long zzd;

    public zzay(zzjf zzjf0) {
        Preconditions.checkNotNull(zzjf0);
        this.zza = zzjf0;
        this.zzc = new zzax(this, zzjf0);
    }

    public abstract void zza();

    public final void zzb(long v) {
        this.zzd();
        if(v >= 0L) {
            zzjf zzjf0 = this.zza;
            this.zzd = zzjf0.zzaZ().currentTimeMillis();
            if(!this.zzf().postDelayed(this.zzc, v)) {
                zzjf0.zzaV().zzb().zzb("Failed to schedule delayed post. time", v);
            }
        }
    }

    public final boolean zzc() {
        return this.zzd != 0L;
    }

    public final void zzd() {
        this.zzd = 0L;
        this.zzf().removeCallbacks(this.zzc);
    }

    public final void zze(long v) {
        this.zzd = 0L;
    }

    private final Handler zzf() {
        if(zzay.zzb != null) {
            return zzay.zzb;
        }
        synchronized(zzay.class) {
            if(zzay.zzb == null) {
                zzay.zzb = new zzcn(this.zza.zzaY().getMainLooper());
            }
            return zzay.zzb;
        }
    }
}

