package com.google.android.gms.internal.cast;

import com.google.android.gms.common.util.DefaultClock;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzad {
    final long zza;
    long zzb;
    private long zzc;
    private final AtomicInteger zzd;
    private final int zze;

    public zzad(zzac zzac0) {
        this.zze = zzac0.zza;
        long v = DefaultClock.getInstance().currentTimeMillis();
        this.zza = v;
        this.zzb = v;
        this.zzd = new AtomicInteger(1);
    }

    public final zzqo zza() {
        zzqn zzqn0 = zzqo.zza();
        zzqn0.zzd(this.zze);
        zzqn0.zza(this.zzd.get());
        zzqn0.zzb(((int)(this.zza - this.zzc)));
        zzqn0.zzc(((int)(this.zzb - this.zzc)));
        return (zzqo)zzqn0.zzr();
    }

    public final void zzb() {
        this.zzd.incrementAndGet();
        this.zzb = DefaultClock.getInstance().currentTimeMillis();
    }

    public final void zzc(long v) {
        this.zzc = v;
    }
}

